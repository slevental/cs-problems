package timus;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Stas on 12/21/15.
 */
public class DecimationDifferent {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        scanner.nextLine();
        String input = scanner.nextLine();

        Path min = null;
        Path[][] memo = new Path[n + 1][k + 1];

        process(new HashMap<>(),input, 9, n, memo);

        for (int i = 0; i <= k; i++) {
            Path output = process(new HashMap<>(), input, i, n, memo);
            if (min == null || output.min < min.min) min = output;
            if (output.min == 0) break;
        }

        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        out.println(min.min);
        int size = 0;
        int[] positions = new int[n + 1];
        for (Map.Entry<Integer, Integer> each : min.path.entrySet()) {
            if (each.getValue() > 0) {
                size += each.getValue();
                positions[each.getKey()] = each.getValue();
            }
        }
        out.print(size);

        int offset = 0;
        for (int i = 1; i < positions.length - 1; i++) {
            int position = positions[i];
            while (position-- > 0) {
                int p = i + offset++;
                out.print(" " + p);
            }
        }
        out.println();
        out.flush();
    }

    private static Path process(Map<Integer, Integer> positions, String input, int k, int n, Path[][] memo) {
        if (memo[n][k] != null)
            return memo[n][k];

        Path min = null;
        int j = 0;

        for (int i = 0; i <= k; i++) {
            if (k - i == 0) positions.remove(n);
            else positions.put(n, k - i);
            Path subMin = n == 1
                    ? new Path(0, new HashMap<>(positions))
                    : process(positions, input, i, n - 1, memo);
            positions.remove(n);

            int fined = (n + k + input.charAt(n - 1) - '1') / 10;
            int skipped = (n + i - 1) / 10;
            int currFine = subMin.min - skipped + fined;

            if (min == null || min.min > currFine) {
                min = subMin;
                min.min = currFine;
                j = i;
            }
        }

        Map<Integer, Integer> copy = new HashMap<>(min.path);
        if (k - j == 0) copy.remove(n);
        else copy.put(n, k - j);
        return memo[n][k] = new Path(min.min, copy);
    }

    static class Path {
        int min;
        final Map<Integer, Integer> path;

        Path(int min, Map<Integer, Integer> path) {
            this.min = min;
            this.path = path;
        }
    }
}

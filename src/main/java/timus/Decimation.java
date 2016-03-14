package timus;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

import static java.util.Arrays.fill;

/**
 * Created by Stas on 12/21/15.
 */
public class Decimation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        scanner.nextLine();
        String input = scanner.nextLine();

        int min = Integer.MAX_VALUE;
        int minimalK = 0;
        Path[][] memo = new Path[n + 1][k + 1];

        for (int i = 0; i <= k; i++) {
            Path output = process(input, i, n, memo);
            if (output.cost < min) {
                min = output.cost;
                minimalK = i;
            }
            if (output.cost == 0) break;
        }

        out.println(min);
        int[] positions = new int[n + 1];
        dfs(n, minimalK, memo, positions, min);

        int size = 0;
        for (int i = 1; i < positions.length - 1; i++)
            if (positions[i] > 0) size += positions[i];
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

    private static int dfs(int n, int k, Path[][] memo, int[] path, int min) {
        if (k < 0) return -1;
        if (n == 1) {
            path[n] = k;
            return 0;
        } else for (int i = memo[n].length - 1; i > 0; i--) {
            if (memo[n][i] != null && memo[n][i].cost == min) {
                path[n] = k - i;
                int dfs = dfs(n - 1, k - path[n], memo, path, memo[n][i].cost);
                if (dfs == 0) return 0;
                path[n] = 0;
            }
        }
        return -1;
    }

    private static Path process(String input, int k, int n, Path[][] memo) {
        if (memo[n][k] != null)
            return memo[n][k];

        Path min = null;
        for (int i = 0; i <= k; i++) {
            Path subMin = n == 1 ? new Path(0)
                    : process(input, i, n - 1, memo);
            int fined = (n + k + input.charAt(n - 1) - '1') / 10;
            int skipped = (n + i - 1) / 10;
            int currFine = subMin.cost - skipped + fined;
            if (min == null || min.cost > currFine) {
                min = subMin;
                min.cost = currFine;
            }
        }
        return memo[n][k] = new Path(min.cost);
    }

    private static class Path {
        int cost;

        public Path(int cost) {
            this.cost = cost;
        }
    }
}

package cs101;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Stas on 10/14/15.
 */
public class CellInGrid {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        scanner.nextLine();
        int n = scanner.nextInt();
        int[][] x = new int[m][n];
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                x[j][i] = scanner.nextInt();
            }
            if (j < m-1)
                scanner.nextLine();
        }

        System.out.println(findLongestConn(x, m, n));
    }

    static int findLongestConn(int[][] input, int m, int n) {
        int max = 0;
        BitSet visited = new BitSet();
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                int val = input[j][i];
                if (val == 0) continue;
                int coordinate = toInt(j, i, Math.max(m, n));
                if (visited.get(coordinate)) continue;
                Queue<Integer> bfs = new ArrayDeque<>();
                bfs.add(coordinate);
                int len = 0;
                while (!bfs.isEmpty()) {
                    Integer c = bfs.poll();
                    if (visited.get(c)) continue;
                    len++;
                    visited.set(c);
                    Set<Integer> next = getSiblings(input, c, m, n);
                    bfs.addAll(next.stream().filter(each -> !visited.get(each)).collect(Collectors.toList()));
                }
                max = Math.max(len, max);
            }
        }
        return max;
    }

    private static Set<Integer> getSiblings(int[][] input, Integer pos, int m, int n) {
        Set<Integer> res = new HashSet<>(8);
        int j = jFromInt(pos, Math.max(m, n));
        int i = iFromInt(pos, Math.max(m, n));
        for (int k = Math.max(0, j - 1); k < Math.min(m, j + 2); k++) {
            for (int l = Math.max(0, i - 1); l < Math.min(n, i + 2); l++) {
                if (input[k][l] == 1)
                    res.add(toInt(k, l, Math.max(m, n)));
            }
        }
        return res;
    }

    static int toInt(int j, int i, int m) {
        return j * m + i;
    }

    static int jFromInt(int val, int m) {
        return val / m;
    }

    static int iFromInt(int val, int m) {
        return val % m;
    }

}

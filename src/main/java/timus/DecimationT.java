package timus;

import java.util.Scanner;

/**
 * Created by Stas on 12/22/15.
 */
public class DecimationT {
    public static final int N = 10005;
    public static final int M = 55;

    private int[][] ans = new int[N][M];
    private int[][] fx = new int[N][M];
    private int[][] fy = new int[N][M];
    private String s;
    private int n;
    private int m;

    void dfs(int l1, int l2) {
        if (fy[l1][l2] >= 1) dfs(fx[l1][l2], fy[l1][l2]);
        if (fy[l1][l2] == l2 - 1) {
            System.out.print(" " + (l1 + l2));
        }
    }

    public static void main(String[] args) {
        DecimationT ds = new DecimationT();
        Scanner scanner = new Scanner(System.in);
        ds.n = scanner.nextInt();
        ds.m = scanner.nextInt();
        scanner.nextLine();
        ds.s = scanner.nextLine();
        ds.run();
    }

    private void run() {
        for (int j = 0; j <= m; ++j) {
            ans[0][j] = j / 10;
            fx[0][j] = 0;
            fy[0][j] = j - 1;
        }
        for (int i = 1; i <= n; ++i) {
            ans[i][0] = ans[i - 1][0];
            if (i % 10 == 0 && s.charAt(i - 1) == '1')
                ++ans[i][0];
        }
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= m; ++j) {

                ans[i][j] = ans[i - 1][j];
                if (s.charAt(i - 1) == '1' && (i + j) % 10 == 0)
                    ++ans[i][j];
                fx[i][j] = i - 1;
                fy[i][j] = j;

                int temp = ((i + j) % 10 != 0) ? 0 : 1;
                if (ans[i][j - 1] + temp < ans[i][j]) {
                    ans[i][j] = ans[i][j - 1] + temp;
                    fx[i][j] = i;
                    fy[i][j] = j - 1;
                }
            }
        }
        int l2 = 0;
        for (int j = 1; j <= m; ++j)
            if (ans[n][j] < ans[n][l2])
                l2 = j;
        System.out.println(ans[n][l2]);
        System.out.println(l2);
        dfs(n, l2);
        System.out.println();
    }
}

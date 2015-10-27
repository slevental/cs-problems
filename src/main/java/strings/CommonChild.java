package strings;

import java.util.Scanner;

/**
 * Created by Stas on 8/12/15.
 */
public class CommonChild {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(commonChild(scanner.nextLine(), scanner.nextLine()));
    }

    static int commonChild(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[][] mx = new int[m][n];
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0) mx[i][j] = Math.max(mx[i - 1][j], mx[i][j]);
                if (j > 0) mx[i][j] = Math.max(mx[i][j - 1], mx[i][j]);
                if (s1.charAt(i) == s2.charAt(j)) mx[i][j] = Math.min(j + 1, Math.min(mx[i][j] + 1, i + 1));
                max = Math.max(max, mx[i][j]);
            }
        }
        return max;
    }

}

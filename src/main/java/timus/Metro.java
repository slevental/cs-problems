package timus;

import java.util.Scanner;

/**
 * Created by Stas on 10/21/15.
 */
public class Metro {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int size = scanner.nextInt();
        boolean[][] diagonal = new boolean[n + 1][m + 1];
        while (size-- > 0) diagonal[scanner.nextInt()][scanner.nextInt()] = true;
        System.out.println((int)Math.round(findWay(n, m, diagonal, new double[n + 1][m + 1])));
    }

    private static double findWay(int n, int m, boolean[][] diagonal, double[][] ints) {
        double res = ints[n][m];
        if (res != 0)
            return res;

        if (n == 0 && m == 0)
            return 0;
        else if (n == 0)
            return ints[n][m] = m * 100;
        else if (m == 0)
            return ints[n][m] = n * 100;

        res = 100 + findWay(n - 1, m, diagonal, ints);
        if (diagonal[n][m]) res = Math.min(res, 100 * Math.sqrt(2) + findWay(n - 1, m - 1, diagonal, ints));
        res = Math.min(res, 100 + findWay(n, m - 1, diagonal, ints));
        return ints[n][m] = res;
    }


}

package timus;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Stas on 10/21/15.
 */
public class SqCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        memo[0] = 0;
        memo[1] = 1;
        System.out.println(divide(n, memo));
    }

    private static int divide(int n, int[] memo) {
        int res = memo[n];
        if (res >= 0)
            return res;

        res = Integer.MAX_VALUE;
        int a = (int) Math.floor(Math.sqrt(n));
        for (int i = a; i > 0; i--) {
            res = Math.min(res, divide(n - i * i, memo) + 1);
        }

        return memo[n] = res;
    }


}

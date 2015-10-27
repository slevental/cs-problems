package timus;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Stas on 10/21/15.
 */
public class Flags {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(flags(n, new long[n + 1]));
    }

    private static long flags(int n, long[] memo) {
        if (n == 0) return 1;
        if (n == 1) return 2;
        if (n == 2) return 2;
        if (n == 3) return 4;
        if (memo[n] != 0) return memo[n];
        return memo[n] = flags(n - 1, memo) + flags(n - 2, memo);
    }
}

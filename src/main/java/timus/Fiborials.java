package timus;

import java.util.Scanner;

/**
 * Created by Stas on 11/18/15.
 */
public class Fiborials {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int mod = 1000000007;

        for (int i = 0; i < 20; i++)
            System.out.printf("f(%d) = %d\n", i, divs(f(i)) % mod);
    }

    private static long f(int n) {
        if (n == 0 || n == 1) return 1;
        return f(n - 1) * f(n - 2) * n;
    }

    private static long divs(long f) {
        long res = 2;
        for (int i = 2; i < f; i++) {
            if (f % i == 0) res++;
        }
        return res;
    }
}

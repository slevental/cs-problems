package math;

import java.util.Scanner;

/**
 * Created by Stas on 8/6/15.
 */
public class MatrixTraversal {
    public static final long max = 1000000007;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        while (size-- > 0) {
            scanner.nextLine();
            System.out.println(getPathEstimation(scanner.nextInt(), scanner.nextInt()));
        }
    }

    public static long getPathEstimation(int n, int m) {
        return comb(n + m - 2, m - 1, max);
    }

    /**
     * Returns nCr mod m
     */
    public static long comb(long n, long r, long m) {
        long p1 = 1, p2;

        for (long i = r + 1; i <= n; i++) {
            p1 = (p1 * i) % m;
        }

        p2 = factMod(n - r, m);
        p1 = divMod(p1, p2, m);

        return p1 % m;
    }

    /**
     * Returns a/b mod m, works only if m is prime and b divides a
     */
    public static long divMod(long a, long b, long m) {
        long c = powerMod(b, m - 2, m);
        return ((a % m) * (c % m)) % m;
    }

    /**
     * Calculates factorial(n) mod m
     */
    public static long factMod(long n, long m) {
        long result = 1;

        if (n <= 1)
            return 1;

        while (n != 1) {
            result = ((result * n--) % m);
        }
        return result;
    }

    /**
     * This method takes a, b and c as inputs and returns (a ^ b) mod c
     */
    public static long powerMod(long a, long b, long c) {
        long result = 1;
        long temp = 1;
        long mask = 1;

        for (int i = 0; i < 64; i++) {
            mask = (i == 0) ? 1 : (mask * 2);
            temp = (i == 0) ? (a % c) : (temp * temp) % c;

			/* Check if (i + 1)th bit of power b is set */
            if ((b & mask) == mask) {
                result = (result * temp) % c;
            }
        }
        return result;
    }
}

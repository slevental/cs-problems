package google;

import java.math.BigInteger;

import static java.lang.Math.floor;
import static java.lang.Math.pow;

/**
 * Created by Stas on 8/16/15.
 */
public class MinionBoardGameMathSolution {
    public static int answer(int t, int n) {
        return (int) answer(t * n - n * n - t + 2 * n, t - 1, 123454321);
    }

    /**
     * Returns nCr mod m
     */
    public static long answer(long n, long r, long m) {
        if (r == 1) return n;
        if (r == 0 || r == n) return 1;
        if (r > n) return 1;
        r = Math.min(r, n - r);

        BigInteger mod = BigInteger.valueOf(m);
        BigInteger part1 = CabModPpower2(n, r, 41, 2);
        BigInteger part2 = CabModPpower2(n, r, 271, 2);
        if (part1 != null && part2 != null) {
            BigInteger b1 = BigInteger.valueOf(73441);
            BigInteger b2 = BigInteger.valueOf(1681);
            BigInteger x1 = b1.modInverse(b2);
            BigInteger x2 = b2.modInverse(b1);
            BigInteger z1 = part1.multiply(b1).multiply(x1);
            BigInteger z2 = part2.multiply(b2).multiply(x2);
            return z1.add(z2).mod(mod).longValue();
        }
        return c(n, r, 123454321).longValue();
    }


    private static BigInteger CabModPpower2(long a, long b, int p, int k) {
        if (a == b) return BigInteger.ONE;
        int pInK = (int) pow(p, k);

        //according to Lucas generalized theorem
        long n = a / pInK, m = b / pInK, n0 = a - n, m0 = b - n;
        if (n == 0 || m == 0)
            return c(a, b, pInK);

        long nextA = n * ((long) pow(p, floor((k - 1) / 3.)));
        long nextB = m * ((long) pow(p, floor((k - 1) / 3.)));
        return c(nextA, nextB, pInK).multiply(c(n0, m0, pInK));
    }

    private static BigInteger c(long a, long b, int p) {
        if (b == 1) return BigInteger.valueOf(a);
        if (b == 0 || b == a) return BigInteger.ONE;
        if (b > a) return BigInteger.ONE;
        b = Math.min(b, a - b);

        int sqrt = (int) Math.sqrt(p);
        BigInteger mod = BigInteger.valueOf(p);
        long pInA = countP(a, sqrt) - countP(b, sqrt) - countP(a - b, sqrt);
        BigInteger pLeft = BigInteger.valueOf((long) Math.pow(sqrt, pInA));
        BigInteger div = factorialSkipAllMod(b, p).multiply(factorialSkipAllMod(a - b, p));
        return pLeft.divide(div).multiply(factorialSkipAllMod(a, p)).mod(mod.divide(mod.gcd(div)));
    }

    private static BigInteger factorialSkipAllMod(long n, int mod) {
        BigInteger result = BigInteger.ONE;
        BigInteger m = BigInteger.valueOf(mod);

        if (n <= 1) return result;
        while (n != 1) {
            result = result.multiply(BigInteger.valueOf(n--));
            result = result.mod(m).equals(BigInteger.ZERO) ? result.divide(m) : result.mod(m);
        }
        return result;
    }

    private static long countP(long n, long p) {
        long res = n % p == 0 ? n / p : 0;
        while (n-- > 0)
            if (n % p == 0) res += n / p;
        return res;
    }
}

package google;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import static java.math.BigInteger.*;

/**
 * Created by Stas on 8/18/15.
 */
public class BreadingProblem {

    public static final BigInteger TWO = valueOf(2);

    public static String answer(String in) {
        BigInteger number = new BigInteger(in);
        Map<BigInteger, BigInteger> buff = new HashMap<>();
        String res = search(number, buff, false);
        if (res != null) return res;
        res = search(number, buff, true);
        if (res != null) return res;

        return "None";
    }

    private static String search(BigInteger number, Map<BigInteger, BigInteger> buff, boolean even) {
        BigInteger lo = ZERO, hi = number;
        while (lo.compareTo(hi) <= 0) {
            BigInteger mid = hi.add(lo).shiftRight(1);
            BigInteger mod = mid.mod(TWO);
            if (even) mid = mid.add(mod);
            else mid = mid.add(ONE.subtract(mod));
            int cmp = number.compareTo(R(mid, buff));
            if (cmp == 0) return mid.toString();
            if (lo.compareTo(hi) == 0) return null;
            if (cmp > 0) lo = mid.add(ONE);
            if (cmp < 0) hi = mid.subtract(ONE);
        }
        return null;
    }

    /**
     * R(0) = 1
     * R(1) = 1
     * R(2) = 2
     * R(2n) = R(n) + R(n + 1) + n (for n > 1)
     * R(2n + 1) = R(n - 1) + R(n) + 1 (for n >= 1)
     */
    static BigInteger R(BigInteger n, Map<BigInteger, BigInteger> buff) {
        if (n.compareTo(TWO) < 0) return BigInteger.ONE;
        if (n.equals(TWO)) return TWO;
        BigInteger b = buff.get(n);
        if (b != null) return b;
        if (n.mod(TWO).equals(ZERO)) {
            BigInteger k = n.divide(TWO);
            b = R(k.add(ONE), buff).add(R(k, buff)).add(k);
        } else {
            BigInteger k = (n.subtract(ONE).divide(TWO));
            b = R(k, buff).add(R(k.subtract(ONE), buff)).add(ONE);
        }
        buff.put(n, b);
        return b;
    }
}

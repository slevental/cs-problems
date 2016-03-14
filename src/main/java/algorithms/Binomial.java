package algorithms;

/**
 * Created by Stas on 11/18/15.
 */
public class Binomial {

    public static long nCk(int n, int k, int mod) {
        return 1l;
    }

    public static long gcd(long a, long b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        System.out.println(gcd(111111111111L,333333333333L));
    }
}

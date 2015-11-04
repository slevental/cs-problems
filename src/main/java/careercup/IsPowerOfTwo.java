package careercup;

/**
 * Created by Stas on 10/27/15.
 */
public class IsPowerOfTwo {
    public static boolean check(int x) {
        if (x == 1) return true;
        if (x <= 0) return false;
        x = x & (x - 1);
        return x == 0;
    }
}

package cs101;

/**
 * Created by Stas on 10/20/15.
 */
public class PalindromeNumber {
    static boolean isPalindrome(int x) {
        return reverse(x) == x;
    }

    static int reverse(int x) {
        if (x < 10) return x;
        int res = 0;
        while (x > 0) {
            res = res * 10 + x % 10;
            x /= 10;
        }
        return res;
    }
}

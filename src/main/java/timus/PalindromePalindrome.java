package timus;

import java.util.Scanner;

/**
 * Created by Stas on 10/20/15.
 */
public class PalindromePalindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String size = scanner.next();
        System.out.println(find(size));
    }

    static String find(String in) {
        int newLen = in.length() + 1;
        while (newLen < in.length() * 2) {
            int center = newLen >> 1;
            int lo = newLen % 2 == 0
                    ? palindromeCenter(in, center - 1, center)
                    : palindromeCenter(in, center, center);
            if (lo >= 0)
                return build(in, lo - 1);

            newLen++;
        }
        return build(in, in.length() - 1);
    }

    private static String build(String in, int pos) {
        StringBuilder sb = new StringBuilder(in);
        for (int i = pos; i >= 0; i--)
            sb.append(sb.charAt(i));
        return sb.toString();
    }

    static int palindromeCenter(String str, int lo, int hi) {
        if (str.charAt(lo) != str.charAt(hi))
            return -1;

        while (str.charAt(lo) == str.charAt(hi)) {
            if (hi == str.length() - 1)
                return lo;
            if (lo == 0)
                return -1;
            lo--;
            hi++;
        }

        return -1;
    }
}

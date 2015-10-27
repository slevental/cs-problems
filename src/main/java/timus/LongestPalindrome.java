package timus;

import java.util.Scanner;

/**
 * Created by Stas on 10/20/15.
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String size = scanner.next();
        System.out.println(find(size));
    }

    static String find(String in) {
        String longest = in.substring(0, 1);
        for (int i = 0; i < in.length() - 1; i++) {
            String cand = expand(in, i, i);
            if (cand.length() > longest.length())
                longest = cand;
            cand = expand(in, i, i + 1);
            if (cand.length() > longest.length())
                longest = cand;
        }
        return longest;
    }

    static String expand(String str, int lo, int hi) {
        if (str.charAt(lo) != str.charAt(hi))
            return String.valueOf(str.charAt(lo));

        while (lo > 0 && hi < str.length() - 1 && str.charAt(lo - 1) == str.charAt(hi + 1)) {
            lo--;
            hi++;
        }

        return str.substring(lo, hi + 1);
    }
}

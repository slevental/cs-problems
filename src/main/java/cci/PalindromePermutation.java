package cci;

/**
 * Created by Stas on 11/3/15.
 */
public class PalindromePermutation {
    public static boolean isPalindromePermutation(String str) {
        int[] c = count(str);
        for (int i = 0, sum = 0; i < c.length; i++) {
            if ((sum += c[i] % 2) > 1) return false;
        }
        return true;
    }

    private static int[] count(String str) {
        int[] res = new int[255];
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == ' ') continue;
            res[c]++;
        }
        return res;
    }
}

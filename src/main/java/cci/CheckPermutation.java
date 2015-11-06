package cci;

import java.util.Arrays;

/**
 * Created by Stas on 11/3/15.
 */
public class CheckPermutation {
    public static boolean arePermutations(String s1, String s2) {
        if (s1.isEmpty()) return s2.isEmpty();
        if (s2.isEmpty()) return s1.isEmpty();

        int[] count1 = count(s1);
        int[] count2 = count(s2);

        return Arrays.equals(count1, count2);
    }

    private static int[] count(String s1) {
        int[] chars = new int[255];
        for (int i = 0; i < s1.length(); i++) {
            chars[s1.charAt(i)]++;
        }
        return chars;
    }
}

package cci;

/**
 * Created by Stas on 11/3/15.
 */
public class OneAway {
    public static boolean isOneAway(String s1, String s2) {
        int[] count1 = count(s1);
        int[] count2 = count(s2);
        for (int i = 0, diff = Math.abs(s1.length() - s2.length()); i < count2.length; i++) {
            if ((diff += Math.abs(count2[i] - count1[i])) > 2) return false;
        }
        return true;
    }

    private static int[] count(String s1) {
        int[] chars = new int[255];
        for (int i = 0; i < s1.length(); i++) {
            chars[s1.charAt(i)]++;
        }
        return chars;
    }
}

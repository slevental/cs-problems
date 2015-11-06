package cci;

/**
 * Created by Stas on 11/3/15.
 */
public class IsUnique {
    public static boolean isUnique(String str) {
        if (str.length() <= 1) return true;
        StringBuilder s = new StringBuilder(str);
        quickSort(s, 0, s.length() - 1);
        for (int i = 1; i < s.length(); i++)
            if (s.charAt(i) == s.charAt(i - 1))
                return false;
        return true;
    }

    private static void quickSort(StringBuilder s, int lo, int hi) {
        if (lo < hi) {
            int pivot = partition(s, lo, hi);
            quickSort(s, lo, pivot);
            quickSort(s, pivot + 1, hi);
        }
    }

    private static int partition(StringBuilder s, int lo, int hi) {
        char pivot = s.charAt(lo);
        lo--;
        hi++;
        while (lo < hi) {
            while (pivot > s.charAt(++lo)) ;
            while (pivot < s.charAt(--hi)) ;
            if (lo < hi) swap(s, lo, hi);
        }
        return hi;
    }

    private static void swap(StringBuilder s, int lo, int hi) {
        char c = s.charAt(lo);
        s.setCharAt(lo, s.charAt(hi));
        s.setCharAt(hi, c);
    }


}

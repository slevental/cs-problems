package cs101;

import static java.lang.Math.max;
import static java.lang.Math.min;

/**
 * Created by Stas on 9/25/15.
 */
public class Median {
    public static double median(int[] arr) {
        return median(arr, 0, arr.length);
    }

    public static double median(int[] arr, int lo, int hi) {
        int len = hi - lo;
        return len % 2 == 0 ? (arr[lo + len / 2 - 1] + arr[lo + len / 2]) / 2. : arr[lo + len / 2];
    }

    public static double median(int[] arr1, int[] arr2) {
        return median(arr1, 0, arr1.length, arr2, 0, arr2.length);
    }

    private static double median(int[] arr1, int lo1, int hi1, int[] arr2, int lo2, int hi2) {
        assert arr1.length == arr2.length;
        assert hi1 - lo1 == hi2 - lo2;
        int n = hi1 - lo1; // == h2-lo2
        if (n == 2) return (max(arr1[lo1], arr2[lo2]) + min(arr1[lo1+1], arr2[lo2+1])) / 2.;
        double m1 = median(arr1, lo1, hi1);
        double m2 = median(arr2, lo2, hi2);
        if (m1 == m2) return m1;
        if (m1 <  m2) return median(arr1, lo1 + n/2, hi1, arr2, lo2, lo2 + n/2 + n%2);
        if (m1 >  m2) return median(arr1, lo1, lo1 + n/2 + n%2, arr2, lo2 + n/2, hi2);
        return -1;
    }
}

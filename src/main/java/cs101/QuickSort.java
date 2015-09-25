package cs101;

/**
 * Created by Stas on 9/25/15.
 */
public class QuickSort {
    public static void quickSort(int[] arr, int lo, int hi) {
        if (lo < hi) {
            int p = partition(arr, lo, hi);
            quickSort(arr, lo, p);
            quickSort(arr, p + 1, hi);
        }
    }

    public static int partition(int[] arr, int lo, int hi) {
        int p = lo;
        lo--; hi++;
        while (lo < hi) {
            while (arr[++lo] < arr[p]);
            while (arr[--hi] > arr[p]);
            if (lo >= hi) break;
            swap(arr, lo, hi);
        }
        return hi;
    }

    private static void swap(int[] arr, int lo, int hi) {
        int val = arr[lo];
        arr[lo] = arr[hi];
        arr[hi] = val;
    }

    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length-1);
    }
}

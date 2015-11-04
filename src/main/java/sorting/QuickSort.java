package sorting;

/**
 * Created by Stas on 9/25/15.
 */
public class QuickSort {
    public static void quickSort(int[] arr, int lo, int hi) {
        if (lo < hi) {
            int pivot = partition(arr, lo, hi);
            quickSort(arr, lo, pivot);
            quickSort(arr, pivot + 1, hi);
        }
    }

    private static int partition(int[] arr, int lo, int hi) {
        int p = arr[(lo + hi) >> 1];
        lo--;
        hi++;
        while (lo < hi) {
            while (p > arr[++lo]) ;
            while (p < arr[--hi]) ;
            if (lo < hi) swap(arr, lo, hi);
        }
        return hi;
    }

    private static void swap(int[] arr, int lo, int hi) {
        int val = arr[lo];
        arr[lo] = arr[hi];
        arr[hi] = val;
    }

    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }
}

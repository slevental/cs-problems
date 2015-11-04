package sorting;

/**
 * Created by Stas on 10/27/15.
 */
public class MergeSort {

    public static void sort(int[] arr) {
        sort(arr, 0, arr.length);
    }

    private static void sort(int[] arr, int lo, int hi) {
        if (hi - lo > 1) {
            int mid = (lo + hi) >> 1;
            sort(arr, lo, mid);
            sort(arr, mid, hi);
            merge(arr, lo, hi, mid);
        }
    }

    private static void merge(int[] arr, int lo, int hi, int mid) {
        int[] res = new int[hi - lo];
        int k = 0;
        int j = mid;
        int i = lo;

        while (j < hi && i < mid) {
            if (arr[j] <= arr[i]) res[k++] = arr[j++];
            else res[k++] = arr[i++];
        }

        while (j < hi) res[k++] = arr[j++];
        while (i < mid) res[k++] = arr[i++];

        System.arraycopy(res, 0, arr, lo, hi - lo);
    }
}

package sorting;

/**
 * Created by Stas on 8/12/15.
 */
public class InsertionSort {

    public static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int k = i;
            while (k > 0 && arr[k] < arr[k - 1]) {
                swap(arr, k, k - 1);
                k--;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int x = arr[i];
        arr[i] = arr[j];
        arr[j] = x;
    }

}

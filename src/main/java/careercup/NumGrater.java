package careercup;

import java.util.stream.IntStream;

/**
 * Created by Stas on 11/7/15.
 */
public class NumGrater {
    public static int[] numGrater(int[] arr) {
        Num[] tmp = new Num[arr.length];
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = new Num(arr[i], i);
        }

        mergeSort(tmp, 0, tmp.length);

        for (int i = 0; i < tmp.length; i++) {
            arr[tmp[i].pos] = tmp[i].size;
        }

        return arr;
    }

    private static void mergeSort(Num[] arr, int lo, int hi) {
        if (hi - lo > 1) {
            int mid = (lo + hi) >>> 1;
            mergeSort(arr, lo, mid);
            mergeSort(arr, mid, hi);
            merge(arr, lo, hi, mid);
        }
    }

    private static void merge(Num[] arr, int lo, int hi, int mid) {
        Num[] res = new Num[hi - lo];
        int i = lo, j = mid, k = 0;

        while (i < mid && j < hi) {
            if (arr[i].value < arr[j].value) {
                res[k] = arr[i++];
                res[k++].size += hi - j;
            } else res[k++] = arr[j++];
        }

        while (i < mid) res[k++] = arr[i++];
        while (j < hi) res[k++] = arr[j++];

        System.arraycopy(res, 0, arr, lo, hi - lo);
    }

    static class Num {
        final int value;
        final int pos;
        int size;

        public Num(int value, int pos) {
            this.value = value;
            this.pos = pos;
        }
    }
}

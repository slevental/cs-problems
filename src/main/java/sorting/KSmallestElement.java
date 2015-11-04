package sorting;

/**
 * Created by Stas on 10/29/15.
 */
public class KSmallestElement {
    public static int kSmallest(int[] in, int v) {
        int lo = 0;
        v = v - 1;
        int hi = in.length - 1;
        int pivot = pivot(in, lo, hi);

        while (pivot != v) {
            if (pivot > v) hi = pivot - 1;
            else lo = pivot + 1;
            pivot = pivot(in, lo, hi);
        }

        return in[v];
    }

    private static int pivot(int[] in, int lo, int hi) {
        int pivot = in[lo];
        lo--;
        hi++;
        while (lo < hi) {
            while (pivot > in[++lo]) ;
            while (pivot < in[--hi]) ;
            if (lo < hi) swap(in, lo, hi);
        }
        return hi;
    }

    private static void swap(int[] in, int i, int j) {
        int buf = in[i];
        in[i] = in[j];
        in[j] = buf;
    }
}

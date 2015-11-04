package sorting;

/**
 * Created by Stas on 10/29/15.
 */
public class Count1s {
    public static int countOnes(int[] in) {
        int lo = 0, hi = in.length;
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (mid + 1 == in.length || (in[mid] == 1 && in[mid + 1] == 0))
                return mid + 1;
            else if (in[mid] == 0)
                hi = mid - 1;
            else lo = mid + 1;
        }
        return 0;
    }
}

package careercup;

import java.util.List;

/**
 * Created by Stas on 10/27/15.
 */
public class MinRange {

    public static int[] minRange(List<int[]> in) {
        int[] i = new int[in.size()];
        int[] minRange = null;

        for (int k = min(in, i); k >= 0; i[k]++) {
            int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
            for (int l = 0; l < in.size(); l++) {
                max = Math.max(in.get(l)[i[l]], max);
                min = Math.min(in.get(l)[i[l]], min);
            }
            if (minRange == null)
                minRange = new int[]{min, max};
            else if (max - min < minRange[1] - minRange[0]) {
                minRange[0] = min;
                minRange[1] = max;
            }
        }
        return minRange;

//        List 1: [4, 10, 15, 24, 26]
//        List 2: [0, 9, 12, 20]
//        List 3: [5, 18, 22, 30]

        // 0, 4, 5,
    }

    private static int min(List<int[]> in, int[] i) {
        int min = 0;
        for (int j = 0; j < in.size(); j++) {
            if (in.get(j)[i[j]] < in.get(min)[i[min]])
                min = j;
        }
        return min;
    }

}

package sorting;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stas on 10/29/15.
 */
public class CommonElements {
    public static Integer[] findCommon(int[] a1, int[] a2, int[] a3) {
        List<Integer> res = new ArrayList<>();
        int i = 0, j = 0, k = 0;
        while (i < a1.length && j < a2.length && k < a3.length) {
            if (a1[i] == a2[j] && a1[i] == a3[k]) {
                res.add(a1[i]);
                i++;
                j++;
                k++;
            } else if (a1[i] < a2[j]) i++;
            else if (a2[j] < a3[k]) j++;
            else k++;
        }
        return res.toArray(new Integer[res.size()]);
    }
}

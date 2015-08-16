package google;



/**
 * Created by Stas on 8/15/15.
 */
public class WhenItRainsItPours {
    public static int answer(int[] heights) {
        int len = heights.length, res = 0;
        int[] right = new int[len];
        int[] left = new int[len];

        for (int i = 1; i < len; i++)
            left[i] = Math.max(left[i - 1], heights[i - 1]);
        for (int i = len - 2; i > 0; i--)
            right[i] = Math.max(right[i + 1], heights[i + 1]);
        for (int i = 0; i < len; i++)
            res += Math.max(0, Math.min(left[i], right[i]) - heights[i]);
        return res;
    }
}

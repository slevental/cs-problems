package leetcode;

/**
 * Created by Stas on 10/25/15.
 */
public class ProduceExceptItself {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];

        left[0] = nums[0];
        right[nums.length - 1] = nums[nums.length - 1];
        for (int i = 1; i < nums.length; i++) left[i] = left[i - 1] * nums[i];
        for (int i = nums.length - 2; i >= 0; i--) right[i] = right[i + 1] * nums[i];
        for (int i = 0; i < nums.length; i++)
            result[i] = (i > 0 ? left[i - 1] : 1) * (i < nums.length - 1 ? right[i + 1] : 1);
        return result;
    }
}

package leetcode;

public class SingleNumber3 {
    public int[] singleNumber(int[] nums) {
        int x = 0, y = 0;
        for (int num : nums) {
            x ^= num;
        }

        int bit = x & ~(x - 1);
        x = 0;

        for (int num : nums) {
            if ((bit & num) > 0)
                x ^= num;
            else
                y ^= num;
        }

        return new int[]{x, y};
    }
}
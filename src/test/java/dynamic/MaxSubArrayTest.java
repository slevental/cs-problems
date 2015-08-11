package dynamic;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

import static org.junit.Assert.*;

/**
 * Created by Stas on 8/10/15.
 */
public class MaxSubArrayTest {

    static final int inputSize = 100000;
    static final int seed = 19;
    static final Random rnd = new Random(seed);

    @Test
    public void test_max_sub_array() throws Exception {
        assertArrayEquals(new int[]{10, 11}, MaxSubArray.maxSubArray(2, -1, 2, 3, 4, -5));
        assertArrayEquals(new int[]{5, 6}, MaxSubArray.maxSubArray(1, -1, -1, -1, -1, 5));
        assertArrayEquals(new int[]{1, 1}, MaxSubArray.maxSubArray(1));
        assertArrayEquals(new int[]{-1, -1}, MaxSubArray.maxSubArray(-1, -2, -3, -4, -5, -6));
        assertArrayEquals(new int[]{1, 1}, MaxSubArray.maxSubArray(1, -2));
        assertArrayEquals(new int[]{6, 6}, MaxSubArray.maxSubArray(1, 2, 3));
        assertArrayEquals(new int[]{-10, -10}, MaxSubArray.maxSubArray(-10));
        assertArrayEquals(new int[]{10, 10}, MaxSubArray.maxSubArray(1, 2, 3, 4));
        assertArrayEquals(new int[]{10, 10}, MaxSubArray.maxSubArray(1, 2, 3, 4));
    }

    @Test
    public void test_big_input() throws Exception {
        int[] input = new int[inputSize];
        for (int i = 0; i < inputSize; i++) {
            input[i] = rnd.nextInt();
        }
        System.out.println(Arrays.toString(MaxSubArray.maxSubArray(input)));
    }
}
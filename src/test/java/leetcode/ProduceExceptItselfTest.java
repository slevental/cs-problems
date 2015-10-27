package leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Stas on 10/25/15.
 */
public class ProduceExceptItselfTest {

    @Test
    public void test_solution() throws Exception {
        int[] res = new ProduceExceptItself().productExceptSelf(new int[]{1, 2, 3, 4});
        assertArrayEquals(new int[]{24, 12, 8, 6}, res);
    }
}
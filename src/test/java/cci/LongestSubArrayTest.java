package cci;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Stas on 11/7/15.
 */
public class LongestSubArrayTest {
    @Test
    public void test_subarrays() throws Exception {
        assertArrayEquals(new char[]{'2', 'a', 'b', '1'}, LongestSubArray.find(new char[]{
                '2', 'a', 'b', '1', 'c', 'a', 'x', '3'
        }));

    }
}
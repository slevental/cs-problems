package leetcode;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by Stas on 10/25/15.
 */
public class SingleNumber3Test {

    @Test
    public void test_solution() throws Exception {
        SingleNumber3 n = new SingleNumber3();
        int[] res = n.singleNumber(new int[]{7, 7, 5, 3, 1, 2, 1, 3, 2, 8});
        System.out.println(Arrays.toString(res));
    }
}
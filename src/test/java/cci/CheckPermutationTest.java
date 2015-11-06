package cci;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Stas on 11/3/15.
 */
public class CheckPermutationTest {

    @Test
    public void test_permutations() throws Exception {
        assertFalse(CheckPermutation.arePermutations("", "x"));
        assertFalse(CheckPermutation.arePermutations("x", ""));
        assertFalse(CheckPermutation.arePermutations("x", "xx"));
        assertFalse(CheckPermutation.arePermutations("xxxx", "xxx"));

        assertTrue(CheckPermutation.arePermutations("xyz", "xzy"));
        assertTrue(CheckPermutation.arePermutations("cba", "abc"));
    }
}
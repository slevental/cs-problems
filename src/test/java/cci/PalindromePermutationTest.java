package cci;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Stas on 11/3/15.
 */
public class PalindromePermutationTest {

    @Test
    public void test_solution() throws Exception {
        assertTrue(PalindromePermutation.isPalindromePermutation("cca"));
        assertTrue(PalindromePermutation.isPalindromePermutation("abcbca"));
        assertTrue(PalindromePermutation.isPalindromePermutation("tact coa"));

        assertFalse(PalindromePermutation.isPalindromePermutation("aaac"));
        assertFalse(PalindromePermutation.isPalindromePermutation("abc"));
        assertFalse(PalindromePermutation.isPalindromePermutation("ab"));
    }
}
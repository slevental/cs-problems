package cs101;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Stas on 10/20/15.
 */
public class PalindromeNumberTest {
    @Test
    public void test_palindrom() throws Exception {
        assertTrue(PalindromeNumber.isPalindrome(121));//879
        assertTrue(PalindromeNumber.isPalindrome(11));//89
        assertTrue(PalindromeNumber.isPalindrome(1));//9
        assertTrue(PalindromeNumber.isPalindrome(1221));
        assertTrue(PalindromeNumber.isPalindrome(12121));
        assertTrue(PalindromeNumber.isPalindrome(2222));//5678
        assertTrue(PalindromeNumber.isPalindrome(0));
        assertFalse(PalindromeNumber.isPalindrome(22221));
    }
}
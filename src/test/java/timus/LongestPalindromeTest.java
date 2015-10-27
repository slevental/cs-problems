package timus;

import org.junit.Test;

import static org.junit.Assert.*;
import static timus.LongestPalindrome.find;

/**
 * Created by Stas on 10/20/15.
 */
public class LongestPalindromeTest {

    @Test
    public void test_longest_palindrome() throws Exception {
        assertEquals("ArozaupalanalapuazorA", find("ThesampletextthatcouldbereadedthesameinbothordersArozaupalanalapuazorA"));
        assertEquals("ArozaupalanalapuazorA", find("ThesampletextthatcouldbereadedtArozaupalanalapuazorAhesameinbothorders"));
        assertEquals("ArozaupalanalapuazorA", find("ArozaupalanalapuazorAThesampletextthatcouldbereadedthesameinbothorders"));
        assertEquals("A", find("ABCDLKOIKJTFIDCBA"));
    }
}
package strings;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Stas on 8/10/15.
 */
public class GameOfThronesTest {
    @Test
    public void test_palindrome_detection() throws Exception {
        assertFalse(GameOfThrones.couldBePalindrome("cdefghmnopqrstuvw"));
        assertTrue(GameOfThrones.couldBePalindrome("aaabbbb"));
        assertTrue(GameOfThrones.couldBePalindrome("cdcdcdcdeeeef"));
        assertFalse(GameOfThrones.couldBePalindrome("aaacbbbb"));
    }
}
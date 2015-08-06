package strings;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Stas on 8/5/15.
 */
public class AnagramsTest {
    @Test
    public void test_anagrams() throws Exception {
        assertEquals(4, Anagrams.anagramEditDistance("abc", "cde"));
    }
}
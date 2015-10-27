package cs101;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Stas on 10/20/15.
 */
public class LevenshteinTest {
    @Test
    public void test_distance() throws Exception {
        assertEquals(2, Levenshtein.distance("book", "back"));
        assertEquals(4, Levenshtein.distance("book", ""));
        assertEquals(4, Levenshtein.distance("book", "x"));
        assertEquals(3, Levenshtein.distance("book", "booking"));
        assertEquals(10, Levenshtein.distance("sdjhfgsdjhfkagsdfj", "baasdjhfgahjksdfg"));
    }
}
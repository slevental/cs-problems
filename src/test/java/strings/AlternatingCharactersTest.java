package strings;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Stas on 8/10/15.
 */
public class AlternatingCharactersTest {
    @Test
    public void test_alternating_characters() throws Exception {
        assertEquals(0, AlternatingCharacters.numberOfDeletions("A"));
        assertEquals(3, AlternatingCharacters.numberOfDeletions("AAAA"));
        assertEquals(4, AlternatingCharacters.numberOfDeletions("BBBBB"));
        assertEquals(0, AlternatingCharacters.numberOfDeletions("ABABABAB"));
        assertEquals(0, AlternatingCharacters.numberOfDeletions("BABABA"));
        assertEquals(4, AlternatingCharacters.numberOfDeletions("AAABBB"));
    }
}
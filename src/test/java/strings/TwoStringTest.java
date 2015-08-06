package strings;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Stas on 8/5/15.
 */
public class TwoStringTest {

    @Test
    public void test_two_strings() throws Exception {
        assertTrue(TwoString.hasCommonString("hello", "world"));
        assertFalse(TwoString.hasCommonString("hi", "world"));
    }
}
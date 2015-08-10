package algorithms;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Stas on 8/10/15.
 */
public class LonelyIntegerTest {
    @Test
    public void test_lonely_int() throws Exception {
        assertEquals(127, LonelyInteger.findLonelyInteger(7, 15, 127, 7, 15));
        assertEquals(2, LonelyInteger.findLonelyInteger(0, 0, 1, 2, 1));
        assertEquals(0, LonelyInteger.findLonelyInteger(2, 0, 1, 2, 1));
    }
}
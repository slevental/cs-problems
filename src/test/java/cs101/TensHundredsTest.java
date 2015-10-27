package cs101;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Stas on 10/16/15.
 */
public class TensHundredsTest {

    @Test
    public void testOnes() throws Exception {
        assertTrue(TensHundreds.isOne(1));
        assertTrue(TensHundreds.isOne(2));
        assertTrue(TensHundreds.isOne(4));
        assertTrue(TensHundreds.isOne(7));
        assertTrue(TensHundreds.isOne(11));
        assertTrue(TensHundreds.isOne(16));
        assertTrue(TensHundreds.isOne(28459741));
        assertTrue(TensHundreds.isOne(38311882));
        assertTrue(TensHundreds.isOne(61721606));

        assertFalse(TensHundreds.isOne(3));
        assertFalse(TensHundreds.isOne(5));
        assertFalse(TensHundreds.isOne(6));
        assertFalse(TensHundreds.isOne(8));
        assertFalse(TensHundreds.isOne(9));
        assertFalse(TensHundreds.isOne(10));
        assertFalse(TensHundreds.isOne(28459740));
        assertFalse(TensHundreds.isOne(28459742));
        assertFalse(TensHundreds.isOne(Integer.MAX_VALUE));
        assertFalse(TensHundreds.isOne(Integer.MAX_VALUE - 1));
    }
}
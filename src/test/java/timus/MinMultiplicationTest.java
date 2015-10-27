package timus;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Stas on 10/19/15.
 */
public class MinMultiplicationTest {

    @Test
    public void test_cases() throws Exception {
        assertEquals("10", MinMultiplication.calc(0));
        assertEquals("1", MinMultiplication.calc(1));
        assertEquals("2", MinMultiplication.calc(2));
        assertEquals("3", MinMultiplication.calc(3));
        assertEquals("4", MinMultiplication.calc(4));
        assertEquals("5", MinMultiplication.calc(5));
        assertEquals("25", MinMultiplication.calc(10));
        assertNull(MinMultiplication.calc(11));
        assertEquals("26", MinMultiplication.calc(12));
        assertEquals("27", MinMultiplication.calc(14));
        assertEquals("35", MinMultiplication.calc(15));
        assertEquals("45", MinMultiplication.calc(20));
        assertEquals("2888", MinMultiplication.calc(1024));
        assertEquals("5558", MinMultiplication.calc(1000));
    }
}
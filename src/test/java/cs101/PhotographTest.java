package cs101;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Stas on 10/16/15.
 */
public class PhotographTest {
    @Test
    public void test_simple_case() throws Exception {
        assertEquals(1, Photograph.answer(1));
        assertEquals(1, Photograph.answer(2));
        assertEquals(2, Photograph.answer(3));
        assertEquals(4, Photograph.answer(4));
        assertEquals(6, Photograph.answer(5));
        assertEquals(9, Photograph.answer(6));
        assertEquals(14, Photograph.answer(7));
        assertEquals(21, Photograph.answer(8));
    }

    // s(n) = s(n-1) + s(n-3) + 1


    @Test(timeout = 900)
    public void test_slow_case() throws Exception {
        Photograph.answer(55);
    }
}
package google;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Stas on 8/13/15.
 */
public class PiratesTest {

    @Test
    public void test_pirates() throws Exception {
        assertEquals(2, Pirates.answer(new int[]{1, 0}));
        assertEquals(2, Pirates.answer(new int[]{1, 2, 1}));
        assertEquals(2, Pirates.answer(new int[]{1, 3, 0, 1}));
    }
}
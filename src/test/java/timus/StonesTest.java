package timus;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Stas on 10/20/15.
 */
public class StonesTest {

    @Test
    public void test_stones() throws Exception {
        assertEquals(0, Stones.maxDiff(new int[]{2, 2, 2, 2}));
        assertEquals(1, Stones.maxDiff(new int[]{1, 2}));
        assertEquals(1, Stones.maxDiff(new int[]{2, 1}));
        assertEquals(0, Stones.maxDiff(new int[]{2, 2}));
        assertEquals(2, Stones.maxDiff(new int[]{2, 2, 2, 2, 2}));
    }
}
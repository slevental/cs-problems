package cs101;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Stas on 9/25/15.
 */
public class MedianTest {

    @Test
    public void testMiddle() throws Exception {
        assertEquals(5.5, Median.median(new int[]{1, 2, 3, 4, 5}, new int[]{6, 7, 8, 9, 10}), 1e-5);
        assertEquals(2, Median.median(new int[]{1, 1, 1, 2, 2}, new int[]{2, 2, 2, 2, 2}), 1e-5);
        assertEquals(1, Median.median(new int[]{1, 1, 1, 1, 1}, new int[]{1, 1, 1, 1, 1}), 1e-5);
        assertEquals(3, Median.median(new int[]{1, 2, 3, 4, 5}, new int[]{1, 2, 3, 4, 5}), 1e-5);
    }

    @Test
    public void testMedian() throws Exception {
        assertEquals(3.5, Median.median(new int[]{1, 2, 3, 4, 5}, 1, 5), 1e-5);
        assertEquals(3, Median.median(new int[]{1, 2, 3, 4, 5}, 0, 5), 1e-5);
        assertEquals(3, Median.median(new int[]{1, 2, 3, 4, 5}, 1, 4), 1e-5);
        assertEquals(2.5, Median.median(new int[]{1, 2, 3, 4}, 0, 4), 1e-5);
    }
}
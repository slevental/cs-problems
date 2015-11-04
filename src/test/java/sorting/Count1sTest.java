package sorting;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Stas on 10/29/15.
 */
public class Count1sTest {
    @Test
    public void test_solution() throws Exception {
        assertEquals(0, Count1s.countOnes(new int[]{0, 0, 0, 0, 0, 0, 0}));
        assertEquals(2, Count1s.countOnes(new int[]{1, 1, 0, 0, 0, 0, 0}));
        assertEquals(7, Count1s.countOnes(new int[]{1, 1, 1, 1, 1, 1, 1}));
    }
}
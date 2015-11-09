package careercup;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Stas on 11/7/15.
 */
public class NumGraterTest {

    @Test
    public void test_solution() throws Exception {
        assertArrayEquals(new int[]{3, 2, 1, 0, 1, 1, 0},
                NumGrater.numGrater(new int[]{3, 4, 5, 9, 2, 1, 3}));
    }
}
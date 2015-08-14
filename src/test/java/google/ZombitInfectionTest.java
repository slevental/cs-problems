package google;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Stas on 8/14/15.
 */
public class ZombitInfectionTest {
    @Test
    public void test_simple_tests() throws Exception {
        assertArrayEquals(new int[][]{{6, 7, -1, 7, 6}, {6, -1, -1, -1, 7}, {-1, -1, -1, -1, 10}, {8, -1, -1, -1, 9}, {8, 7, -1, 9, 9}},
                ZombitInfection.answer(new int[][]{{6, 7, 2, 7, 6}, {6, 3, 1, 4, 7}, {0, 2, 4, 1, 10}, {8, 1, 1, 4, 9}, {8, 7, 4, 9, 9}}, 2, 1, 5));

        assertArrayEquals(new int[][]{{-1, -1, 3}, {-1, 3, 4}, {3, 2, 1}},
                ZombitInfection.answer(new int[][]{{1, 2, 3}, {2, 3, 4}, {3, 2, 1}}, 0, 0, 2));
    }
}
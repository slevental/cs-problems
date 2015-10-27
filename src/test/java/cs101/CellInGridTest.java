package cs101;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Stas on 10/14/15.
 */
public class CellInGridTest {
    @Test
    public void test_simple_case() throws Exception {
        int[][] input = {
                {1, 1, 0, 0},
                {0, 1, 1, 0},
                {0, 0, 1, 0},
                {1, 0, 0, 0},
        };
        assertEquals(5, CellInGrid.findLongestConn(input, 4, 4));
    }

    @Test
    public void test_custom_case() throws Exception {
        int[][] input = {
                {1, 1, 1, 1, 1},
                {0, 0, 0, 1, 0}
        };
        assertEquals(6, CellInGrid.findLongestConn(input, 2, 5));
    }

    @Test
    public void test_helpers() throws Exception {
        assertHelper(3, 3, 4);
        assertHelper(0, 0, 4);
        assertHelper(30, 100, 101);
        assertHelper(100, 32, 101);
    }

    private void assertHelper(int j, int i, int m) {
        int x = CellInGrid.toInt(j, i, m);
        assertEquals(i, CellInGrid.iFromInt(x, m));
        assertEquals(j, CellInGrid.jFromInt(x, m));
    }
}
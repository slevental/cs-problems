package graph;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Stas on 10/1/15.
 */
public class EvenTreeTest {
    @Test
    public void test_even_tree() throws Exception {
        int[][] arr = new int[11][11];
        arr[1][2] = 1;
        arr[1][3] = 1;
        arr[3][4] = 1;
        arr[2][5] = 1;
        arr[1][6] = 1;
        arr[2][7] = 1;
        arr[6][8] = 1;
        arr[8][9] = 1;
        arr[8][10] = 1;
        assertEquals(2, EvenTree.evenTree(arr));
    }
}
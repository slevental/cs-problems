package sorting;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Stas on 10/29/15.
 */
public class CommonElementsTest {

    @Test
    public void test_solution() throws Exception {
        assertArrayEquals(new Integer[]{20, 80}, CommonElements.findCommon(
                new int[]{1, 5, 10, 20, 40, 80},
                new int[]{6, 7, 20, 80, 100},
                new int[]{3, 4, 15, 20, 30, 70, 80, 120}
        ));
        assertArrayEquals(new Integer[]{5, 5}, CommonElements.findCommon(
                new int[]{1, 5, 5},
                new int[]{3, 4, 5, 5, 10},
                new int[]{5, 5, 10, 20}
        ));

    }
}
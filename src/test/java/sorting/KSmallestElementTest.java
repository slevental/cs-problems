package sorting;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Stas on 10/29/15.
 */
public class KSmallestElementTest {

    @Test
    public void test_solution() throws Exception {
        int[] in = {6, 4, 3, 6, 4, 2, 6, 4, 1, 1};
        assertEquals(1, KSmallestElement.kSmallest(in, 1));
        assertEquals(1, KSmallestElement.kSmallest(in, 2));
        assertEquals(4, KSmallestElement.kSmallest(in, 5));
    }
}
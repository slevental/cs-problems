package google;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Stas on 8/15/15.
 */
public class HashItOutTest {

    @Test
    public void test_simple_decode() throws Exception {
        assertArrayEquals(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15},
                HashItOut.answer(new int[]{0, 129, 3, 129, 7, 129, 3, 129, 15, 129, 3, 129, 7, 129, 3, 129}));
        assertArrayEquals(new int[]{0, 1, 4, 9, 16, 25, 36, 49, 64, 81, 100, 121, 144, 169, 196, 225},
                HashItOut.answer(new int[]{0, 129, 5, 141, 25, 137, 61, 149, 113, 145, 53, 157, 233, 185, 109, 165}));
    }

    @Test
    public void test_encode() throws Exception {
        assertArrayEquals(new int[]{0, 129, 3, 129, 7, 129, 3, 129, 15, 129, 3, 129, 7, 129, 3, 129},
                HashItOut.hash(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15}));
        assertArrayEquals(new int[]{0, 129, 5, 141, 25, 137, 61, 149, 113, 145, 53, 157, 233, 185, 109, 165},
                HashItOut.hash(new int[]{0, 1, 4, 9, 16, 25, 36, 49, 64, 81, 100, 121, 144, 169, 196, 225}));
    }
}
package google;

import org.junit.Test;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.Assert.*;

/**
 * Created by Stas on 8/21/15.
 */
public class BinaryBunniesTest {

    @Test
    public void test_time() throws Exception {
        int size = 18;
        int[] in = new int[size];
        for (int i = 0; i < size; i++) {
            in[i] = ThreadLocalRandom.current().nextInt(100);
        }
        System.out.println(Arrays.toString(in));
        System.out.println(BinaryBunnies.answer(in));
    }

    @Test
    public void test_simple_case() throws Exception {
        assertEquals("3960", BinaryBunnies.answer(new int[]{272295634, -1918025385, 194067158, -1989770714, -1419600099, 1024898178, -653279010, 1945072487, -1071503884, 1034206688, -804535250, 2116286138}));
        assertEquals("11550", BinaryBunnies.answer(new int[]{1150950717, -1606707189, 2116282635, 416858361, -843819545, 373329017, 1495164340, -2062954100, -1919986584, -2136353966, 2041579020, 197977660}));
        assertEquals("70", BinaryBunnies.answer(new int[]{5, 4, 6, 3, 7, 2, 8, 1, 9}));
        assertEquals("10", BinaryBunnies.answer(new int[]{3, 8, 4, 2, 1, 7}));
        assertEquals("6", BinaryBunnies.answer(new int[]{5, 9, 8, 2, 1}));
        assertEquals("1", BinaryBunnies.answer(new int[]{1, 2, 3, 8, 5, 4}));
        assertEquals("1", BinaryBunnies.answer(new int[]{1, 2, 4, 3}));
        assertEquals("3", BinaryBunnies.answer(new int[]{6, 4, 7, 1}));
        assertEquals("2", BinaryBunnies.answer(new int[]{6, 4, 7}));
        assertEquals("1", BinaryBunnies.answer(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
        assertEquals("1", BinaryBunnies.answer(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25}));
    }
}
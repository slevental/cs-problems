package cs101;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by Stas on 9/25/15.
 */
public class QuickSortTest {
    @Test
    public void test_randomArray() throws Exception {
        Random rn = new Random(13);
        int[] arr = new int[rn.nextInt(1000)];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rn.nextInt(10000);
        }

        int[] copy = Arrays.copyOf(arr, arr.length);
        Arrays.sort(copy);
        QuickSort.quickSort(arr);
        assertArrayEquals(copy, arr);
    }
}
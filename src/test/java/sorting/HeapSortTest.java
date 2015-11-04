package sorting;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by Stas on 10/27/15.
 */
public class HeapSortTest {

    @Test
    public void test_sorting() throws Exception {
        int size = 1000;
        Random radnom = new Random(13);
        int[] arr = new int[size];
        int[] arr2 = new int[size];
        for (int i = 0; i < size; i++) {
            int x = radnom.nextInt();
            arr[i] = x;
            arr2[i] = x;
        }
        HeapSort.sort(arr);
        Arrays.sort(arr2);

        assertArrayEquals(arr, arr2);
    }
}
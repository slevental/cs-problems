package math;

import java.util.Arrays;

/**
 * Created by Stas on 11/1/15.
 */
public class AllPermutations {

    public static void main(String[] args) {
        printAllPermutations(new int[]{1, 2, 3, 3, 5}, 2);
    }

    public static void printAllPermutations(int[] data, int r) {
        int[] buf = new int[r];
        printAllPermutations(data, buf, 0, 0);
    }

    private static void printAllPermutations(int[] data, int[] buf, int index, int i) {
        if (index == buf.length) {
            System.out.println(Arrays.toString(buf));
            return;
        }

        if (i >= data.length)
            return;

        buf[index] = data[i];

        printAllPermutations(data, buf, index + 1, i + 1);
        printAllPermutations(data, buf, index, i + 1);
    }
}

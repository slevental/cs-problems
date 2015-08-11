package dynamic;

import java.util.Scanner;

import static java.lang.Math.max;

/**
 * Created by Stas on 8/10/15.
 */
public class MaxSubArray {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        while (size-- > 0) {
            scanner.nextLine();
            int arrLen = scanner.nextInt();
            int[] arr = new int[arrLen];
            for (int i = 0; i < arrLen; i++)
                arr[i] = scanner.nextInt();
            int[] res = maxSubArray(arr);
            System.out.println(res[0] + " " + res[1]);
        }
    }

    static int[] maxSubArray(int... arr) {
        int[] mem = new int[arr.length];
        maxContiniousArray(arr, mem);
        int max = getMax(mem);
        int[] mem2 = new int[arr.length];
        maxSubArray(arr, mem2);
        int max2 = getMax(mem2);
        return new int[]{max, max2};
    }

    private static int getMax(int[] mem) {
        int max = mem[0];
        for (int m : mem) if (max < m) max = m;
        return max;
    }

    private static void maxContiniousArray(int[] input, int[] mem) {
        for (int i = input.length - 1; i >= 0; i--) {
            int curr = input[i];
            if (mem[i] != 0)
                continue;

            if (i == input.length - 1) mem[i] = curr;
            else mem[i] = max(mem[i + 1] + curr, curr);
        }
    }

    private static void maxSubArray(int[] input, int[] mem) {
        for (int i = input.length - 1, maxSoFar = Integer.MIN_VALUE; i >= 0; i--) {
            int curr = input[i];
            if (mem[i] != 0)
                continue;

            if (i == input.length - 1) {
                mem[i] = curr;
                continue;
            }
            maxSoFar = max(mem[i + 1], maxSoFar);
            mem[i] = max(curr, max(maxSoFar + curr, maxSoFar));
        }
    }
}

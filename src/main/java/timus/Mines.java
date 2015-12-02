package timus;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Stas on 11/29/15.
 */
public class Mines {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] input = new int[n];
        int i = 0;
        while (n-- > 0) {
            input[i++] = in.nextInt();
        }
        System.out.println(calc(input));
    }

    private static int calc(int[] input) {
        Arrays.sort(input);
        int res = 0, hi = input.length - 1;
        while (hi >= 0) {
            if (hi == 0) {
                res += input[0];
                break;
            } else if (hi == 1) {
                res += input[1];
                break;
            } else if (hi == 2) {
                res += input[0] + input[1] + input[2];
                break;
            } else if (input[1] * 2 + input[0] + input[hi] < input[0] * 2 + input[hi] + input[hi - 1]) {
                res += input[1] * 2 + input[0] + input[hi];
            } else {
                res += input[0] * 2 + input[hi] + input[hi - 1];
            }
            hi -= 2;
        }
        return res;
    }
}

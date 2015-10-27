package timus;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Stas on 10/20/15.
 */
public class MinimizeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        System.out.println(minimize(a, b, c));
    }

    private static int minimize(int a, int b, int c) {
        int[] res = {a, b, c};
        Arrays.sort(res);
        if (res[2] * res[1] > res[2] + res[1])
            return res[0] - res[2] * res[1];
        else return res[0] - res[2] - res[1];
    }

}

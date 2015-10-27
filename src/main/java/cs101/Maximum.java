package cs101;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Math.max;

/**
 * Created by Stas on 10/21/15.
 */
public class Maximum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
        while ((n = scanner.nextInt()) != 0)
            System.out.println(maximum(n));
    }

    private static int maximum(int n) {
        int[] mem = new int[n + 1];
        Arrays.fill(mem, -1);
        mem[0] = 0;
        mem[1] = 1;
        int max = 0;
        for (int i = n; i > 0; i--)
            max = max(max, a(i, mem));
        return max;
    }

    private static int a(int n, int[] mem) {
        int res = mem[n];
        if (res > 0)
            return res;
        return mem[n] = a(n / 2, mem) + (n % 2 == 1 ? a(n / 2 + 1, mem) : 0);
    }
}

package cs101;

import java.util.Scanner;

/**
 * Created by Stas on 10/16/15.
 */
public class Photograph {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(answer(scanner.nextInt()));
    }

    public static long answer(int n) {
        long[] memo = new long[n + 1];
        return answer(n, memo);
    }

    private static long answer(int i, long[] memo) {
        if (i <= 2) return 1;
        if (i == 3) return 2;
        if (i == 4) return 4;
        long v = memo[i];
        if (v > 0) return v;
        v = answer(i - 3, memo) + answer(i - 1, memo) + 1;
        memo[i] = v;
        return v;
    }

}

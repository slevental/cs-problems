package math;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by Stas on 10/6/15.
 */
public class IsFibo {
    private static Set<Long> fibos = new HashSet<>();

    static {
        int n = 0;
        long f;
        long[] memo = new long[1024 * 50];
        while ((f = fibo(n++, memo)) < 1e+10) {
            fibos.add(f);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        while (size-- > 0) {
            scanner.nextLine();
            System.out.println(isFibo(scanner.nextLong()) ? "IsFibo" : "IsNotFibo");
        }
    }

    private static boolean isFibo(long f) {
        return fibos.contains(f);
    }

    private static long fibo(int n, long[] memo) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (memo[n] != 0) return memo[n];
        long f = fibo(n - 1, memo) + fibo(n - 2, memo);
        memo[n] = f;
        return f;
    }


}

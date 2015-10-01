package dynamic;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Stas on 9/29/15.
 */
public class Knapsack {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        while (size-- > 0) {
            scanner.nextLine();
            int arrLen = scanner.nextInt();
            int reqSum = scanner.nextInt();
            scanner.nextLine();
            int[] arr = new int[arrLen];
            for (int i = 0; i < arrLen; i++)
                arr[i] = scanner.nextInt();
            int res = fit(arr, 0, reqSum, new HashMap<>(), 0);
            System.out.println(res);
        }
    }

    static int fit(int[] arr, int delta, int sum, Map<Integer, Integer> memo, int fit) {
        if (memo.containsKey(sum)) return memo.get(sum);
        if ((sum -= delta) < 0) return 0;
        for (int i = 0; i < arr.length; i++) fit = Math.max(fit, fit(arr, arr[i], sum, memo, 0));
        memo.put(sum, fit);
        return fit + delta;
    }
}

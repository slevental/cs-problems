package timus;

import java.util.*;

/**
 * Created by Stas on 10/19/15.
 */
public class Stones {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] ints = new int[size];
        while (size-- > 0) {
            ints[size] = scanner.nextInt();
        }
        System.out.println(maxDiff(ints));
    }

    static int maxDiff(int[] ints) {
        BitSet visited = new BitSet();
        Map<Integer, Integer> memo = new HashMap<>();

        int sum = 0;
        for (int each : ints) {
            sum += each;
        }

        return 2 * maxDiff(ints, visited, memo, sum / 2) + sum % 2;
    }

    private static int maxDiff(int[] ints, BitSet visited, Map<Integer, Integer> memo, int sum) {
        Integer res = memo.get(sum);
        if (res != null) return res;
        if (sum == 0) return sum;
        if (sum < 0) return Integer.MAX_VALUE;

        res = sum;
        for (int i = 0; i < ints.length; i++) {
            int each = ints[i];
            if (!visited.get(i)) {
                visited.set(i);
                res = Math.min(res, maxDiff(ints, visited, memo, sum - each));
                visited.set(i, false);
            }
        }

        memo.put(sum, res);

        return res;
    }
}

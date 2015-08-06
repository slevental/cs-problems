package strings;

import java.util.Scanner;

/**
 * Created by Stas on 8/5/15.
 */
public class BiggerIsGrater {
    public static final String NO_ANSWER = "no answer";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        scanner.nextLine();
        while (size-- > 0) {
            System.out.println(nextLexPermutation(scanner.nextLine()));
        }
    }

    public static String nextLexPermutation(String in) {
        StringBuilder res = new StringBuilder(in);
        int lo = res.length() - 1;

        /**
         * Find biggest descending suffix
         */
        while (lo > 0 && res.charAt(lo - 1) >= res.charAt(lo))
            lo--;

        /**
         * If suffix eq to whole word then we already has the biggest permutation
         */
        if (lo <= 0) return NO_ANSWER;

        /**
         * Looking for exchange candidate - smallest value in suffix which is bigger than pivot element (El = Res[lo])
         */
        int hi = res.length() - 1;
        while (res.charAt(hi) <= res.charAt(lo - 1))
            hi--;


        /**
         * Doing swap between pivot and candidate
         */
        swap(res, lo - 1, hi);

        /**
         * Reversing suffix
         */
        hi = res.length() - 1;
        while (lo < hi) {
            swap(res, lo, hi);
            lo++; hi--;
        }

        return res.toString();
    }


    private static void swap(StringBuilder res, int from, int to) {
        char buff = res.charAt(to);
        res.setCharAt(to, res.charAt(from));
        res.setCharAt(from, buff);
    }
}

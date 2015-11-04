package strings;

import java.util.Scanner;

/**
 * Created by Stas on 11/1/15.
 */
public class AllPermutations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        printPermutations(new StringBuilder(str), 0, str.length());
    }

    private static void printPermutations(StringBuilder str, int lo, int hi) {
        if (lo==hi)
            System.out.println(str.toString());
        else for (int i = lo; i < hi; i++) {
            swap(str, i, lo);
            printPermutations(str, lo + 1, hi);
            swap(str,  i, lo);
        }
    }

    private static void swap(StringBuilder str, int i, int j) {
        char c = str.charAt(i);
        str.setCharAt(i, str.charAt(j));
        str.setCharAt(j, c);
    }
}

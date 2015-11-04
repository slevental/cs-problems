package timus;

import java.util.Scanner;

/**
 * Created by Stas on 11/1/15.
 */
public class Salary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(toPalindrome(scanner.next()));
    }

    private static String toPalindrome(String n) {
        StringBuilder res = new StringBuilder(n);
        int lo = -1, hi = res.length();
        while (lo < hi) {
            if (res.charAt(++lo) != res.charAt(--hi))
                res.setCharAt(hi, res.charAt(lo));
        }
        return res.toString();
    }
}

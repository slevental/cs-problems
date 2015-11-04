package timus;

import java.util.Scanner;

/**
 * Created by Stas on 11/1/15.
 */
public class SmsSpam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        System.out.println(estimate(text));
    }

    private static final String chars = "abcdefghijklmnopqrstuvwxyz .,! ";
    private static final int[] cost = new int[255];

    static {
        for (int i = 0; i < chars.length(); i++) {
            char c = chars.charAt(i);
            cost[c] = i % 3 + 1;
        }
    }

    private static int estimate(String text) {
        int sum = 0;
        for (int i = 0; i < text.length(); i++) {
            sum += cost[text.charAt(i)];
        }
        return sum;
    }
}

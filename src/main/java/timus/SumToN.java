package timus;

import java.util.Scanner;

/**
 * Created by Stas on 11/1/15.
 */
public class SumToN {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(sum(scanner.nextInt()));
    }

    private static int sum(int n) {
        return n <= 0 ? (1 - n) * n / 2 + 1 : (1 + n) * n / 2;
    }
}

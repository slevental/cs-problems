package cs101;

import java.util.Scanner;

/**
 * Created by Stas on 10/16/15.
 */
public class KDigits {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        int k = scanner.nextInt();
        System.out.println(Math.round((2 - n + k * (k - 1)) * Math.pow(k, n - 2)));
    }


}

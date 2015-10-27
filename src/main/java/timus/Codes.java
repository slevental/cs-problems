package timus;

import java.util.Scanner;

/**
 * Created by Stas on 10/21/15.
 */
public class Codes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println(a % 2 == 0 || b % 2 == 1 ? "yes" : "no");
    }


}

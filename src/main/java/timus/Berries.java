package timus;

import java.util.Scanner;

/**
 * Created by Stas on 10/21/15.
 */
public class Berries {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a1 = scanner.nextInt();
        int b1 = scanner.nextInt();
        scanner.nextInt();
        int b2 = scanner.nextInt();
        int a3 = scanner.nextInt();
        scanner.nextInt();

        System.out.println((a1 - a3) + " " + (b1 - b2));
    }


}

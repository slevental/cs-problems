package timus;

import java.util.Scanner;

/**
 * Created by Stas on 10/21/15.
 */
public class Grisha {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int f = scanner.nextInt();
        double left = ((12 - f) * 45) / 60;
        System.out.println((left >= 4) ? "NO" : "YES");
    }
}

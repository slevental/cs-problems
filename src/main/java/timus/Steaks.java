package timus;

import java.util.Scanner;

/**
 * Created by Stas on 10/21/15.
 */
public class Steaks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        System.out.printf("%d\n", (int) Math.max(2, Math.ceil(n * 2. / k)));
    }
}

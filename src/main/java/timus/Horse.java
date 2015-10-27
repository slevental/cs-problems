package timus;

import java.util.Scanner;

/**
 * Created by Stas on 10/21/15.
 */
public class Horse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        while (size-- > 0) {
            System.out.println(sq(scanner.next()));
        }
    }

    private static int sq(String pos) {
        int x = pos.charAt(1) - '0';
        int y = pos.charAt(0) - 'a' + 1;


        return 0;
    }
}

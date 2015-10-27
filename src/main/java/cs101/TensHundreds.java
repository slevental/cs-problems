package cs101;

import java.util.Scanner;

import static java.lang.Math.floor;

/**
 * Created by Stas on 10/16/15.
 */
public class TensHundreds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = scanner.nextInt();
        scanner.nextLine();
        while (size-- > 0) {
            if (isOne(scanner.nextLong())) System.out.print("1");
            else System.out.print("0");
            if (size > 0) System.out.print(" ");
        }
    }

    static boolean isOne(long x) {
        double d = 8 * x - 7;
        double sqrt = Math.sqrt(d);
        return floor(sqrt) == sqrt;
    }

}

package math;

import java.util.Scanner;

/**
 * Created by Stas on 8/6/15.
 */
public class MatrixTraversal {
    public static final long max = (long) 7e+10;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        while (size-- > 0) {
            scanner.nextLine();
            System.out.println(countMatrixWays(scanner.nextInt(), scanner.nextInt()) % max);
        }
    }

    public static long countMatrixWays(int m, int n) {
        return 1;
    }
}

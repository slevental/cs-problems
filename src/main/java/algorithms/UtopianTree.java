package algorithms;

import java.util.Scanner;

/**
 * Created by Stas on 10/1/15.
 */
public class UtopianTree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        while (size-- > 0) {
            scanner.nextLine();
            int in = scanner.nextInt();
            int res = tree(in);
            System.out.println(res);
        }
    }

    static int tree(int in) {
        return ~(~1 << ((in + 1) >> 1)) - in % 2;
    }
}

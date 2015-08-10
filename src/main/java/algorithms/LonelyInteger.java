package algorithms;

import java.util.Scanner;

/**
 * Created by Stas on 8/10/15.
 */
public class LonelyInteger {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        scanner.nextLine();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++)
            arr[i] = scanner.nextInt();

        System.out.println(findLonelyInteger(arr));
    }

    static int findLonelyInteger(int... ints) {
        int x = 0;
        for (int i : ints)
            x = x ^ i;
        return x;
    }
}

package algorithms;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Created by Stas on 8/24/15.
 */
public class ArraySum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        scanner.nextLine();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++)
            arr[i] = scanner.nextInt();
        System.out.println(IntStream.of(arr).sum());
    }

}

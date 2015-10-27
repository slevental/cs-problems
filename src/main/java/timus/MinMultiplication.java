package timus;

import java.util.*;

/**
 * Created by Stas on 10/19/15.
 */
public class MinMultiplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numb = scanner.nextInt();
        String c = calc(numb);
        System.out.println(c == null ? "-1" : c);
    }

    static String calc(int number) {
        if (number < 0) return null;
        if (number == 0) return "10";
        if (number < 2) return String.valueOf(number);

        for (int k = 9; k > 1; k--) {
            if (number % k == 0) {
                int next = number / k;
                if (next > 1) {
                    String calc = calc(next);
                    if (calc == null) return null;
                    return calc + k;
                }
                return String.valueOf(k);
            }
        }
        return null;
    }

}

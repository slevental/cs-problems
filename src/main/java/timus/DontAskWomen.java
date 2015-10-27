package timus;

import java.math.BigInteger;
import java.util.Scanner;

import static java.math.BigInteger.valueOf;

/**
 * Created by Stas on 10/21/15.
 */
public class DontAskWomen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String size = scanner.next();
        int x = find(size);
        System.out.println(x == 0 ? "No solution." : x);
    }

    private static int find(String number) {
        int max = 0;
        number = number.toLowerCase().trim();

        for (int i = 0; i < number.length(); i++) {
            max = Math.max(max, number.charAt(i));
        }

        if (max < '9')
            max -= '0';
        else
            max = (max - 'a') + 10;

        for (int k = Math.max(2, max + 1); k <= 36; k++) {
            try {
                if ((new BigInteger(number, k)).mod(valueOf(k - 1)).equals(BigInteger.ZERO)) {
                    return k;
                }
            } catch (Exception e) {
            }
        }
        return 0;
    }
}

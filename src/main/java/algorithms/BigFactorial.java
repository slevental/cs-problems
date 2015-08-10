package algorithms;

import java.math.BigInteger;
import java.util.Scanner;

import static java.math.BigInteger.valueOf;

/**
 * Created by Stas on 8/10/15.
 */
public class BigFactorial {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(calcFactorial(scanner.nextInt()));
    }

    static BigInteger calcFactorial(int n) {
        BigInteger res = BigInteger.ONE;
        for (int i = 2; i < n; i++)
            res = res.multiply(valueOf(i));
        return res;
    }

}

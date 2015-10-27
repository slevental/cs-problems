package timus;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Stas on 10/21/15.
 */
public class Sqrt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Double> res = new Stack<>();
        try {
            while (true)
                res.push(Math.sqrt(scanner.nextLong()));
        } catch (Exception e) {
        }
        while(!res.isEmpty())
            System.out.printf("%.4f\n", res.pop());
    }
}

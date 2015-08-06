package strings;

import java.util.Scanner;

/**
 * Created by Stas on 8/5/15.
 */
public class TwoString {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        scanner.nextLine();
        while (size-- > 0)
            System.out.println(hasCommonString(scanner.nextLine(), scanner.nextLine()) ? "YES" : "NO");
    }

    public static boolean hasCommonString(String s1, String s2) {
        return (toInt(s1) & toInt(s2)) > 0;
    }

    private static int toInt(String str) {
        int res = 0;
        for (int i = 0; i < str.length(); i++)
            res |= 1 << (str.charAt(i) - 'a');
        return res;
    }

}

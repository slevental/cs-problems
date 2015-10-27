package timus;

import java.util.Scanner;

/**
 * Created by Stas on 10/21/15.
 */
public class Reverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            while (scanner.hasNextLine())
                System.out.println(reverseByWord(scanner.nextLine()));
            if (scanner.hasNext())
                System.out.println(reverseByWord(scanner.next()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String reverseByWord(String str) {
        StringBuilder sb = new StringBuilder(str);
        for (int lo = 0, i = 0; i < sb.length(); i++) {
            if (isSeparator(sb, i)) {
                reverse(sb, lo, i);
                while (isSeparator(sb, i)) i++;
                lo = i;
            }
            if (i == sb.length() - 1) {
                while (isSeparator(sb, i)) i--;
                reverse(sb, lo, i + 1);
            }
        }
        return sb.toString();
    }

    private static boolean isSeparator(StringBuilder sb, int i) {
        if (i == sb.length())
            return false;
        return !Character.isAlphabetic(sb.charAt(i));
    }

    private static void reverse(StringBuilder sb, int from, int to) {
        while (from < --to) {
            char b = sb.charAt(to);
            sb.setCharAt(to, sb.charAt(from));
            sb.setCharAt(from++, b);
        }
    }

}

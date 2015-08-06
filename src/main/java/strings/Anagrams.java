package strings;

import java.util.Scanner;

/**
 * Created by Stas on 8/5/15.
 */
public class Anagrams {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(anagramEditDistance(scanner.nextLine(), scanner.nextLine()));
    }

    public static int anagramEditDistance(String s1, String s2) {
        char[] arr1 = countChars(s1);
        char[] arr2 = countChars(s2);
        int sum = 0;
        for (int i = 0; i < arr1.length; i++){
            sum += Math.abs(arr1[i] - arr2[i]);
        }
        return sum;
    }

    private static char[] countChars(String str) {
        char[] chars = new char['z' - 'a' + 1];
        for (int i = 0; i < str.length(); i++) {
            chars[str.charAt(i) - 'a']++;
        }
        return chars;
    }
}

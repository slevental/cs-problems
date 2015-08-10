package strings;

import java.util.Scanner;

/**
 * Created by Stas on 8/10/15.
 */
public class GameOfThrones {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(couldBePalindrome(scanner.nextLine()) ? "YES" : "NO");
    }

    static boolean couldBePalindrome(String str) {
        int odds = 0;
        int len = str.length();
        int[] counters = new int['z' - 'a' + 1];
        for (int i = 0; i < str.length(); i++) counters[str.charAt(i) - 'a']++;
        for (int count : counters) if (count % 2 != 0) odds++;

        boolean evenLen = len % 2 == 0;
        return (odds == 0 && evenLen)
                || (odds == 1 && !evenLen);
    }


}

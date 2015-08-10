package strings;

import java.util.Scanner;

/**
 * Created by Stas on 8/10/15.
 */
public class AlternatingCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        scanner.nextLine();
        while (size-- > 0)
            System.out.println(numberOfDeletions(scanner.nextLine()));
    }

    static int numberOfDeletions(String str) {
        if (str == null || str.isEmpty())
            return 0;

        int res = 0;
        for (int i = 0, prev = 0; i < str.length(); i++, prev = str.charAt(i - 1)) {
            if (prev == str.charAt(i)) res++;
        }
        return res;
    }

}

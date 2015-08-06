package strings;

import java.util.Scanner;

/**
 * Created by Stas on 8/5/15.
 */
public class Pangrams {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("%spangram\n", isPangram(scanner.nextLine()) ? "" : "not ");
    }

    public static boolean isPangram(String in) {
        int res = 0;
        for (int i = 0; i < in.length(); i++) {
            char c = in.charAt(i);
            if (c < 'a') c += 0x20;
            if (c < 'a' || c > 'z')
                continue;
            res |= 1 << (c - 'a');
        }
        return res == 0x3ffffff;
    }

}

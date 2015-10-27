package timus;

import java.util.Scanner;

/**
 * Created by Stas on 10/20/15.
 */
public class Sandro {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String size = scanner.next();
        System.out.println(find(size));
    }

    static String find(String in) {
        int[] counts = new int['z' - 'a' + 1];
        int pos = 0;
        for (int i = 0; i < in.length(); i++) {
            int cnt = ++counts[in.charAt(i) - 'a'];
            if (cnt > counts[in.charAt(pos) - 'a']) pos = i;
        }
        return String.valueOf(in.charAt(pos));
    }
}

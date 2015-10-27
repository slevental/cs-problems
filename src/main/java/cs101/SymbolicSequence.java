package cs101;

import java.util.Random;

/**
 * Created by Stas on 10/16/15.
 */
public class SymbolicSequence {
    public static void main(String[] args) {
        System.out.println(generate());
    }

    public static String generate() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random(13);
        for (int i = 0; i < 1000000; i++) {
            sb.append((char)('a' + random.nextInt('z' - 'a' + 1)));
        }
        return sb.toString();
    }
}

package math;

import java.util.Random;

/**
 * Created by Stas on 11/1/15.
 */
public class BiasedCoin {
    private static final Random random = new Random();

    public static boolean fair() {
        while (true) {
            boolean a = biased();
            boolean b = biased();
            if (a && !b) return true;
            if (!a && b) return false;
        }
    }

    public static boolean biased() {
        return random.nextDouble() <= .4;
    }
}

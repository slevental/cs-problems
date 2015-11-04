package math;

import java.util.Random;

/**
 * Created by Stas on 11/1/15.
 */
public class RandomElement {
    private static final int SEED = 21;
    private final Random random = new Random(SEED);

    private int element;
    private int size;

    public void add(int val) {
        if (++size == 1)
            element = val;
        else {
            int j = random.nextInt(size);
            if (j == size - 1)
                element = val;
        }
    }

    public int getElements() {
        return element;
    }
}

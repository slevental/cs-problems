package math;

import java.util.Random;

/**
 * Created by Stas on 11/1/15.
 */
public class Resevoir {
    private static final int SEED = 21;
    private final Random random = new Random(SEED);
    private final int[] elements;
    private int size;

    public Resevoir(int size) {
        this.elements = new int[size];
    }

    public void add(int val) {
        if (++size < elements.length)
            elements[size] = val;
        else {
            int j = random.nextInt(size);
            if (j < elements.length)
                elements[j] = val;
        }
    }

    public int[] getElements() {
        return elements;
    }
}

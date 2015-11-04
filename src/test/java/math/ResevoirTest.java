package math;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by Stas on 11/1/15.
 */
public class ResevoirTest {
    @Test
    public void test_sample() throws Exception {
        Resevoir resevoir = new Resevoir(3);
        for (int i = 0; i < 1000; i++)
            resevoir.add(i);

        System.out.println(Arrays.toString(resevoir.getElements()));

    }
}
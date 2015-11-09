package timus;

import org.junit.Test;

import java.util.Random;

/**
 * Created by Stas on 11/8/15.
 */
public class LastJacksWordTest {
    @Test
    public void testName() throws Exception {
        String a = random(75000);
        String b = random(75000);
        System.out.println(LastJacksWord.splitToPrefixes(a, b));
    }

    private String random(int i) {
        StringBuilder res = new StringBuilder(i);
        Random rnd = new Random();
        for (int j = 0; j < i; j++) {
            res.append(rnd.nextBoolean() ? 'a' : 'a');
        }
        return res.toString();
    }
}
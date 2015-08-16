package google;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Stas on 8/15/15.
 */
public class WhenItRainsItPoursTest {
    @Test
    public void test_simple_case() throws Exception {
        assertEquals(5, WhenItRainsItPours.answer(new int[]{1, 4, 2, 5, 1, 2, 3}));

    }
}
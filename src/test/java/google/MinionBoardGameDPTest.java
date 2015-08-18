package google;

import org.junit.Test;

import static google.MinionBoardGameDP.answer;
import static org.junit.Assert.*;

/**
 * Created by Stas on 8/17/15.
 */
public class MinionBoardGameDPTest {
    @Test
    public void test_small_numbers() throws Exception {
        assertEquals(1, answer(1, 2));
        assertEquals(3, answer(3, 2));
        assertEquals(4, answer(4, 2));
        assertEquals(5, answer(5, 2));
        assertEquals(6, answer(6, 2));
        assertEquals(1, answer(2, 3));
        assertEquals(3, answer(3, 3));
        assertEquals(4, answer(4, 4));
        assertEquals(4, answer(4, 4));
    }
}
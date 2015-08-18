package google;

import org.junit.Test;

import static google.MinionBoardGameMathSolution.answer;
import static org.junit.Assert.*;

/**
 * Created by Stas on 8/16/15.
 */
public class MinionBoardGameMathSolutionTest {

    @Test
    public void test_with_small_values() throws Exception {
        assertEquals(54901483, answer(1000, 20));
        assertEquals(1000000, answer(1000000, 1000000));
        assertEquals(1000, answer(1000, 1000));
        assertEquals(1, answer(999, 1000));
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

    @Test
    public void test_binomial() throws Exception {
//        assertEquals(365880408, MinionBoardGame.answer(544882 + 825617 - 2, 825617 - 1, 1000000007));
    }
}
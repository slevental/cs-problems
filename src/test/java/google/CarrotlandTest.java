package google;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Stas on 8/24/15.
 */
public class CarrotlandTest {

    @Test
    public void test_answer() throws Exception {
//        assertEquals(1, Carrotland.answer(new int[][]{{0, 2}, {-2, 0}, {2, 0}}));
        assertEquals(1730960165, Carrotland.answer(new int[][]{{91207, 89566}, {-88690, -83026}, {67100, 47194}}));
        assertEquals(289, Carrotland.answer(new int[][]{{2, 3}, {6, 9}, {10, 160}}));
        assertEquals(2, Carrotland.answer(new int[][]{{-1, -1}, {1, -1}, {0, 2}}));
        assertEquals(1, Carrotland.answer(new int[][]{{-1, -1}, {0, 1}, {1, 0}}));
//        assertEquals(2147483647, Carrotland.answer(new int[][]{{0, 0}, {1000000000, 1000000000}, {1000000000, -1000000000}}));
    }
}
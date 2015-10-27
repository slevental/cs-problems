package google;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Stas on 8/24/15.
 */
public class TriangleTest {
    @Test
    public void test_left_most() throws Exception {
        assertEquals(
                new Carrotland.Point(-1, -1),
                new Carrotland.Triangle(new Carrotland.Point(0, 1), new Carrotland.Point(-1, -1), new Carrotland.Point(1, 0)).leftMost()
        );
        assertEquals(
                new Carrotland.Point(-1, -1),
                new Carrotland.Triangle(new Carrotland.Point(-1, -1), new Carrotland.Point(0, 1), new Carrotland.Point(1, 0)).leftMost()
        );
        assertEquals(
                new Carrotland.Point(-1, -1),
                new Carrotland.Triangle(new Carrotland.Point(0, 1), new Carrotland.Point(1, 0), new Carrotland.Point(-1, -1)).leftMost()
        );
    }

    @Test
    public void test_middle() throws Exception {
        assertEquals(
                new Carrotland.Point(0, 1),
                new Carrotland.Triangle(new Carrotland.Point(0, 1), new Carrotland.Point(-1, -1), new Carrotland.Point(1, 0)).middle()
        );
        assertEquals(
                new Carrotland.Point(0, 1),
                new Carrotland.Triangle(new Carrotland.Point(-1, -1), new Carrotland.Point(0, 1), new Carrotland.Point(1, 0)).middle()
        );
        assertEquals(
                new Carrotland.Point(0, 1),
                new Carrotland.Triangle(new Carrotland.Point(0, 1), new Carrotland.Point(1, 0), new Carrotland.Point(-1, -1)).middle()
        );
    }

    @Test
    public void test_right_most() throws Exception {
        assertEquals(
                new Carrotland.Point(1, 0),
                new Carrotland.Triangle(new Carrotland.Point(0, 1), new Carrotland.Point(-1, -1), new Carrotland.Point(1, 0)).rightMost()
        );
        assertEquals(
                new Carrotland.Point(1, 0),
                new Carrotland.Triangle(new Carrotland.Point(-1, -1), new Carrotland.Point(0, 1), new Carrotland.Point(1, 0)).rightMost()
        );
        assertEquals(
                new Carrotland.Point(1, 0),
                new Carrotland.Triangle(new Carrotland.Point(0, 1), new Carrotland.Point(1, 0), new Carrotland.Point(-1, -1)).rightMost()
        );
    }
}
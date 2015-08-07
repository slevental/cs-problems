package math;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Stas on 8/6/15.
 */
public class MatrixTraversalTest {
    @Test
    public void test_big_numbers() throws Exception {
        assertEquals(365880408, MatrixTraversal.getPathEstimation(544882, 825617));
        assertEquals(741521468, MatrixTraversal.getPathEstimation(134333, 553409));
        assertEquals(952393599, MatrixTraversal.getPathEstimation(366974, 828680));

    }
}
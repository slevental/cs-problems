package google;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Stas on 8/18/15.
 */
public class BreadingProblemTest {

    @Test
    public void test_simple_test_cases() throws Exception {
        assertEquals("581", BreadingProblem.answer("1609"));
        assertEquals("398613485728195845122339851309", BreadingProblem.answer("10000000000000000000000000000000"));
        assertEquals("582", BreadingProblem.answer("1915"));
        assertEquals("671", BreadingProblem.answer("1907"));
        assertEquals("339", BreadingProblem.answer("881"));
        assertEquals("339", BreadingProblem.answer("881"));
        assertEquals("4", BreadingProblem.answer("7"));
        assertEquals("3", BreadingProblem.answer("3"));
        assertEquals("9", BreadingProblem.answer("11"));
        assertEquals("12", BreadingProblem.answer("25"));
        assertEquals("None", BreadingProblem.answer("100"));
    }
}
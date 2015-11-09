package strings;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by Stas on 11/8/15.
 */
public class ZFunctionTest {
    @Test
    public void test_z_function() throws Exception {
        assertArrayEquals(new int[]{11, 0, 0, 1, 0, 1, 0, 4, 0, 0, 1}, ZFunction.zetaFunction("abracadabra"));
    }
}
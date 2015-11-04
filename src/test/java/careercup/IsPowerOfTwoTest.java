package careercup;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Stas on 10/27/15.
 */
public class IsPowerOfTwoTest {

    @Test
    public void test_pow() throws Exception {
        assertTrue(IsPowerOfTwo.check(1));
        assertTrue(IsPowerOfTwo.check(2));
        assertTrue(IsPowerOfTwo.check(4));
        assertTrue(IsPowerOfTwo.check(8));
        assertTrue(IsPowerOfTwo.check(16));
        assertTrue(IsPowerOfTwo.check(32));
        assertTrue(IsPowerOfTwo.check(64));
        assertTrue(IsPowerOfTwo.check(128));
        assertTrue(IsPowerOfTwo.check(256));
        assertTrue(IsPowerOfTwo.check(256 * 256 * 256));

        assertFalse(IsPowerOfTwo.check(0));
        assertFalse(IsPowerOfTwo.check(3));
        assertFalse(IsPowerOfTwo.check(5));
        assertFalse(IsPowerOfTwo.check(9));
        assertFalse(IsPowerOfTwo.check(15));
        assertFalse(IsPowerOfTwo.check(31));
        assertFalse(IsPowerOfTwo.check(63));
        assertFalse(IsPowerOfTwo.check(127));
        assertFalse(IsPowerOfTwo.check(255));
        assertFalse(IsPowerOfTwo.check(255 * 256 * 256));
    }
}
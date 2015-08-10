package algorithms;

import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.*;

/**
 * Created by Stas on 8/10/15.
 */
public class BigFactorialTest {

    @Test
    public void test_factorial() throws Exception {
        assertEquals(new BigInteger("15511210043330985984000000"), BigFactorial.calcFactorial(25));

    }
}
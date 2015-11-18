package careercup;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Stas on 11/14/15.
 */
public class PrimeExpressibleTest {

    @Test
    public void test_primes() throws Exception {
        assertEquals(19722481, PrimeExpressible.getN(new int[]{4441}, 3));

        assertEquals(12, PrimeExpressible.getN(new int[]{2, 3}, 8));
        assertEquals(9, PrimeExpressible.getN(new int[]{2, 3}, 7));
        assertEquals(8, PrimeExpressible.getN(new int[]{2, 3}, 6));
        assertEquals(6, PrimeExpressible.getN(new int[]{2, 3}, 5));

    }
}
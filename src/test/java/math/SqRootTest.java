package math;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Stas on 8/12/15.
 */
public class SqRootTest {
    @Test
    public void test_sqrt() throws Exception {
        assertEquals(4, SqRoot.sqrt(16), 0.01);
        assertEquals(15, SqRoot.sqrt(225), 0.01);
        assertEquals(1009, SqRoot.sqrt(1009*1009), 0.01);
        assertEquals(76763, SqRoot.sqrt(76763.*76763), 0.01);
    }
}
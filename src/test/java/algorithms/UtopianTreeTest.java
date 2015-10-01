package algorithms;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Stas on 10/1/15.
 */
public class UtopianTreeTest {
    @Test
    public void test_cycles() throws Exception {
        assertEquals(1, UtopianTree.tree(0));
        assertEquals(2, UtopianTree.tree(1));
        assertEquals(7, UtopianTree.tree(4));
        assertEquals(14, UtopianTree.tree(5));
        assertEquals(15, UtopianTree.tree(6));
    }
}
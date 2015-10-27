package algorithms;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Stas on 8/25/15.
 */
public class ShortestChainTest {
    @Test
    public void test_chain() throws Exception {
        assertArrayEquals(new String[]{"toon", "poon", "poin", "poie", "plie", "plee", "plea"},
                ShortestChain.answer("tool", "plea", "poon", "plee", "same", "poie", "plea", "plie", "poin"));

    }
}
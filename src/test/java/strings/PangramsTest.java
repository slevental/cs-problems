package strings;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Stas on 8/5/15.
 */
public class PangramsTest {
    @Test
    public void test_pangram() throws Exception {
        assertTrue(Pangrams.isPangram("We promptly judged antique ivory buckles for the next prize"));
        assertFalse(Pangrams.isPangram("We promptly judged antique ivory buckles for the prize"));
    }
}
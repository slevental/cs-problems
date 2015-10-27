package strings;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Stas on 8/12/15.
 */
public class CommonChildTest {

    @Test
    public void test_common_child() throws Exception {
        assertEquals(1, CommonChild.commonChild("AA", "AB"));
        assertEquals(3, CommonChild.commonChild("SHINCHAN", "NOHARAAA"));
        assertEquals(0, CommonChild.commonChild("BBB", "AAAA"));
    }
}
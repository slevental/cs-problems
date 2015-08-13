package strings;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Stas on 8/13/15.
 */
public class SuffixTreeTest {
    @Test
    public void test_suffix_tree_simple_method() throws Exception {
        String txt = "this is a test";
        SuffixTree tree = SuffixTree.build(txt);
        assertEquals(txt.indexOf("is"), tree.find("is"));
        assertEquals(txt.indexOf("test"), tree.find("test"));
        assertEquals(-1, tree.find("best"));
    }
}
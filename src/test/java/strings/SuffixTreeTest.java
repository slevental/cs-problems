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
        System.out.println(tree);
    }
}
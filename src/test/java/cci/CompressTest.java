package cci;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Stas on 11/3/15.
 */
public class CompressTest {

    @Test
    public void test_compression() throws Exception {
        assertEquals("abcd", Compress.compress("abcd"));
        assertEquals("a1b5", Compress.compress("abbbbb"));
        assertEquals("a2b1c5a3", Compress.compress("aabcccccaaa"));
    }
}
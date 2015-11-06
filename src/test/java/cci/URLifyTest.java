package cci;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Stas on 11/3/15.
 */
public class URLifyTest {

    @Test
    public void test_url_encode() throws Exception {
        assertEquals("test%20test", URLify.urlEncode("   test test  "));
        assertEquals("test%20test", URLify.urlEncode("test test"));
        assertEquals("test", URLify.urlEncode("   test     "));
        assertEquals("", URLify.urlEncode("                       "));
        assertEquals("a%20b%20c", URLify.urlEncode(" a b c  "));
    }
}
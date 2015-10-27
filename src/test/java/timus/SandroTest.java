package timus;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Stas on 10/20/15.
 */
public class SandroTest {

    @Test
    public void test_simple_cases() throws Exception {
        assertEquals("a", Sandro.find("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
        assertEquals("ab", Sandro.find("ababababababab"));
        assertEquals("z", Sandro.find("zzzz"));
        assertEquals("a", Sandro.find("a"));
        assertEquals("t", Sandro.find("testtesttesttest"));
        assertEquals("zas", Sandro.find("zaszaszaszaszaszas"));
        assertEquals("asz", Sandro.find("xxaszaszaszaszaszxx"));
        assertEquals("x", Sandro.find("xxxyyy"));
        assertEquals("ue", Sandro.find("queue"));
        assertEquals("abcde", Sandro.find("abcde"));
        assertEquals("tebidoh", Sandro.find("tebidohtebidoh"));
        assertEquals("a", Sandro.find("abababa"));
    }
}
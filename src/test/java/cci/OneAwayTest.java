package cci;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Stas on 11/3/15.
 */
public class OneAwayTest {

    @Test
    public void test_solution() throws Exception {
        assertTrue(OneAway.isOneAway("pale", "ple"));
        assertTrue(OneAway.isOneAway("pales", "pale"));
        assertTrue(OneAway.isOneAway("pale", "bale"));
        assertFalse(OneAway.isOneAway("pale", "bake"));
        assertFalse(OneAway.isOneAway("", "bake"));
        assertFalse(OneAway.isOneAway("bake", ""));
        assertFalse(OneAway.isOneAway("aa", "b"));
    }
}
package cci;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Stas on 11/3/15.
 */
public class IsUniqueTest {

    @Test
    public void test_is_unique() throws Exception {
        assertTrue(IsUnique.isUnique("abcd"));
        assertTrue(IsUnique.isUnique("dcba"));
        assertTrue(IsUnique.isUnique("a"));
        assertTrue(IsUnique.isUnique(""));

        assertFalse(IsUnique.isUnique("aa"));
        assertFalse(IsUnique.isUnique("aaa"));
        assertFalse(IsUnique.isUnique("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
        assertFalse(IsUnique.isUnique("abcda"));
        assertFalse(IsUnique.isUnique("dcbad"));
    }
}
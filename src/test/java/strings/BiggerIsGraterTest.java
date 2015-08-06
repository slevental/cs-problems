package strings;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Stas on 8/5/15.
 */
public class BiggerIsGraterTest {
    @Test
    public void test_perm() throws Exception {
        assertEquals("717777777", BiggerIsGrater.nextLexPermutation("177777777"));
        assertEquals("123456798", BiggerIsGrater.nextLexPermutation("123456789"));
        assertEquals(BiggerIsGrater.NO_ANSWER, BiggerIsGrater.nextLexPermutation("9987654321"));
        assertEquals("96788", BiggerIsGrater.nextLexPermutation("89876"));
        assertEquals("hcdk", BiggerIsGrater.nextLexPermutation("dkhc"));
        assertEquals("hegf", BiggerIsGrater.nextLexPermutation("hefg"));
        assertEquals("dhkc", BiggerIsGrater.nextLexPermutation("dhck"));
        assertEquals("ba", BiggerIsGrater.nextLexPermutation("ab"));
        assertEquals(BiggerIsGrater.NO_ANSWER, BiggerIsGrater.nextLexPermutation("bb"));
    }
}
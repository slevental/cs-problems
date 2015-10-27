package timus;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Stas on 10/20/15.
 */
public class PalindromePalindromeTest {
    @Test
    public void test_palindrome() throws Exception {
        assertEquals("tttt", PalindromePalindrome.find("ttt"));
        assertEquals("ttttt", PalindromePalindrome.find("tttt"));
        assertEquals("ttt", PalindromePalindrome.find("tt"));
        assertEquals("ababa", PalindromePalindrome.find("aba"));
        assertEquals("", PalindromePalindrome.find(""));
        assertEquals("tt", PalindromePalindrome.find("t"));
        assertEquals("tttttt", PalindromePalindrome.find("ttttt"));
        assertEquals("aaa", PalindromePalindrome.find("aa"));
        assertEquals("AA", PalindromePalindrome.find("A"));
        assertEquals("ABA", PalindromePalindrome.find("AB"));
        assertEquals("ABBA", PalindromePalindrome.find("ABB"));
        assertEquals("ABBA", PalindromePalindrome.find("ABB"));
        assertEquals("AAAA", PalindromePalindrome.find("AAA"));
        assertEquals("abcddcba", PalindromePalindrome.find("abcdd"));
        assertEquals("acca", PalindromePalindrome.find("acc"));
        assertEquals("NoN", PalindromePalindrome.find("No"));
        assertEquals("NooN", PalindromePalindrome.find("Noo"));
        assertEquals("NoooN", PalindromePalindrome.find("Nooo"));
        assertEquals("NooOooN", PalindromePalindrome.find("NooO"));
        assertEquals("abababa", PalindromePalindrome.find("ababab"));
        assertEquals("aaaaaaaaaaa", PalindromePalindrome.find("aaaaaaaaaa"));
        assertEquals("aaaaaaaaaaaa", PalindromePalindrome.find("aaaaaaaaaaa"));
        assertEquals("ZZZZAZZZZ", PalindromePalindrome.find("ZZZZA"));
        assertEquals("OnLineniLnO", PalindromePalindrome.find("OnLine"));
        assertEquals("AbabaAababA", PalindromePalindrome.find("AbabaAa"));
    }
}
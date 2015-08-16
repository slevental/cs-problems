package google;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Stas on 8/15/15.
 */
public class StringCleaningTest {

    @Test
    public void test_str_clearing() throws Exception {
        assertEquals("looo", StringCleaning.answer("lololololo", "lol"));
        assertEquals("dogfood", StringCleaning.answer("goodgooogoogfogoood", "goo"));

    }
}
package careercup;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by Stas on 11/14/15.
 */
public class StreamOfWordsTest {
    @Test
    public void test() throws Exception {
        StreamOfWords stream = new StreamOfWords(Arrays.asList("ok","ook", "test", "one", "try", "trying"), System.out::println);
        char[] chars = {'a', 'b', 'c', 'o', 'k', 'd', 'e', 'f', 't', 'r', 'y', 'i', 'n', 'g', 'o','o','k'};
        for (char aChar : chars) {
            stream.putChar(aChar);
        }
    }
}
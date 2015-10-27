package cs101;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by Stas on 10/16/15.
 */
public class SymbolicSequenceTest {
    @Test
    public void test_seq() throws Exception {
        Map<String, Integer> counts = new HashMap<>();
        String seq = SymbolicSequence.generate();
        assertNotNull(seq);
        assertEquals(1000000, seq.length());
        for (int i = 0; i < seq.length(); i++) {
            inc(counts, seq.substring(i, i + 1));
            if (i < seq.length() - 1)
                inc(counts, seq.substring(i, i + 2));
            if (i < seq.length() - 2)
                inc(counts, seq.substring(i, i + 3));
        }

        assertCounts(counts);
    }

    private void assertCounts(Map<String, Integer> counts) {
        for (Map.Entry<String, Integer> each : counts.entrySet()) {
            int len = each.getKey().length();
            Integer count = each.getValue();
            if (len == 1) assertTrue(count < 40000);
            else if (len == 2) assertTrue(count < 2000);
            else if (len == 3) assertTrue(count < 100);
            else fail();
        }
    }

    private void inc(Map<String, Integer> counts, String substring) {
        Integer cnt = counts.get(substring);
        if (cnt == null) {
            cnt = 0;
        }
        counts.put(substring, cnt + 1);
    }
}
package dynamic;

import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * Created by Stas on 9/29/15.
 */
public class KnapsackTest {
    @Test
    public void test_sample_cases() throws Exception {
        assertEquals(12, Knapsack.fit(new int[]{1, 6, 9}, 0, 12, new HashMap<>(), 0));
        assertEquals(9, Knapsack.fit(new int[]{3, 4, 4, 4, 8}, 0, 9, new HashMap<>(), 0));
    }
}
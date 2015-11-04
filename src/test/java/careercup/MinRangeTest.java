package careercup;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Stas on 10/27/15.
 */
public class MinRangeTest {

    @Test
    public void test_simple() throws Exception {
        List<int[]> in = new ArrayList<>();
        in.add(new int[]{4, 10, 15, 24, 26});
        in.add(new int[]{0, 9, 12, 20});
        in.add(new int[]{5, 18, 22, 30});
        assertArrayEquals(new int[]{20, 24}, MinRange.minRange(in));
    }
}
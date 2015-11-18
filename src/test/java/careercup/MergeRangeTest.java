package careercup;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by Stas on 11/14/15.
 */
public class MergeRangeTest {/*
NOTE: Array range (2,6) represents (2,3,4,5,6)

INPUT: [(2,6),(3,5),(7,21),(20,21)]
OUTPUT: [(2,6),(7,21)]
*/
    @Test
    public void testName() throws Exception {
        MergeRange.merge(Arrays.asList(
                new MergeRange.Interval(2,6),
                new MergeRange.Interval(3,5),
                new MergeRange.Interval(7,21),
                new MergeRange.Interval(20,21)
        )).forEach(System.out::println);
    }
}
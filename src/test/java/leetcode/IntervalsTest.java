package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Stas on 10/25/15.
 */
public class IntervalsTest {

    @Test
    public void test_intervals() throws Exception {
        ArrayList<Intervals.Interval> l = new ArrayList<>();
        l.add(new Intervals.Interval(1,3));
        l.add(new Intervals.Interval(6,9));
        List<Intervals.Interval> res = new Intervals().insert(l, new Intervals.Interval(2, 5));
        ArrayList<Intervals.Interval> exp = new ArrayList<>();
        exp.add(new Intervals.Interval(1,5));
        exp.add(new Intervals.Interval(6,9));
        assertEquals(exp, res);
    }
    @Test
    public void test_intervals2() throws Exception {
        ArrayList<Intervals.Interval> l = new ArrayList<>();
        l.add(new Intervals.Interval(1,5));
        l.add(new Intervals.Interval(6,8));
        List<Intervals.Interval> res = new Intervals().insert(l, new Intervals.Interval(0, 9));
        ArrayList<Intervals.Interval> exp = new ArrayList<>();
        exp.add(new Intervals.Interval(0,9));
        assertEquals(exp, res);
    }
}
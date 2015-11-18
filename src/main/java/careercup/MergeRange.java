package careercup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stas on 11/14/15.
 */
public class MergeRange {
     static List<Interval> merge(List<Interval> ranges) {
        if (ranges.size() > 1) {
            int mid = ranges.size() >>> 1;
            return join(
                    merge(ranges.subList(0, mid)),
                    merge(ranges.subList(mid, ranges.size()))
            );
        }
        return ranges;
    }

    private static List<Interval> join(List<Interval> l, List<Interval> r) {
        int i = 0;
        int j = 0;

        List<Interval> res = new ArrayList<>();

        while (i < l.size() && j < r.size()) {
            Interval lRange = l.get(i);
            Interval rRange = r.get(j);
            if (lRange.intercepts(rRange)) {
                res.add(lRange.join(rRange));
                i++;
                j++;
            } else if (lRange.lo < rRange.lo) {
                res.add(lRange);
                i++;
            } else {
                res.add(lRange);
                j++;
            }
        }
        while (i < l.size()) res.add(l.get(i++));
        while (j < r.size()) res.add(r.get(j++));

        return res;
    }


    static class Interval {
        int lo, hi;

        public Interval(int lo, int hi) {
            this.lo = lo;
            this.hi = hi;
        }

        public boolean intercepts(Interval that) {
            return this.hi >= that.lo && this.lo <= that.hi;
        }

        public Interval join(Interval that) {
            return new Interval(Math.min(this.lo, that.lo), Math.max(this.hi, that.hi));
        }

        @Override
        public String toString() {
            return "Interval{" +
                    "lo=" + lo +
                    ", hi=" + hi +
                    '}';
        }
    }
}

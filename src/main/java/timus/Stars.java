package timus;

import java.io.*;
import java.util.*;

/**
 * Created by Stas on 10/21/15.
 */
public class Stars {

    private static int nextInt(StreamTokenizer st) throws Exception {
        int token = st.nextToken();
        while (token != StreamTokenizer.TT_NUMBER) token = st.nextToken();
        return (int) st.nval;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer st = new StreamTokenizer(in);

        int N = nextInt(st);
        List<Point> x = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            x.add(new Point(nextInt(st), nextInt(st)));
        }

        int[] ints = rateStars(x);
        try (BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out, "UTF-8"))) {
            for (int n : ints) w.write(n + "\n");
        }
    }

    private static int[] rateStars(List<Point> points) {
        double maxX = 0;
        for (Point point : points) maxX = Math.max(maxX, point.x);
        int[] res = new int[points.size()];
        FenwickTree fenwickTree = new FenwickTree(64000);
        for (Point point : points) {
            res[fenwickTree.sum(point.x)]++;
            fenwickTree.add(point.x, 1);
        }
        return res;
    }

    private static class Point implements Comparable<Point> {
        final int x;
        final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "[" + x + ", " + y + "]";
        }

        @Override
        public int compareTo(Point o) {
            if (this.x != o.x)
                return this.x - o.x;
            return this.y - o.y;
        }
    }

    public static class FenwickTree {
        private int[] t;

        public FenwickTree(int size) {
            this.t = new int[size];
        }

        public void add(int i, int value) {
            for (; i < t.length; i |= i + 1)
                t[i] += value;
        }

        public int sum(int i) {
            int res = 0;
            for (; i >= 0; i = (i & (i + 1)) - 1)
                res += t[i];
            return res;
        }
    }

}

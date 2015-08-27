package google;

import java.util.Arrays;
import java.util.Comparator;

import static java.lang.Math.abs;

/**
 * Created by Stas on 8/24/15.
 */
public class Carrotland {

    public static int answer(int[][] vex) {
        Point[] p = new Point[vex.length];
        for (int i = 0; i < vex.length; i++) {
            p[i] = new Point(vex[i][0], vex[i][1]);
        }
        Triangle t = new Triangle(p);
        return t.estimatePoints();
    }

    public static class Point {
        final int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public String toString() {
            return "[" + x + ", " + y + "]";
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }

    public static class Line {
        final Point p1, p2;
        final double a, b;

        Line(Point... p) {
            this.p1 = p[0];
            this.p2 = p[1];
            this.b = 1. / (p2.x - p1.x) * (p1.y * p2.x - p1.x * p2.y);
            this.a = p1.x != 0 ? (p1.y - b) / p1.x : (p2.y - b) / p2.x;
        }

        double value(int x) {
            return this.a * x + this.b;
        }

        int latticePoints() {
            return gcd(abs(p2.x - p1.x), abs(p2.y - p1.y)) - 1;
        }

        private int gcd(int a, int b) {
            return b == 0 ? a : gcd(b, a % b);
        }
    }

    public static class Triangle {
        final Point[] xscaled;
        final Point[] yscaled;

        Triangle(Point... points) {
            this.xscaled = points.clone();
            this.yscaled = points.clone();
            Arrays.sort(this.xscaled, X_CMP);
            Arrays.sort(this.yscaled, Y_CMP);
        }

        Point leftMost() {
            return xscaled[0];
        }

        Point topMost() {
            return yscaled[2];
        }

        Point bottomMost() {
            return xscaled[0];
        }

        Point middle() {
            return xscaled[1];
        }

        Point rightMost() {
            return xscaled[2];
        }

        int estimatePoints() { //using Pick's theorem
            int j = rightMost().x - leftMost().x;
            int k = topMost().y - bottomMost().y;
            long points = (j - 1) * (k - 1);
            for (int i = 0; i < 3; i++) {
                Point a = xscaled[i];
                Point b = xscaled[(i + 1) % 3];
                Point c = xscaled[(i + 2) % 3];

                Line l = new Line(a, b);
                long ac = abs(a.y - b.y);
                long bc = abs(a.x - b.x);
                if (ac > 0 && bc > 0)
                    points -= ((ac - 1) * (bc - 1) - l.latticePoints()) / 2 + l.latticePoints();

                if (a.x == leftMost().x
                        || a.x == rightMost().x
                        || a.y == topMost().y
                        || a.y == bottomMost().y) continue;

                Line d = new Line(b, c);
                long k1, k2;
                if (a.y > d.value(a.x)) {
                    k1 = a.x - leftMost().x;
                    k2 = topMost().y - a.y;
                } else {
                    k1 = rightMost().x - a.x;
                    k2 = a.y - bottomMost().y;
                }
                points -= k1 * k2;
            }

            return (int) points;
        }

        static final Comparator<Point> X_CMP = new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                int c = o1.x - o2.x;
                if (c != 0) return c;
                return o1.y - o2.y;
            }
        };

        static final Comparator<Point> Y_CMP = new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                int c = o1.y - o2.y;
                if (c != 0) return c;
                return o1.x - o2.x;
            }
        };
    }
}

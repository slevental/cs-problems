package timus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Stas on 10/21/15.
 */
public class StarsKdTree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        List<Point2D> points = new ArrayList<>();
        while (size-- > 0)
            points.add(new Point2D(scanner.nextInt(), scanner.nextInt()));

        int[] res = rateStars(points);
        for (int rate : res) {
            System.out.println(rate);
        }
    }

    private static int[] rateStars(List<Point2D> points) {
        int[] res = new int[points.size()];
        KdTree kdTree = new KdTree();
        int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE;

        for (Point2D each : points) {
            kdTree.insert(each);
            minX = Math.min(minX, each.x());
            minY = Math.min(minY, each.y());
        }

        for (Point2D point : points) {
            KdTree.Entry entry = kdTree.get(point);
            int size = entry.left == null ? 0 : entry.left.size;
            res[size]++;
        }

        return res;
    }

    public static class Point2D implements Comparable<Point2D> {
        private final int x;    // x coordinate
        private final int y;    // y coordinate

        // create a new point (x, y)
        public Point2D(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int x() {
            return x;
        }

        public int y() {
            return y;
        }

        // compare by y-coordinate, breaking ties by x-coordinate
        public int compareTo(Point2D that) {
            if (this.y < that.y) return -1;
            if (this.y > that.y) return +1;
            if (this.x < that.x) return -1;
            if (this.x > that.x) return +1;
            return 0;
        }

        // does this point equal y?
        public boolean equals(Object other) {
            if (other == this) return true;
            if (other == null) return false;
            if (other.getClass() != this.getClass()) return false;
            Point2D that = (Point2D) other;
            return this.x == that.x && this.y == that.y;
        }

        // convert to string
        public String toString() {
            return "(" + x + ", " + y + ")";
        }
    }

    public static class RectHV {
        private final int xmin, ymin;   // minimum x- and y-coordinates
        private final int xmax, ymax;   // maximum x- and y-coordinates

        // construct the axis-aligned rectangle [xmin, xmax] x [ymin, ymax]
        public RectHV(int xmin, int ymin, int xmax, int ymax) {
            if (xmax < xmin || ymax < ymin) {
                throw new IllegalArgumentException("Invalid rectangle");
            }
            this.xmin = xmin;
            this.ymin = ymin;
            this.xmax = xmax;
            this.ymax = ymax;
        }

        // does this axis-aligned rectangle intersect that one?
        public boolean intersects(RectHV that) {
            return this.xmax >= that.xmin && this.ymax >= that.ymin
                    && that.xmax >= this.xmin && that.ymax >= this.ymin;
        }

        public boolean contains(Point2D p) {
            return (p.x() >= xmin) && (p.x() <= xmax)
                    && (p.y() >= ymin) && (p.y() <= ymax);
        }

        // are the two axis-aligned rectangles equal?
        public boolean equals(Object y) {
            if (y == this) return true;
            if (y == null) return false;
            if (y.getClass() != this.getClass()) return false;
            RectHV that = (RectHV) y;
            if (this.xmin != that.xmin) return false;
            if (this.ymin != that.ymin) return false;
            if (this.xmax != that.xmax) return false;
            if (this.ymax != that.ymax) return false;
            return true;
        }

        // return a string representation of this axis-aligned rectangle
        public String toString() {
            return "[" + xmin + ", " + xmax + "] x [" + ymin + ", " + ymax + "]";
        }
    }

    public static class KdTree {
        private Entry head;
        private int size;

        private static final int XMIN = 0;
        private static final int XMAX = Integer.MAX_VALUE;

        private static final int YMIN = 0;
        private static final int YMAX = Integer.MAX_VALUE;

        public KdTree() {
        }

        // number of points in the set
        public int size() {
            return size;
        }

        // add the point p to the set (if it is not already in the set)
        public void insert(Point2D p) {
//            if (!contains(p)) size++;
            head = insert(head, p, true);
        }

        // does the set contain the point p?
        public boolean contains(Point2D p) {
            return contains(head, p);
        }

        public int count(final RectHV rect) {
            return count(head, rect);
        }

        private int count(Entry node, RectHV rect) {
            int res = 0;
            if (node == null) {
                return res;
            }
            if (rect.contains(node.val)) {
                res++;
            }
            if (leftIntersects(node, rect)) {
                res += count(node.left, rect);
            }
            if (rightIntersects(node, rect)) {
                res += count(node.right, rect);
            }
            return res;
        }

        private boolean leftIntersects(Entry node, RectHV rect) {
            int xmax = node.vertical ? node.val.x() : XMAX;
            int ymax = node.vertical ? YMAX : node.val.y();
            return xmax >= rect.xmin && ymax >= rect.ymin
                    && rect.xmax >= XMIN && rect.ymax >= YMIN;
        }

        private boolean rightIntersects(Entry node, RectHV rect) {
            int xmin = node.vertical ? node.val.x() : XMIN;
            int ymin = node.vertical ? YMIN : node.val.y();
            return rect.xmax >= xmin && rect.ymax >= ymin;
        }


        private RectHV leftRect(Entry node) {
            int xmax = node.vertical ? node.val.x() : XMAX;
            int ymax = node.vertical ? YMAX : node.val.y();
            return new RectHV(XMIN, YMIN, xmax, ymax);
        }

        private RectHV rightRect(Entry node) {
            int xmin = node.vertical ? node.val.x() : XMIN;
            int ymin = node.vertical ? YMIN : node.val.y();
            return new RectHV(xmin, ymin, XMAX, YMAX);
        }

        private double cmp(Entry node, Point2D val) {
            return cmp(node, val.x(), val.y());
        }

        private double cmp(Entry node, double x, double y) {
            double dx = node.val.x() - x;
            double dy = node.val.y() - y;

            if (node.vertical && dx != 0) {
                return dx;
            } else if (!node.vertical && dy != 0) {
                return dy;
            } else if (node.vertical) {
                return dy;
            } else {
                return dx;
            }
        }

        private Entry insert(Entry node, Point2D val, boolean vertical) {
            if (node == null) {
                return new Entry(vertical, val);
            }

            double cmp = cmp(node, val);
            if (cmp > 0) {
                node.left = insert(node.left, val, !vertical);
            } else if (cmp < 0) {
                node.right = insert(node.right, val, !vertical);
            } else {
                node.val = val;
            }

            node.size = size(node.left) + size(node.right) + 1;
            return node;
        }

        private int size(Entry node) {
            return node == null ? 0 : node.size;
        }

        private boolean contains(Entry node, Point2D val) {
            while (node != null) {
                double cmp = cmp(node, val);
                if (cmp > 0) {
                    node = node.left;
                } else if (cmp < 0) {
                    node = node.right;
                } else {
                    return true;
                }
            }
            return false;
        }

        public Entry get(Point2D val) {
            return get(head, val);
        }

        private Entry get(Entry node, Point2D val) {
            while (node != null) {
                double cmp = cmp(node, val);
                if (cmp > 0) {
                    node = node.left;
                } else if (cmp < 0) {
                    node = node.right;
                } else {
                    return node;
                }
            }
            return null;
        }


        private static class Entry {
            Entry left;
            Entry right;

            int size = 1;

            Point2D val;
            boolean vertical;

            public Entry(boolean vertical, Point2D v) {
                this.vertical = vertical;
                this.val = v;
            }
        }
    }
}

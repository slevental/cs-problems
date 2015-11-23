package timus;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.ToIntBiFunction;

/**
 * Created by Stas on 11/21/15.
 */
public class WarGames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int[] ints = new int[n];
        Arrays.fill(ints, 1);
        SegmentTree sum = new SegmentTree(ints, (a, b) -> a + b, 0);

        int ptr = k - 1;
        int offset = k;
        while (sum.get() > 0) {
            out.print((ptr + 1));

            if (sum.get() > 1)
                out.print(" ");
            sum.set(ptr, 0);

            int left = sum.get();
            if (left == 0)
                break;
            else if (left < k)
                offset = k % left;

            if (offset == 0) offset = left;

            ptr = sum.find(ptr, offset);
        }
        out.println();
        out.flush();
    }


    private static class SegmentTree {
        private final int[] tree;
        private final int size;
        private final ToIntBiFunction<Integer, Integer> func;
        private final int def;

        public SegmentTree(int[] ints, ToIntBiFunction<Integer, Integer> func, int def) {
            this.func = func;
            this.def = def;
            size = ints.length - 1;
            tree = new int[ints.length * 4];
            Arrays.fill(tree, def);
            constructTree(ints, tree, 0, ints.length - 1, 0);
        }

        private void constructTree(int[] from, int[] to, int lo, int hi, int pos) {
            if (lo == hi) {
                to[pos] = from[lo];
                return;
            }
            int mid = (lo + hi) >> 1;
            constructTree(from, to, lo, mid, 2 * pos + 1);
            constructTree(from, to, mid + 1, hi, 2 * pos + 2);
            to[pos] = func.applyAsInt(to[2 * pos + 1], to[2 * pos + 2]);
        }

        public int get(int lo, int hi) {
            return get(lo, hi, 0, size, 0);
        }

        private int get(int qlo, int qhi, int lo, int hi, int pos) {
            if (qlo <= lo && qhi >= hi) // contains
                return tree[pos];
            if (qhi < lo || qlo > hi)
                return def;
            int mid = (lo + hi) >> 1;

            return func.applyAsInt(
                    get(qlo, qhi, lo, mid, 2 * pos + 1),
                    get(qlo, qhi, mid + 1, hi, 2 * pos + 2)
            );
        }

        private int find(int pos, int v) {
            int s = get(pos, size);
            if (s >= v)
                return find(pos, size, v);
            else
                return find(0, pos, v - s);
        }

        private int find(int lo, int hi, int val) {
            int from = lo;
            while (lo <= hi) {
                int pos = (lo + hi) >> 1;
                int v = get(from, pos);
                if (v > val)
                    hi = pos - 1;
                else if (v < val)
                    lo = pos + 1;
                else if (lo != pos)
                    hi = pos;
                else return pos;
            }
            return -1;
        }

        public void set(int v, int value) {
            set(0, size, 0, v, value);
        }

        private void set(int lo, int hi, int pos, int i, int value) {
            if (lo == hi) {
                tree[pos] = value;
                return;
            }
            int mid = (hi + lo) >> 1;
            if (i <= mid) set(lo, mid, 2 * pos + 1, i, value);
            else set(mid + 1, hi, 2 * pos + 2, i, value);
            tree[pos] = func.applyAsInt(tree[2 * pos + 1], tree[2 * pos + 2]);
        }

        public int get() {
            return tree[0];
        }


    }
}

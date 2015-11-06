package timus;

import java.io.IOException;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Stas on 10/30/15.
 */
public class AnansiWeb {
    public static void main(String[] args) throws IOException {
        Scanner r = new Scanner(System.in);
        int n = r.nextInt();
        int m = r.nextInt();
        Edge[] edges = new Edge[m + 1];
        for (int i = 1; i <= m; i++) {
            edges[i] = new Edge(r.nextInt(), r.nextInt());
        }

        int size = r.nextInt();
        Stack<Integer> list = new Stack<>();
        BitSet bitSet = new BitSet();
        while (size-- > 0) {
            int item = r.nextInt();
            bitSet.set(item);
            list.push(item);
        }

        Stack<Integer> res = calc(n, edges, bitSet, list);

        while (!res.isEmpty()) {
            Integer num = res.pop();
            System.out.print(num);
            if (!res.empty()) System.out.print(" ");
        }
    }

    private static Stack<Integer> calc(int n, Edge[] edges, BitSet bitSet, Stack<Integer> list) {
        Stack<Integer> res = new Stack<>();
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < edges.length; i++) {
            if (!bitSet.get(i)) {
                Edge edge = edges[i];
                if (edge != null)
                    uf.union(edge.from, edge.to);
            }
        }

        res.push(uf.n);

        while (!list.isEmpty()) {
            Integer toRem = list.pop();
            Edge edge = edges[toRem];
            uf.union(edge.from, edge.to);
            if (!list.isEmpty())
                res.push(uf.n);
        }

        return res;
    }


    private static class UnionFind {
        private final int[] data;
        private final int[] size;
        private int n;

        private UnionFind(int n) {
            this.n = n;
            this.data = new int[n + 1];
            this.size = new int[n + 1];
            for (int i = 1; i < data.length; i++) {
                data[i] = i;
                size[i] = 1;
            }
        }

        void union(int i, int j) {
            i = find(i);
            j = find(j);

            if (i == j) return;

            if (size[j] < size[i]) {
                data[j] = i;
                size[i] += size[j];
            } else {
                data[i] = j;
                size[j] += size[i];
            }

            n--;
        }

        int find(int i) {
            while (data[i] != i) i = data[i];
            return i;
        }
    }

    private static class Edge {
        final int from;
        final int to;

        public Edge(int from, int to) {
            this.from = from;
            this.to = to;
        }
    }
}

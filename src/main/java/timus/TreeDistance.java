package timus;

import java.io.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Stas on 11/15/15.
 */
@SuppressWarnings("unchecked")
public class TreeDistance {

    public static final int N = 50000;
    private final int[] tin;
    private final int[] tout;
    private final int[] distance;
    private final int[][] p;
    private final Set[] tree;
    private final int root;
    private int l;

    public TreeDistance(Set[] tree, int root) {
        this.tree = tree;
        this.root = root;
        int n = tree.length;
        l = 1;
        while ((1 << l) <= n) ++l;
        p = new int[n][l + 1];
        distance = new int[n];
        tin = new int[n];
        tout = new int[n];
        BitSet visited = new BitSet();
        dfs(this.tree, root, 0, root, p, tin, tout, distance, new AtomicInteger(), visited);
    }

    private void dfs(Set[] tree, int node, int w, int parent, int[][] p, int[] tin, int[] tout, int[] distance, AtomicInteger timer, BitSet visited) {
        if (!visited.get(node)) {
            visited.set(node);
            distance[node] = distance[parent] + w;
            tin[node] = timer.incrementAndGet();
            p[node][0] = parent;
            for (int i = 1; i <= l; i++)
                p[node][i] = p[p[node][i - 1]][i - 1];
            for (Edge edge : (Set<Edge>) tree[node])
                dfs(tree, edge.node, edge.weight, node, p, tin, tout, distance, timer, visited);
            tout[node] = timer.incrementAndGet();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StreamTokenizer tokenizer = new StreamTokenizer(in);
        int size = nextInt(tokenizer);

        Set[] tree = new Set[size + 1];

        for (int i = 0; i < tree.length; i++) {
            tree[i] = new HashSet<>();
        }

        while (size-- > 1) {
            int u = nextInt(tokenizer);
            int v = nextInt(tokenizer);
            int w = nextInt(tokenizer);
            tree[u].add(new Edge(v, w));
            tree[v].add(new Edge(u, w));
        }

        TreeDistance t = new TreeDistance(tree, 0);

        int req = nextInt(tokenizer);
        while (req-- > 0)
            out.println(t.shortestPath(nextInt(tokenizer), nextInt(tokenizer)));

        out.flush();
    }

    private static int nextInt(StreamTokenizer tokenizer) throws IOException {
        while (tokenizer.nextToken() != StreamTokenizer.TT_NUMBER) ;
        return (int) tokenizer.nval;
    }

    private int shortestPath(int a, int b) {
        if (upper(a, b)) return distance[b] - distance[a];
        if (upper(b, a)) return distance[a] - distance[b];

        int tmp = a;
        for (int i = l; i >= 0; --i)
            if (!upper(p[tmp][i], b))
                tmp = p[tmp][i];

        int toLca = distance[p[tmp][0]];
        int toU = distance[a];
        int toV = distance[b];
        return toU + toV - toLca * 2;
    }

    boolean upper(int a, int b) {
        return tin[a] <= tin[b] && tout[a] >= tout[b];
    }

    public static class Edge {
        final int node;
        final int weight;

        public Edge(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }
}

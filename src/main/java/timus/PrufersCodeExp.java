package timus;

import java.io.*;
import java.util.Arrays;
import java.util.BitSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Created by Stas on 11/10/15.
 */
public class PrufersCodeExp {
    public static void main(String[] args) throws Exception {
        InputStream source = System.in;
        BufferedReader in = new BufferedReader(new InputStreamReader(source));
        StringTokenizer tokenizer = new StringTokenizer(in.readLine());
        int[] line = new int[tokenizer.countTokens()];
        int n = 0;
        while (tokenizer.hasMoreTokens())
            line[n++] = Integer.parseInt(tokenizer.nextToken());

        PriorityQueue[] graph = buildTree(line, n);
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        for (int i = 0; i < graph.length; i++) {
            PriorityQueue<Integer> queue = graph[i];
            if (queue == null) continue;

            out.printf("%d: ", i);
            int prev = 0;
            while (!queue.isEmpty()) {
                Integer poll = queue.poll();
                if (poll == prev) continue;
                out.print(poll);
                prev = poll;
                if (!queue.isEmpty()) out.print(" ");
            }
            out.println();
        }
        out.flush();
    }

    private static PriorityQueue[] buildTree(int[] code, int n) {
        int last = code[n - 1];
        int[] edges = new int[n + 2];
        PriorityQueue[] res = new PriorityQueue[n + 2];

        Arrays.fill(edges, 1, n + 2, 1);
        edges[last] = 0;
        for (int i = 0; i < n; i++)
            edges[code[i]]++;

        BitSet leafs = new BitSet(n);

        for (int i = 1; i < n + 2; i++)
            if (edges[i] == 1) leafs.set(i);

        int point = 0;
        for (int c : code) {
            int l = leafs.nextSetBit(point);
            point = l;
            leafs.set(l, false);

            init(res, c, l);
            init(res, l, c);

            if (--edges[c] == 1) {
                leafs.set(c);
                if (c < point) point = c;
            }
        }

        return res;
    }

    public static PriorityQueue init(PriorityQueue[] q, int idx, int val) {
        PriorityQueue list = q[idx];
        if (list == null) {
            list = new PriorityQueue();
            q[idx] = list;
        }
        list.add(val);
        return list;
    }
}

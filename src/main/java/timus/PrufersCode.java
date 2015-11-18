package timus;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Stas on 11/10/15.
 */
public class PrufersCode {

    public static void main(String[] args) throws Exception {
        InputStream source = System.in;

        source = new FileInputStream("test.lst");

        BufferedReader in = new BufferedReader(new InputStreamReader(source));
        StringTokenizer tokenizer = new StringTokenizer(in.readLine());
        int[] line = new int[tokenizer.countTokens()];
        int n = 0;
        while (tokenizer.hasMoreTokens()) {
            line[n++] = Integer.parseInt(tokenizer.nextToken());
        }

        List[] graph = buildTree(line, n);

        for (int i = 1; i < graph.length; i++) {
            List set = graph[i];
            if (set == null) continue;
            Collections.sort(set);
            System.out.printf("%d: ", i);
            for (int j = 0, val = -1; j < set.size(); j++) {
                int x = (int) set.get(j);
                if (x != val)
                    System.out.print(x);
                val = x;
                if (j < set.size() - 1)
                    System.out.print(" ");
            }
            System.out.println();
        }
    }

    private static List[] buildTree(int[] code, int n) {
        int last = code[n - 1];
        List[] res = new List[n + 2];
        int[] edges = new int[n + 2];
        BitSet leafs = new BitSet();

        Arrays.fill(edges, 1, n + 2, 1);
        edges[last] = 0;

        for (int i = 0; i < n; i++)
            edges[code[i]]++;

        for (int i = 1; i < n + 2; i++)
            if (edges[i] == 1) leafs.set(i);

        int point = 0;
        for (int c : code) {
            int l = leafs.nextSetBit(point);
            leafs.set(l, false);
            point = l;
            setToRes(res, c, l);
            setToRes(res, l, c);
            if (--edges[c] == 1) {
                leafs.set(c);
                if (c < point) point = c;
            }
        }

        return res;
    }

    public static void setToRes(List[] res, int idx, int val) {
        List re = res[idx];
        if (re == null) {
            re = new ArrayList<>();
            res[idx] = re;
        }
        re.add(val);
    }

    static class InsertionSort {
        public static void sort(List<Integer> arr) {
            for (int i = 1; i < arr.size(); i++) {
                int k = i;
                while (k > 0 && arr.get(k) < arr.get(k - 1)) {
                    swap(arr, k, k - 1);
                    k--;
                }
            }
        }

        private static void swap(List<Integer> arr, int i, int j) {
            int x = arr.get(i);
            arr.set(i, arr.get(j));
            arr.set(j, x);
        }

    }

}

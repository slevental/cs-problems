package timus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Stas on 10/30/15.
 */
public class PenguinAvia {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(r.readLine());
        String[] split = r.readLine().split("\\s+");
        int d = Integer.parseInt(split[0]);
        int a = Integer.parseInt(split[1]);
        int[][] graph = new int[size][size];
        for (int i = 0; i < size; i++) {
            String line = r.readLine();
            for (int j = 0; j < size; j++) {
                graph[i][j] = line.charAt(j) - '0';
            }
        }

        AtomicLong cost = new AtomicLong();
        char[][] res = optimize(graph, d, a, cost);

        System.out.println(cost.get());
        for (int i = 0; i < res.length; i++) {
            char[] each = res[i];
            for (char c : each) System.out.print(c);
            if (i < res.length - 1)
                System.out.println();
        }
    }

    private static char[][] optimize(int[][] graph, int d, int a, AtomicLong cost) {
        int n = graph.length;
        boolean[] visited = new boolean[n];
        char[][] res = new char[n][n];
        for (char[] re : res) Arrays.fill(re, '0');
        int[] edgeTo = new int[n];
        int visits = 0;
        int start = 0;

        while ((visits += dfs(graph, start, visited, edgeTo, res, d, cost)) < n) {
            int i = start;
            while (visited[++i]) ;
            if (res[i][start] == '0') cost.addAndGet(a);
            res[start][i] = 'a';
            res[i][start] = 'a';
            start = i;
        }

        return res;
    }

    private static int dfs(int[][] graph, int v, boolean[] visited, int[] path, char[][] res, int d, AtomicLong cost) {
        int visit = 1;
        visited[v] = true;
        for (int i = 0; i < graph.length; i++) {
            if (graph[v][i] != 0) {
                if (v == i || path[v] == i)
                    continue;
                if (!visited[i]) {
                    path[i] = v;
                    visit += dfs(graph, i, visited, path, res, d, cost);
                } else {
                    if (res[i][v] == '0') cost.addAndGet(d);
                    res[i][v] = 'd';
                    res[v][i] = 'd';
                }
            }
        }
        return visit;
    }

}

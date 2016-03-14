package timus;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.BitSet;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Stas on 12/23/15.
 */
public class Conference {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer st = new StreamTokenizer(in);

        int n = nextInt(st);
        int m = nextInt(st);
        int k = nextInt(st);

        Set[] graph = new Set[n + 1];
        while (k-- > 0) {
            int from = nextInt(st);
            int to = nextInt(st);
            Set list = graph[from];
            if (list == null) {
                list = new HashSet<>();
                graph[from] = list;
            }
            list.add(to);
        }

        int minMatch = min(graph, n, m);
        System.out.println(minMatch);
    }

    private static int nextInt(StreamTokenizer st) throws Exception {
        int token = st.nextToken();
        while (token != StreamTokenizer.TT_NUMBER) token = st.nextToken();
        return (int) st.nval;
    }

    private static int min(Set[] graph, int n, int m) {
        int[] match1 = new int[m + 1];
        int[] match2 = new int[n + 1];

        int result = 0;
        for (int u = 1; u <= n; u++) {
            BitSet seen = new BitSet();
            if (bpm(graph, u, seen, match1, match2))
                result++;
        }

        for (int i = 1; i <= n; i++) if (match2[i] == 0) result++;
        for (int i = 1; i <= m; i++) if (match1[i] == 0) result++;

        return result;
    }

    private static boolean bpm(Set[] graph, int u, BitSet seen, int[] match1, int[] match2) {
        for (Integer v : (Set<Integer>) graph[u]) {
            if (!seen.get(v)) {
                seen.set(v);
                if (match1[v] == 0 || bpm(graph, match1[v], seen, match1, match2)) {
                    match1[v] = u;
                    match2[u] = v;
                    return true;
                }
            }
        }
        return false;
    }
}

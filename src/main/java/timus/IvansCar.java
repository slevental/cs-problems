package timus;

import java.util.*;

/**
 * Created by Stas on 10/27/15.
 */
@SuppressWarnings("unchecked")
public class IvansCar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int v = scanner.nextInt();
        int e = scanner.nextInt();
        Graph graph = new Graph(v);
        while (e-- > 0) {
            int from = scanner.nextInt();
            int to = scanner.nextInt();
            graph.road(from, to, 1);
            graph.road(to, from, -1);
        }
        int start = scanner.nextInt();
        int end = scanner.nextInt();

        System.out.println(find(graph, start, end));
    }

    private static int find(Graph graph, int start, int end) {
        int current;
        int fine = 0;
        PriorityQueue<Graph.Edge> queue = new PriorityQueue<>();
        addToQueue(graph.v[start], 0, 0, queue);
        BitSet visited = new BitSet();
        while (!queue.isEmpty()) {
            Graph.Edge poll = queue.poll();
            if (visited.get(poll.v)) continue;

            visited.set(poll.v);

            fine = poll.fine;
            current = poll.weight;

            if (end == poll.v)
                return fine;

            addToQueue(graph.v[poll.v], current, fine, queue);
        }

        return fine;
    }

    private static void addToQueue(Set set1, int current, int fine, PriorityQueue<Graph.Edge> queue) {
        Set<Graph.Edge> set = set1;
        for (Graph.Edge edge : set) {
            Graph.Edge e = new Graph.Edge(edge.v, edge.weight, current != 0 && current != edge.weight ? fine + 1 : fine);
            queue.add(e);
        }
    }

    private static class Graph {
        final Set[] v;

        public Graph(int v) {
            this.v = new Set[v + 1];
        }

        void road(int from, int to, int weight) {
            Set set = v[from];
            if (set == null) {
                set = v[from] = new HashSet();
            }
            set.add(new Edge(to, weight, 0));
        }

        static class Edge implements Comparable<Edge> {
            final int v;
            final int weight;
            final int fine;

            Edge(int v, int weight, int fine) {
                this.v = v;
                this.weight = weight;
                this.fine = fine;
            }

            @Override
            public int compareTo(Edge o) {
                return this.fine - o.fine;
            }
        }
    }
}

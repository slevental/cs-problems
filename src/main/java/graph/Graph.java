package graph;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Stas on 10/29/15.
 */
public class Graph {
    private final Set[] list;
    private final boolean directed;

    public Graph(int v, boolean directed) {
        this.directed = directed;
        this.list = new Set[v + 1];
    }

    public void addEdge(int from, int to) {
        edge(from, to);
        if (!directed) edge(to, from);
    }

    public Set<Integer> adj(int v) {
        Set set = list[v];
        return set == null ? new HashSet<>() : set;
    }

    private void edge(int from, int to) {
        Set set = list[from];
        if (set == null) {
            set = list[from] = new HashSet<>();
        }
        set.add(to);
    }

    public int size() {
        return list.length - 1;
    }
}

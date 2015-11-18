package careercup;

import java.util.*;
import java.util.function.Consumer;

/**
 * Created by Stas on 11/14/15.
 */
public class StreamOfWords {

    private final List<String> words;
    private final Consumer<String> apiCall;

    private final Set<Search> process = new HashSet<>();

    private Node root;

    public StreamOfWords(List<String> words, Consumer<String> apiCall) {
        this.words = words;
        this.apiCall = apiCall;
        for (String word : words) {
            root = add(root, word, 0);
        }
    }

    public void putChar(char c) {
        for (Iterator<Search> iterator = process.iterator(); iterator.hasNext(); ) {
            Search next = iterator.next();

            next.lastNode = find(next.lastNode.m, c);

            if (next.lastNode == null) {
                iterator.remove();
                continue;
            }

            next.word.append(c);

            if (next.lastNode.terminal) {
                String t = next.word.toString();
                if (!t.isEmpty())
                    apiCall.accept(t);
            }
        }

        Node node = find(root, c);
        if (node == null)
            return;

        if (node.terminal) apiCall.accept(String.valueOf(c));
        else process.add(new Search(node));
    }

    static Node find(Node n, char c) {
        if (n == null) return null;
        if (c < n.c) return find(n.l, c);
        else if (c > n.c) return find(n.r, c);
        else return n;
    }

    static Node add(Node n, String word, int pos) {
        char c = word.charAt(pos);
        if (n == null)
            n = new Node(c);

        if (c < n.c)                        n.l = add(n.l, word, pos);
        else if (c > n.c)                   n.r = add(n.r, word, pos);
        else if (pos < word.length() - 1)   n.m = add(n.m, word, pos + 1);
        else n.terminal = true;

        return n;
    }

    static class Node {
        final char c;

        boolean terminal = false;
        Node l, m, r;

        public Node(char c) {
            this.c = c;
        }
    }

    static class Search {
        Node lastNode;
        StringBuilder word = new StringBuilder();

        public Search(Node lastNode) {
            this.lastNode = lastNode;
            this.word.append(lastNode.c);
        }
    }
}

package strings;

/**
 * Created by Stas on 8/13/15.
 */
public class SuffixTree {
    private static final char END = '\u0000';
    private final Alphabet alphabet;
    private final Node[] nodes;

    private SuffixTree(String txt) {
        String text = txt + END;
        alphabet = new Alphabet(txt);
        nodes = new Node[alphabet.size()];

        for (int i = 0; i < txt.length(); i++) {
            int idx = alphabet.pos(text.charAt(i));
            nodes[idx] = add(nodes[idx], text.substring(i), i);
        }
    }

    private Node add(Node n, String str, int pos) {
        if (n == null)
            return new Node(str, pos, new Node[alphabet.size()]);

        int i = 0;
        while (n.atPos(i) == str.charAt(i)) i++;
        if (i == 0) return new Node(str, pos, new Node[alphabet.size()]);

        char c = str.charAt(i);
        if (c == END) return n;
        int idx = alphabet.pos(c);
        n.children[idx] = add(n.children[idx], str.substring(i), pos);

        return new Node(n.text.substring(0, i), n.pos, n.children);
    }

    public static SuffixTree build(String txt) {
        return new SuffixTree(txt);
    }

    static class Node {
        final String text;
        final int pos;
        final Node[] children;

        public Node(String txt, int pos, Node[] nodes) {
            this.text = txt;
            this.pos = pos;
            this.children = nodes;
        }

        public char atPos(int pos) {
            return pos < text.length() ? text.charAt(pos) : (char) -1;
        }
    }

    static class Alphabet {
        final int min, max;

        public Alphabet(String text) {
            int mn = 0, mx = 0;
            if (text != null && !text.isEmpty()) {
                mn = text.charAt(0);
                mx = mn;
                for (int i = 0; i < text.length(); i++) {
                    mn = Math.min(mn, text.charAt(i));
                    mx = Math.max(mx, text.charAt(i));
                }
            }
            min = mn;
            max = mx;
        }

        public int size() {
            return max - min + 1;
        }

        public int pos(char c) {
            return c - min;
        }
    }
}

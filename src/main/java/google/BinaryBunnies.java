package google;

/**
 * Created by Stas on 8/21/15.
 */
public class BinaryBunnies {
    public static String answer(int[] ints) {
        Node[] buff = new Node[ints.length];
        for (int each : ints) buff[0] = add(buff[0], each);
        return String.valueOf(find(buff, 0, 1));
    }

    private static int find(Node[] buff, int lo, int hi) {
        if (lo >= hi) return 1;
        int res = 0;
        for (int i = lo; i < hi; i++) {
            int h = hi;
            Node n = buff[i];
            if (n.l != null) buff[++h - 1] = n.l;
            if (n.r != null) buff[++h - 1] = n.r;
            swap(buff, lo, i);
            int r = find(buff, lo + 1, h);
            res += r;
            swap(buff, lo, i);
        }
        return res;
    }

    private static void swap(Node[] buff, int i, int j) {
        if (i==j) return;
        Node n = buff[i];
        buff[i] = buff[j];
        buff[j] = n;
    }

    private static Node add(Node n, int val) {
        if (n == null) return new Node(val);
        if (n.value <= val) n.r = add(n.r, val);
        if (n.value > val) n.l = add(n.l, val);
        return n;
    }

    static class Node {
        final int value;
        Node l, r;

        Node(int value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return value == node.value;
        }

        @Override
        public int hashCode() {
            return value;
        }
    }
}

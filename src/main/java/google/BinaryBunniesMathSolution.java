package google;

import java.math.BigInteger;

/**
 * Created by Stas on 8/21/15.
 */
public class BinaryBunniesMathSolution {
    public static String answer(int[] ints) {
        Node root = null;
        for (int each : ints) root = add(root, each);
        return String.valueOf(find(root));
    }

    private static BigInteger find(Node node) {
        if (node == null) return BigInteger.ONE;
        BigInteger l = find(node.l);
        BigInteger r = find(node.r);
        return choose(nodes(node.l) + nodes(node.r), nodes(node.r)).multiply(l).multiply(r);
    }

    static BigInteger choose(int n, int k) {
        if (n == k || k == 0) return BigInteger.ONE;
        if (k == 1) return BigInteger.valueOf(n);
        if (k > n) return BigInteger.ONE;
        k = Math.min(k, n - k);

        BigInteger res = BigInteger.ONE, d = BigInteger.valueOf(n - k);
        for (int i = k + 1; i <= n; i++) {
            res = res.multiply(BigInteger.valueOf(i));
            if (d.compareTo(BigInteger.ZERO) > 0 && res.mod(d).equals(BigInteger.ZERO)) {
                res = res.divide(d);
                d = d.subtract(BigInteger.ONE);
            }
        }

        while (d.compareTo(BigInteger.ZERO) > 0) {
            res = res.divide(d);
            d = d.subtract(BigInteger.ONE);
        }

        return res;
    }

    private static Node add(Node n, int val) {
        if (n == null) return new Node(val);
        if (n.value <= val) n.r = add(n.r, val);
        if (n.value > val) n.l = add(n.l, val);
        n.nodes = nodes(n.r) + nodes(n.l) + 1;
        return n;
    }

    private static int nodes(Node node) {
        return node == null ? 0 : node.nodes;
    }

    static class Node {
        final int value;
        Node l, r;
        int nodes = 1;

        Node(int value) {
            this.value = value;
        }
    }
}

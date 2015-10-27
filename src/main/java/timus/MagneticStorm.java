package timus;

import java.util.*;

/**
 * Created by Stas on 10/23/15.
 */
public class MagneticStorm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        List<Integer> in = new ArrayList<>();
        int n;
        while ((n = scanner.nextInt()) != -1) in.add(n);
        List<Integer> out = findMax(m, in);

        for (Integer each : out)
            System.out.println(each);
    }




    private static List<Integer> findMax(int window, List<Integer> in) {
        List<Integer> out = new ArrayList<>();
        PriorityQueue queue = new PriorityQueue(window);

        for (int i = 0; i < in.size(); i++) {
            Integer each = in.get(i);
            queue.add(each);
            if (i >= window - 1 || i == in.size() - 1)
                out.add(queue.peekMax());
        }
        return out;
    }

    static class PriorityQueue {
        private final Node[] data;
        private final ArrayDeque<Node> queue;

        private int size;

        public PriorityQueue(int window) {
            data = new Node[window + 1];
            queue = new ArrayDeque<>();
        }

        public void add(Integer each) {
            if (++size == data.length)
                shrink();

            Node n = new Node(each);
            queue.addFirst(n);

            n.pos = size;
            data[n.pos] = n;
            swim(n.pos);
        }

        private void swim(int k) {
            while (k > 1 && data[k/2].val < data[k].val) {
                swap(k / 2, k);
                k /= 2;
            }
        }

        private void swap(int i, int j) {
            Node node = data[i];
            node.pos = j;
            data[j].pos = i;
            data[i] = data[j];
            data[j] = node;
        }

        private void shrink() {
            int i = --size;
            Node last = queue.pollLast();
            Node min = data[i];
            min.pos = last.pos;
            data[i] = null;
            data[last.pos] = min;
            if (last.val > min.val)
                sink(last.pos);
            else
                swim(last.pos);

        }

        private void sink(int k) { // 0,1,2,3,4
            while (k * 2 < size) {
                int j = k * 2;
                if (j < size - 1 && data[j + 1].val > data[j].val)
                    j++;
                if (data[j].val <= data[k].val)
                    return;
                swap(k, j);
                k = j;
            }
        }

        public int peekMax() {
            if (data[1] != null)
                return data[1].val;
            return -1;
        }


        static class Node {
            final int val;
            int pos;

            public Node(int val) {
                this.val = val;
            }
        }
    }


}

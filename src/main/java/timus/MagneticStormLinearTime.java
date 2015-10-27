package timus;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Stas on 10/23/15.
 */
public class MagneticStormLinearTime {
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
        List<Integer> res = new ArrayList<>();
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < window; i++) {
            while (!queue.isEmpty() && in.get(i) >= in.get(queue.peekLast())) {
                queue.pollLast();
            }
            queue.addLast(i);
        }

        for (int i = window; i < in.size(); i++) {
            res.add(in.get(queue.peekFirst()));

            while (!queue.isEmpty() && queue.peekFirst() <= i - window)
                queue.pollFirst();

            while (!queue.isEmpty() && in.get(i) >= in.get(queue.peekLast()))
                queue.pollLast();

            queue.addLast(i);
        }

        res.add(in.get(queue.pollFirst()));

        return res;
    }

}

package cs101;

import java.util.*;

/**
 * Created by Stas on 10/20/15.
 */
public class Trams {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder res = new StringBuilder();

        int size = scanner.nextInt();
        Map<Integer, TreeSet<Integer>> map = new HashMap<>(size);

        int i = 1;
        while (size-- > 0) {
            Integer v = scanner.nextInt();
            TreeSet<Integer> integers = map.get(v);
            if (integers == null) {
                integers = new TreeSet<>();
                map.put(v, integers);
            }
            integers.add(i++);
        }

        size = scanner.nextInt();
        while (size-- > 0) {
            Integer lo = scanner.nextInt();
            Integer hi = scanner.nextInt();
            Integer val = scanner.nextInt();
            TreeSet<Integer> pos = map.get(val);
            if (pos == null) res.append("0");
            else if (pos.contains(lo) || pos.contains(hi)) res.append("1");
            else {
                Integer h = pos.higher(lo);
                if (h == null || h > hi) res.append("0");
                else res.append("1");
            }
        }

        System.out.println(res.toString());
    }
}

package timus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.util.stream.Collectors.toList;

/**
 * Created by Stas on 11/8/15.
 */
public class LastJacksWord {
    public static void main(String[] args) throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        String first = scanner.readLine();
        String last = scanner.readLine();

        List<String> prefixes = splitToPrefixes(first, last);
        if (prefixes.isEmpty())
            System.out.println("Yes");
        else {
            System.out.println("No");
            for (int i = prefixes.size() - 1; i >= 0; i--) {
                System.out.print(prefixes.get(i));
                if (i > 0) System.out.print(" ");
            }
        }
    }

    static List<String> splitToPrefixes(String first, String last) {
        if (first.charAt(0) != last.charAt(0)) return Collections.emptyList();

        StringBuilder str = new StringBuilder(first).append('$').append(last);

        int[] z = new int[str.length()];
        int l = 0, r = 0;
        for (int i = 1; i < str.length(); i++) {
            if (i <= r) z[i] = Math.min(r - i + 1, z[i - l]);
            while (z[i] + i < str.length() && str.charAt(i + z[i]) == str.charAt(z[i])) z[i]++;
            if (z[i] + i - 1 > r) {
                l = i;
                r = i + z[i] - 1;
            }
        }
        if (z[first.length() + 1] == 0)
            return Collections.emptyList();

        List<Pair> res = new ArrayList<>();
        int seek = str.length();
        for (int i = str.length() - 1; i >= first.length() + 1; i--) {
            if (z[i] + i >= seek) {
                res.add(new Pair(i, seek));
                seek = i;
            }
        }

        if (seek > first.length() + 1)
            return Collections.emptyList();

        return res.stream().map(pair -> str.substring(pair.lo, pair.hi)).collect(toList());
    }


    static class Pair implements Comparable<Pair> {
        final int lo;
        final int hi;

        Pair(int lo, int hi) {
            this.lo = lo;
            this.hi = hi;
        }

        @Override
        public int compareTo(Pair o) {
            if (this.hi != o.hi) return this.hi - o.hi;
            return this.lo - o.lo;
        }
    }
}

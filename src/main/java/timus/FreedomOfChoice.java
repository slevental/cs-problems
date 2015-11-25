package timus;

import java.io.*;
import java.util.Arrays;

/**
 * Created by Stas on 11/24/15.
 */
public class FreedomOfChoice {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(new BufferedOutputStream(System.out)));
        Integer len = Integer.parseInt(in.readLine().trim());
        char[] a = new char[len + 1];
        char[] b = new char[len + 1];
        in.read(a, 0, len);
        in.readLine();//new line
        in.read(b, 0, len);
        out.println(biggestCommonString(a, b));
        out.flush();
    }

    private static String biggestCommonString(char[] a, char[] b) {
        Prefix[] prefixes = new Prefix[a.length * 2];

        for (int i = a.length - 1; i >= 0; i--) {
            prefixes[2 * i] = new Prefix(a, i, a.length - 1, 1);
            prefixes[2 * i + 1] = new Prefix(b, i, b.length - 1, 2);
        }

        Arrays.sort(prefixes);

        Prefix longest = null;
        for (int i = prefixes.length - 1; i >= 1; i--) {
            Prefix x = prefixes[i];
            Prefix y = prefixes[i - 1];
            if (x.origin != y.origin) {
                if (longest != null && longest.len() >= Math.min(x.len(), y.len())) continue;

                Prefix lcp = x.lcp(y);
                if (longest == null || longest.len() < lcp.len())
                    longest = lcp;
            }
        }

        return longest == null ? "" : longest.toString();
    }

//    private static void sort(Prefix[] prefixes, int lo, int hi, int d) {
//        if (lo >= hi)
//            return;
//
//        int lt = lo, gt = hi;
//        Prefix lop = prefixes[lo];
//        char v = lop.str[d + lop.begin];
//        int i = lo + 1;
//
//        while (i <= gt) {
//            Prefix ip = prefixes[i];
//            char t = ip.str[d + ip.begin];
//            if (t < v) exch(prefixes, lt++, i++);
//            else if (t > v) exch(prefixes, i, gt--);
//            else i++;
//        }
//
//        sort(prefixes, lo, lt - 1, d);
//        if (v > 0) sort(prefixes, lt, gt, d + 1);
//        sort(prefixes, gt + 1, hi, d);
//    }

    private static void exch(Prefix[] prefixes, int i, int j) {
        Prefix p = prefixes[i];
        prefixes[i] = prefixes[j];
        prefixes[j] = p;
    }

    static class Prefix implements Comparable<Prefix> {
        final char[] str;
        final int begin;
        final int end;
        final int origin;

        Prefix(char[] str, int begin, int end, int origin) {
            this.str = str;
            this.begin = begin;
            this.end = end;
            this.origin = origin;
        }

        public Prefix lcp(Prefix that) {
            int i = this.begin, j = that.begin;
            while (i < this.str.length && j < that.str.length && this.str[i] == that.str[j] && this.str[i] != 0) {
                j++;
                i++;
            }
            return new Prefix(this.str, this.begin, i, this.origin);
        }

        public int len() {
            return end - begin;
        }

        @Override
        public String toString() {
            return new String(str, begin, len());
        }

        @Override
        public int compareTo(Prefix o) {
            int i = 0, n = Math.min(this.len(), o.len());
            while (i < n) {
                if (str[i + begin] != o.str[o.begin + i])
                    return str[i + begin] - o.str[o.begin + i];
                i++;
            }
            return this.len() - o.len();
        }
    }


}

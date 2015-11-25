package timus;

import java.io.*;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Random;

/**
 * Created by Stas on 11/24/15.
 */
public class FreedomOfChoiceHash {
    private final static long d = 26;
    private final static long q = BigInteger.probablePrime(50, new Random()).longValue();

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(new BufferedOutputStream(System.out)));
        Integer len = Integer.parseInt(in.readLine().trim());
        char[] a = new char[len];
        char[] b = new char[len];
        in.read(a, 0, len);
        in.readLine();//new line
        in.read(b, 0, len);
        out.println(biggestCommonString(a, b));
        out.flush();
    }

    private static String biggestCommonString(char[] a, char[] b) {
        int lo = 1, hi = a.length;
        int k;
        String result = "";
        while (lo <= hi) {
            k = (lo + hi) >>> 1;
            String lcs = lcs(a, b, k);
            if (lcs != null) {
                result = lcs;
                lo = k + 1;
            } else {
                hi = k - 1;
            }
        }
        return result;
    }

    private static String lcs(char[] a, char[] b, int k) {
        if (k == 0) return "";

        long qm = 1;
        for (int i = k - 1; i > 0; i--)
            qm = (qm * d) % q;

        long[] hash1 = hash(a, k, qm);
        HashMap<Long, Integer> idx = new HashMap<>(hash1.length);
        for (int i = 0; i < hash1.length; i++) idx.put(hash1[i], i);
        long[] hash2 = hash(b, k, qm);
        for (long hash : hash2) {
            if (idx.containsKey(hash))
                return new String(a, idx.get(hash), k);
        }
        return null;
    }

    private static long[] hash(char[] a, int k, long qm) {
        int len = a.length - k + 1;
        long[] hash = new long[len];
        for (int i = 0; i < k; i++)
            hash[0] = (hash[0] * d + a[i]) % q;

        for (int i = 1; i < len; i++) {
            hash[i] = ((hash[i - 1] - a[i - 1] * qm) * d + a[i + k - 1]) % q;
            if (hash[i] < 0) hash[i] += q;
        }

        return hash;
    }
}

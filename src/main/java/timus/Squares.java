package timus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by Stas on 12/2/15.
 */
public class Squares {
    private final static int d = 26;
    private final static int q = 10007;
    private final static long q1 = 999983;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = in.readLine().split("\\s+");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        char[][] chars = new char[n][m];
        for (int i = 0; i < n; i++) {
            in.read(chars[i]);
            in.readLine();
        }
        Coordinates c = lcs(chars);
        if (c == null)
            System.out.println(0);
        else {
            System.out.println(c.k);
            System.out.printf("%d %d\n", c.x0 + 1, c.y0 + 1);
            System.out.printf("%d %d\n", c.x1 + 1, c.y1 + 1);
        }
    }

    static Coordinates lcs(char[][] chars) {
        int lo = 1, hi = Math.min(chars.length, chars[0].length);
        int k;
        Coordinates result = null;
        while (lo <= hi) {
            k = (lo + hi) >>> 1;
            Coordinates lcs = lcs(chars, k);
            if (lcs != null) {
                result = lcs;
                result.k = k;
                lo = k + 1;
            } else {
                hi = k - 1;
            }
        }
        return result;
    }

    private static Coordinates lcs(char[][] sq, int k) {
        if (k == 0) return null;

        int qm = 1;
        for (int i = k - 1; i > 0; i--)
            qm = (qm * d) % q;

        int[][] preHash = preHash(sq, k, qm);
        return lcs(sq, preHash, k);
    }

    private static Coordinates lcs(char[][] sq, int[][] preHash, int k) {
        int n = sq.length;
        int m = sq[0].length;

        System.gc();

        LongLongMap tmp = new LongLongMap((int) ((n - k + 1) * (m - k + 1) * 1.2));

        long hash[][] = new long[n][m];

        long qm = 1;
        for (int i = k - 1; i > 0; i--)
            qm = (qm * q) % q1;

        for (int i = 0; i < n - k + 1; i++) {
            for (int j = 0; j < k; j++) {
                hash[i][0] = (hash[i][0] * q + preHash[i][j]) % q1;
            }

            if (hash[i][0] < 0) hash[i][0] += q1;
            Coordinates c = updateCoordinates(sq, tmp, i, 0, hash[i][0], k);
            if (c != null) return c;

            for (int j = 1; j < m - k + 1; j++) {
                hash[i][j] = ((hash[i][j - 1] - preHash[i][j - 1] * qm) * q + preHash[i][j + k - 1]) % q1;

                if (hash[i][j] < 0) hash[i][j] += q1;
                c = updateCoordinates(sq, tmp, i, j, hash[i][j], k);
                if (c != null) return c;
            }
        }
        return null;
    }

    private static Coordinates updateCoordinates(char[][] sq, LongLongMap tmp, int i, int j, long key, int k) {
        long c = tmp.get(key);
        if (c == -1) {
            tmp.put(key, i | j << 9);
            return null;
        }

        for (int l = 0; l < k; l++) {
            for (int m = 0; m < k; m++) {
                if (sq[(int) (0x1ff & c) + l][(int) (0x1ff & (c >> 9)) + m] != sq[i + l][j + m]) {
                    return null;
                }
            }
        }

        return new Coordinates((int) (0x1ff & c), (int) (0x1ff & (c >> 9)), i, j);
    }

    private static int[][] preHash(char[][] sq, int k, int qm) {
        int n = sq.length;
        int m = sq[0].length;
        int[][] hash = new int[n][m];
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < k; i++)
                hash[0][j] = (hash[0][j] * d + sq[i][j]) % q;
            if (hash[0][j] < 0) hash[0][j] += q;

            for (int i = 1; i < n - k + 1; i++) {
                hash[i][j] = ((hash[i - 1][j] - sq[i - 1][j] * qm) * d + sq[i + k - 1][j]) % q;
                if (hash[i][j] < 0) hash[i][j] += q;
            }
        }

        return hash;
    }

    static class Coordinates {
        int x0;
        int y0;
        int x1;
        int y1;
        int k;

        public Coordinates(int x0, int y0, int x1, int y1) {
            this.x0 = x0;
            this.y0 = y0;
            this.x1 = x1;
            this.y1 = y1;
        }
    }

    public static class LongLongMap {
        private final long keys[];
        private final int values[];
        private final int size;

        public LongLongMap(int capacity) {
            size = 1 << ((int) Math.ceil(Math.log(capacity) / Math.log(2)));
            this.keys = new long[size];
            this.values = new int[size];
            Arrays.fill(keys, -1);
        }

        public void put(long k, int v) {
            int b = Long.hashCode(k) & (size - 1);
            while (keys[b] != -1) b = (b + 1) & (size - 1);
            keys[b] = k;
            values[b] = v;
        }

        public int get(long k) {
            int b = Long.hashCode(k) & (size - 1);
            while (keys[b] != k) {
                if (keys[b] == -1)
                    return -1;
                b = (b + 1) & (size - 1);
            }
            return values[b];
        }
    }
}

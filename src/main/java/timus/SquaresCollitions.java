package timus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Stas on 12/2/15.
 */
public class SquaresCollitions {
    private final static long d = 26;
    private final static long q = 10007;
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
                lo = k + 1;
            } else {
                hi = k - 1;
            }
        }
        return result;
    }

    private static Coordinates lcs(char[][] sq, int k) {
        if (k == 0) return null;

        long qm = 1;
        for (int i = k - 1; i > 0; i--)
            qm = (qm * d) % q;

        long[][] preHash = preHash(sq, k, qm);
        return lcs(sq, preHash, k);
    }

    private static Coordinates lcs(char[][] sq, long[][] preHash, int k) {
        Map<Long, List<Coordinates>> tmp = new HashMap<>();

        int n = sq.length;
        int m = sq[0].length;

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

    private static Coordinates updateCoordinates(char[][] sq, Map<Long, List<Coordinates>> tmp, int i, int j, long key, int k) {
        List<Coordinates> lst = tmp.get(key);

        if (lst == null) {
            lst = new ArrayList<>(1);
            lst.add(new Coordinates(i, j));
            tmp.put(key, lst);
            return null;
        }

        next:
        for (Coordinates c : lst) {
            for (int l = 0; l < k; l++) {
                for (int m = 0; m < k; m++) {
                    if (sq[c.x0 + l][c.y0 + m] != sq[i + l][j + m]) {
                        continue next;
                    }
                }
            }

            c.x1 = i;
            c.y1 = j;
            c.k = k;
            return c;
        }

        lst.add(new Coordinates(i, j));
        return null;
    }

    private static long[][] preHash(char[][] sq, int k, long qm) {
        int n = sq.length;
        int m = sq[0].length;
        long[][] hash = new long[n][m];
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < k; i++)
                hash[0][j] = (hash[0][j] * d + sq[i][j]) % q;
            if (hash[0][j] < 0) hash[0][j] += q;

            for (int i = 1; i < n - k + 1; i++){
                hash[i][j] = ((hash[i - 1][j] - sq[i - 1][j] * qm) * d + sq[i + k - 1][j]) % q;
                if (hash[i][j] < 0) hash[i][j] += q;
            }
        }
        return hash;
    }

    static class Coordinates {
        int x0, y0, x1, y1, k;

        public Coordinates(int x0, int y0) {
            this.x0 = x0;
            this.y0 = y0;
        }
    }
}

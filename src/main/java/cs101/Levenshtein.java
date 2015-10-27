package cs101;

/**
 * Created by Stas on 10/20/15.
 */
public class Levenshtein {
    public static int distance(String a, String b) {
        if (a.equals(b)) return 0;
        if (a.isEmpty()) return b.length();
        if (b.isEmpty()) return a.length();

        int[][] m = new int[a.length()][b.length()];
        return find(a, b, a.length() - 1, b.length() - 1, m);
    }

    private static int find(String a, String b, int i, int j, int[][] m) {
        int distance = m[i][j];
        if (distance > 0)
            return distance;

        int curr = a.charAt(i) != b.charAt(j) ? 1 : 0;
        if (i == 0 && j == 0)
            return m[i][j] = curr;

        distance = Integer.MAX_VALUE;
        if (i > 0 && j > 0)
            distance = Math.min(distance, find(a, b, i - 1, j - 1, m));
        if (i > 0)
            distance = Math.min(distance, find(a, b, i - 1, j, m));
        if (j > 0)
            distance = Math.min(distance, find(a, b, i, j - 1, m));

        return m[i][j] = distance + curr;
    }
}

package google;

/**
 * Created by Stas on 8/17/15.
 */
public class MinionBoardGameDP {

    public static final int mod = 123454321;

    public static int answer(int t, int n) {
        int[][] ints = new int[t + 1][n];
        ints[1][0] = 1;
        ints[1][1] = 1;
        for (int i = 2; i < t + 1; i++) {
            for (int j = 0; j < n; j++) {
                ints[i][j] += ints[i - 1][j] % mod;
                if (j > 0) ints[i][j] += ints[i - 1][j - 1] % mod;
                if (j < n - 2) ints[i][j] += ints[i - 1][j + 1] % mod;
            }
        }
        return ints[t][n - 1] % mod;
    }


}

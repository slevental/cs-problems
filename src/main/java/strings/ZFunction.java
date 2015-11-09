package strings;

/**
 * Created by Stas on 11/8/15.
 */
public class ZFunction {
    public static int[] zetaFunction(String s) {
        int[] z = new int[s.length()];
        z[0] = s.length();
        for (int i = 1, l = 0, r = 0; i < z.length; i++) {
            if (i > r) {
                int j = 0;
                while (j + i < z.length && s.charAt(i + j) == s.charAt(j++)) z[i]++;
                if (z[i] > 0) {
                    r = i + z[i] - 1;
                    l = i;
                }
            } else {
                z[i] = Math.min(z[i - l], r - i + 1);
            }
        }
        return z;
    }
}

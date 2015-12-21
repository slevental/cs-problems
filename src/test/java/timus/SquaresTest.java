package timus;

import org.junit.Test;

import java.util.Random;

/**
 * Created by Stas on 12/7/15.
 */
public class SquaresTest {
    @Test
    public void test_random_sq() throws Exception {
        Random random = new Random();
        int n = 10;//random.nextInt(5) + 1;
        int m = 10;//random.nextInt(5) + 1;
        char[][] chars = new char[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char c = (char) (random.nextInt(2   ) + 'x');
                chars[i][j] = c;
            }
        }

        Squares.Coordinates c = Squares.lcs(chars);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (c==null){
                    System.out.print(chars[i][j]);
                    continue;
                }

                boolean first = i >= c.x0 && i < c.x0 + c.k && j >= c.y0 && j < c.y0 + c.k;
                boolean second = i >= c.x1 && i < c.x1 + c.k && j >= c.y1 && j < c.y1 + c.k;
                System.out.print(chars[i][j]);
//                if (!first && !second) {
//                } else {
//                    System.out.print(Character.toUpperCase(chars[i][j]));
//                }
            }
            System.out.println();
        }

        if (c != null) {
            System.out.println(c.k);
            System.out.printf("%d %d\n", c.x0 + 1, c.y0 + 1);
            System.out.printf("%d %d\n", c.x1 + 1, c.y1 + 1);
        }
    }
}
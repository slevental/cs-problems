package cci;

/**
 * Created by Stas on 11/3/15.
 */
public class RotateMatrix {
    public static int[][] rotate(int[][] matrix) {
        int n = matrix.length;
        int max = n / 2 + n % 2;
        for (int i = 0; i < max; i++)
            for (int j = 0; j < max; j++) rotate(matrix, i, j, max);
        return matrix;
    }

    private static void rotate(int[][] matrix, int i, int j, int max) {
        int buf = matrix[i][j];
    }

}

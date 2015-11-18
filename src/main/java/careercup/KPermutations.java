package careercup;

/**
 * Created by Stas on 11/14/15.
 */
public class KPermutations {
    public static void printPermutations(int[] set, int r) {
        printPermutations(set, set.length, r);
    }

    private static void printPermutations(int[] set, int n, int r) {
        if (r == 0) {
            for (int i = n; i < set.length; i++) {
                System.out.print(set[i]);
                if (i < set.length - 1) System.out.print(", ");
            }
            System.out.println();
        } else
            for (int j = 0; j < n; j++) {
                swap(set, j, set.length - 1);
                printPermutations(set, n - 1, r - 1);
                swap(set, j, set.length - 1);
            }
    }

    public static void swap(int[] set, int i, int j) {
        int b = set[i];
        set[i] = set[j];
        set[j] = b;
    }

    public static void main(String[] args) {
        printPermutations(new int[]{2, 3, 4}, 2);
    }
}

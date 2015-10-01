package graph;

import java.util.BitSet;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Stas on 10/1/15.
 */
public class EvenTree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int vertices = scanner.nextInt();
        int edges = scanner.nextInt();
        scanner.nextLine();
        int[][] arr = new int[vertices + 1][vertices + 1];
        for (int i = 0; i < edges; i++) {
            int to = scanner.nextInt();
            int from = scanner.nextInt();
            arr[from][to] = 1;
        }
        int res = evenTree(arr);
        System.out.println(res);
    }

    static int evenTree(int[][] arr) {
        int[] size = new int[arr.length];
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        BitSet visited = new BitSet();
        stack.push(1);
        loop:
        while (!stack.isEmpty()) {
            Integer pop = stack.peek();
            visited.set(pop);
            for (int i = 0; i < arr[pop].length; i++) {
                if (arr[pop][i] == 1 && !visited.get(i)) {
                    stack.push(i);
                    continue loop;
                }
            }
            pop = stack.pop();
            size[pop]++;
            for (int i = 0; i < arr[pop].length; i++) {
                if (arr[pop][i] == 1) size[pop] = size[pop] + size[i];
            }
            if (size[pop] % 2 == 0 && !stack.isEmpty()) {
                size[pop] = 0;
                res++;
            }
        }
        return res;
    }

}

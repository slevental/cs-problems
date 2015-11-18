package careercup;

import java.util.Objects;
import java.util.PriorityQueue;

/**
 * Created by Stas on 11/14/15.
 */
public class PrimeExpressible {
    public static long getN(int[] primes, int n) {
        PriorityQueue<Long> queue = new PriorityQueue<>();
        queue.add(1L);
        Long e = -1L;
        while (n-- > 0) {
            e = queue.poll();
            while (Objects.equals(e, queue.peek())) queue.poll();
            for (int prime : primes) {
                queue.add(prime * e);
            }
        }
        return e;
    }
}

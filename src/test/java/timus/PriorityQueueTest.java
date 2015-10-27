package timus;

import com.sun.jmx.remote.internal.ArrayQueue;
import org.junit.Test;

import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

import static org.junit.Assert.*;

/**
 * Created by Stas on 10/23/15.
 */
public class PriorityQueueTest {

    @Test
    public void test_queue() throws Exception {
        MagneticStorm.PriorityQueue queue = new MagneticStorm.PriorityQueue(3);
        queue.add(3);
        queue.add(2);
        queue.add(1);
        assertEquals(3, queue.peekMax());
        queue.add(1);
        assertEquals(2, queue.peekMax());
        queue.add(1);
        assertEquals(1, queue.peekMax());
    }

    @Test
    public void test_queue2() throws Exception {
        MagneticStorm.PriorityQueue queue = new MagneticStorm.PriorityQueue(3);
        queue.add(10);
        queue.add(11);
        queue.add(10);
        assertEquals(11, queue.peekMax());
        queue.add(0);
        assertEquals(11, queue.peekMax());
        queue.add(0);
        assertEquals(10, queue.peekMax());
        queue.add(0);
        assertEquals(0, queue.peekMax());
        queue.add(1);
        assertEquals(1, queue.peekMax());
        queue.add(2);
        assertEquals(2, queue.peekMax());
        queue.add(3);
        assertEquals(3, queue.peekMax());
        queue.add(2);
        assertEquals(3, queue.peekMax());
    }

    @Test
    public void test_queue3() throws Exception {
        MagneticStorm.PriorityQueue queue = new MagneticStorm.PriorityQueue(2);
        queue.add(7);
        queue.add(6);
        assertEquals(7, queue.peekMax());
        queue.add(5);
        assertEquals(6, queue.peekMax());
        queue.add(8);
        assertEquals(8, queue.peekMax());
        queue.add(7);
        assertEquals(8, queue.peekMax());
        queue.add(6);
        assertEquals(7, queue.peekMax());
        queue.add(7);
        assertEquals(7, queue.peekMax());
        queue.add(6);
        assertEquals(7, queue.peekMax());
        queue.add(5);
        assertEquals(6, queue.peekMax());
        queue.add(2);
        assertEquals(5, queue.peekMax());
        queue.add(1);
        assertEquals(2, queue.peekMax());
        queue.add(7);
        assertEquals(7, queue.peekMax());
        queue.add(1);
        assertEquals(7, queue.peekMax());
    }

    @Test
    public void test_random() throws Exception {
        Random random = new Random(13);
        int window = 1200;
        MagneticStorm.PriorityQueue queue2 = new MagneticStorm.PriorityQueue(window);
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(window);

        for (int i = 0; i < 100000; i++) {
            int element = Math.abs(random.nextInt());
            while (!queue.offer(element)) queue.poll();

            queue2.add(element);

            int max = 0;
            for (Integer integer : queue) {
                max = Math.max(max , integer);
            }

            if (queue2.peekMax() != max )
                System.out.println();

            assertEquals(max, queue2.peekMax());
        }

    }
}
package org.andy.study.algorythms.lafore.chapter4;

import java.util.Arrays;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author andy
 */
public class PriorityQueueTest {

    @Test
    public void testQueue() {
        testQueueData();
        testQueueData(1);
        testQueueData(1, 3, 5);
        testQueueData(5, 3, 1);
        testQueueData(9, 2, 7, 4, 1, 8, 5, 9, 3);
        testQueueData(1, 2, 5, 4, 1, 4, 3, 9, 8);
    }

    @Test
    public void testCyclicSuccess() throws IllegalStateException {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        assertTrue(queue.isEmpty());
        for (int i = 15; i >= 0; i--) {
            queue.insert(i);
            if (i < 7) {
                queue.remove();
            }
            assertFalse(queue.isEmpty());
        }
    }

    private void testQueueData(int... data) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int e : data) {
            queue.insert(e);
            assertFalse(queue.isEmpty());
        }
        
        Arrays.sort(data);
        for (int e : data) {
            assertEquals(e, (int) queue.peek());
            assertEquals(e, (int) queue.remove());
        }
        assertTrue(queue.isEmpty());
    }
}

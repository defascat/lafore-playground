/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.andy.study.algorythms.lafore.chapter4;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author andy
 */
public class QueueTest {

    @Test
    public void testQueue() {
        testQueueData("[]");
        testQueueData("[1]",1);
        testQueueData("[1,3,5]",1, 3, 5);
    }

    @Test
    public void testCyclicSuccess() throws IllegalStateException {
        Queue<Integer> queue = createIntQueue();
        assertTrue(queue.isEmpty());
        for (int i = 1; i <= 15; i++) {
            queue.insert(i);
            if (i > 9) {
                queue.remove();
            }
            assertFalse(queue.isEmpty());
        }
        assertEquals("[7,8,9,10,11,12,13,14,15]", queue.print());
    }

    @Test
    public void testCyclicFailure() {
        Queue<Integer> queue = createIntQueue();
        assertTrue(queue.isEmpty());
        try {
            for (int i = 1; i <= 15; i++) {
                queue.insert(i);
                if (i > 9 && i < 12) {
                    queue.remove();
                }
                assertFalse(queue.isEmpty());
            }
            fail();
        } catch (IllegalStateException e) {

        }
    }

    private void testQueueData(String print, int... data) {
        Queue<Integer> queue = createIntQueue();
        for (int e : data) {
            queue.insert(e);
            assertFalse(queue.isEmpty());
        }
        
        assertEquals(print, queue.print());
        
        for (int e : data) {
            assertEquals(e, (int) queue.peek());
            assertEquals(e, (int) queue.remove());
        }
        assertTrue(queue.isEmpty());
    }

    protected Queue<Integer> createIntQueue() {
        return new Queue<>();
    }
}

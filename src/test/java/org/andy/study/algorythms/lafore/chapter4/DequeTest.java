package org.andy.study.algorythms.lafore.chapter4;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author andy
 */
public class DequeTest {

    @Test
    public void testQueue() {
        testQueueData("[]");
        testQueueData("[1]",1);
        testQueueData("[1,3,5]",1, 3, 5);
    }

    @Test
    public void testCyclicSuccess() throws IllegalStateException {
        Deque<Integer> queue = new Deque<>();
        assertTrue(queue.isEmpty());
        for (int i = 1; i <= 15; i++) {
            queue.insertRight(i);
            if (i > 9) {
                queue.removeLeft();
            }
            assertFalse(queue.isEmpty());
        }
        assertEquals("[7,8,9,10,11,12,13,14,15]", queue.print());
    }
    
    @Test
    public void testDequeRandom() throws IllegalStateException {
        Deque<Integer> queue = new Deque<>();
        assertTrue(queue.isEmpty());
        queue.insertLeft(1); assertEquals("[1]", queue.print());
        queue.insertRight(2); assertEquals("[1,2]", queue.print());
        queue.insertLeft(3); assertEquals("[3,1,2]", queue.print());
        assertEquals(2, (int) queue.peekRight()); 
        assertEquals(2, (int)queue.removeRight()); assertEquals("[3,1]", queue.print());
        queue.insertRight(4); assertEquals("[3,1,4]", queue.print());
        assertEquals(3, (int)queue.removeLeft()); assertEquals("[1,4]", queue.print());
        assertEquals(1, (int)queue.removeLeft()); assertEquals("[4]", queue.print());
        assertEquals(4, (int)queue.removeRight()); assertEquals("[]", queue.print());
        assertTrue(queue.isEmpty());        
    }

    @Test
    public void testCyclicFailure() {
        Deque<Integer> queue = new Deque<>();
        assertTrue(queue.isEmpty());
        try {
            for (int i = 1; i <= 15; i++) {
                queue.insertRight(i);
                if (i > 9 && i < 12) {
                    queue.removeLeft();
                }
                assertFalse(queue.isEmpty());
            }
            fail();
        } catch (IllegalStateException e) {

        }
    }

    private void testQueueData(String print, int... data) {
        testDeque(data, print, 
                (queue, val) -> {queue.insertRight(val);},
                (queue) -> {return queue.removeLeft();},
                (queue) -> {return queue.peekLeft();},
                (queue) -> {return queue.print();}
        );
        
        testDeque(data, print, 
                (queue, val) -> {queue.insertLeft(val);},
                (queue) -> {return queue.removeRight();},
                (queue) -> {return queue.peekRight();},
                (queue) -> {return queue.printReverse();}
        );
        
    }

    private void testDeque(int[] data, String print, 
            BiConsumer<Deque<Integer>, Integer> insertMethod,
            Function<Deque<Integer>, Integer> removeMethod,
            Function<Deque<Integer>, Integer> peekMethod,
            Function<Deque<Integer>, String> printMethod
            ) throws IllegalStateException {
        Deque<Integer> queue = new Deque<>();
        for (int e : data) {
            insertMethod.accept(queue, e);
            assertFalse(queue.isEmpty());
        }
        
        assertEquals(print, printMethod.apply(queue));
        
        for (int e : data) {
            assertEquals(e, (int) peekMethod.apply(queue));
            assertEquals(e, (int) removeMethod.apply(queue));
        }
        assertTrue(queue.isEmpty());
    }
}

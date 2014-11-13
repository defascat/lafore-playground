package org.andy.study.algorythms.lafore.chapter4;

/**
 *
 * @author andy
 */
public class FastInsertPriorityQueueTest extends PriorityQueueTest {

    @Override
    protected Queue<Integer> createQueue() {
        return new FastInsertPriorityQueue<>();
    }
    
}

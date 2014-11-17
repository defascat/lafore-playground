package org.andy.study.algorythms.lafore.chapter5;

import org.andy.study.algorythms.lafore.chapter4.Queue;
import org.andy.study.algorythms.lafore.chapter4.QueueTest;
import org.junit.Ignore;

/**
 *
 * @author andy
 */
public class LinkQueueTest extends QueueTest {

    @Override
    protected Queue<Integer> createIntQueue() {
        return new LinkQueue<>();
    }

    @Ignore
    @Override
    public void testCyclicFailure() {
    }
}

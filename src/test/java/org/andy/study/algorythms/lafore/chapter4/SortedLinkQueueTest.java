package org.andy.study.algorythms.lafore.chapter4;

import org.andy.study.algorythms.lafore.chapter5.SortedLinkList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author andy
 */
public class SortedLinkQueueTest {
    
    @Test
    public void testQueue() {
        testData("[]");
        testData("[1]", 1);
        testData("[1,2,3]", 3, 2, 1);
        testData("[1,2,3]", 1, 2, 3);
        testData("[1,1,2,3,4,5,6,7,8,9,9]", 7, 9, 2, 1, 4, 8, 3, 9, 1, 5, 6);
    }

    private void testData(String expectedResult, int... data) {
        SortedLinkList<Integer> queue = new SortedLinkList<Integer>();
        for (int e : data) {
            queue.insert(e);
        }
        assertEquals(expectedResult, queue.print());
    }
}

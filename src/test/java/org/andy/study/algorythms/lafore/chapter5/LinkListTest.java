package org.andy.study.algorythms.lafore.chapter5;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author andy
 */
public class LinkListTest {

    @Test
    public void testLinkedList() {
        testList(1, 2, 3, 4, 5, 6);
    }

    private void testList(int... data) {
        LinkList<Integer> list = new LinkList<>();
        Assert.assertTrue(list.isEmpty());
        for(int i = data.length - 1; i >= 0; i--) {
            list.insertFirst(data[i]);
            Assert.assertFalse(list.isEmpty());
        }
        
        for(int i = 0; i < data.length; i++) {
            Assert.assertEquals(i, list.indexOf(data[i]));
        }
        Assert.assertEquals(-1, list.indexOf(-2));
        
        for(int i = 0; i < data.length / 2; i++) {
            final int itemToRemove = data[i * 2];
            list.remove(itemToRemove);
            Assert.assertEquals(-1, list.indexOf(itemToRemove));
        }
        
        for(int i = 0; i < data.length / 2; i++) {
            if(i * 2 + 1 > data.length - 1) continue;
            final int itemToRemove = data[i * 2 + 1];
            list.remove(itemToRemove);
            Assert.assertEquals(-1, list.indexOf(itemToRemove));
        }
        Assert.assertTrue(list.isEmpty());
    }
}

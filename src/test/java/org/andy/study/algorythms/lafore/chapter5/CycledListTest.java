package org.andy.study.algorythms.lafore.chapter5;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author andy
 */
public class CycledListTest {
    @Test(timeout = 1000000)
    public void testQueue() {
        final CycledList<Integer> list = new CycledList<Integer>();
        Assert.assertFalse(list.contains(1));
        Assert.assertFalse(list.delete(1));
        
        list.add(1);
        Assert.assertTrue(list.contains(1));
        Assert.assertFalse(list.contains(2));
        
        list.add(2);
        Assert.assertTrue(list.contains(1));
        Assert.assertTrue(list.contains(2));
        
        list.add(3);
        Assert.assertTrue(list.contains(1));
        Assert.assertTrue(list.contains(2));
        Assert.assertTrue(list.contains(3));
        Assert.assertFalse(list.contains(4));
        
        list.add(4);
        Assert.assertTrue(list.contains(4));
        
        Assert.assertTrue(list.delete(1));
        Assert.assertTrue(list.contains(2));
        Assert.assertTrue(list.contains(3));
        Assert.assertTrue(list.contains(4));
        Assert.assertFalse(list.contains(1));
        
        Assert.assertFalse(list.delete(5));
        Assert.assertTrue(list.contains(2));
        Assert.assertTrue(list.contains(3));
        Assert.assertTrue(list.contains(4));
        Assert.assertFalse(list.contains(1));
        
        Assert.assertTrue(list.delete(4));
        Assert.assertTrue(list.contains(2));
        Assert.assertTrue(list.contains(3));
        Assert.assertFalse(list.contains(4));

        list.add(5);
        Assert.assertTrue(list.contains(2));
        Assert.assertTrue(list.contains(3));
        Assert.assertTrue(list.contains(5));
        
        Assert.assertTrue(list.delete(3));
        Assert.assertTrue(list.contains(2));
        Assert.assertFalse(list.contains(3));
        Assert.assertTrue(list.contains(5));
        
        Assert.assertTrue(list.delete(2));
        Assert.assertFalse(list.contains(2));
        Assert.assertTrue(list.contains(5));
        
        Assert.assertTrue(list.delete(5));
        Assert.assertFalse(list.contains(5));
        
        Assert.assertTrue(list.isEmpty());
    }
}

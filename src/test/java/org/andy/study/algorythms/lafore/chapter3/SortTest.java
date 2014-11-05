package org.andy.study.algorythms.lafore.chapter3;

import java.util.Arrays;
import java.util.Random;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author andy
 */
public class SortTest {
    
    @Test(timeout=100000)
    public void bubbleSort() {
        sort(new BubbleSort(), false);
        sort(new BubbleSort(), true);
    }

    @Test(timeout=100000)
    public void bubbleSortEx1() {
        sort(new BubbleSortEx1(), false);
    }

    @Test(timeout=1000000)
    public void oddEvenSort() {
        sort(new OddEvenSort(), false);
    }
    
    @Test(timeout=100000)
    public void selectSort() {
        sort(new SelectionSort(), false);
        sort(new SelectionSort(), true);
    }

    @Test(timeout=1000000)
    public void insertSort() {
        sort(new InsertionSort(), false);
        sort(new InsertionSort(), true);
        Assert.assertArrayEquals(new int[]{}, new InsertionSort().dedup(new int[]{}));
        Assert.assertArrayEquals(new int[]{1, 2, 3, 4, 5}, new InsertionSort().dedup(new int[]{1, 2, 3, 4, 5}));
        Assert.assertArrayEquals(new int[]{1, 2, 4}, new InsertionSort().dedup(new int[]{1, 2, 2, 4, 4}));
        Assert.assertArrayEquals(new int[]{1}, new InsertionSort().dedup(new int[]{1, 1, 1, 1, 1}));
        
        for(int i = 1; i < 5; i++)
            verifySort(new InsertionSort(), false, new Random().ints((long) (1000 * Math.pow(2, i))).toArray());
    }

    private void sort(Sort algorythm, boolean reverse) {
        verifySort(algorythm, reverse);
        verifySort(algorythm, reverse, 1);
        verifySort(algorythm, reverse, 1, 2, 3, 4);

        verifySort(algorythm, reverse, 4, 2, 2, 1);
        verifySort(algorythm, reverse, 4, 2, 3, 1, 5);
        
        verifySort(algorythm, reverse, new Random().ints(10000).toArray());
    }

    private void verifySort(Sort algorythm, boolean reverse, int... ints) {
        int[] sorted = algorythm.sort(ints, reverse);
        Arrays.sort(ints);
        if(reverse)  {
            for(int i = 0; i < ints.length / 2; i++) {
                int tmp = ints[i];
                ints[i] = ints[ints.length - 1 - i];
                ints[ints.length - 1 - i] = tmp;
            }
        }
        Assert.assertArrayEquals(ints, sorted);
    }
}

package org.andy.study.algorythms.lafore.chapter3;

/**
 *
 * @author andy
 */
public class InsertionSort extends Sort {

    @Override
    protected int[] sortInternal(int[] array) {
        return sortData(array, (arrayData, j, j1) -> {return arrayData[j] > j1;});
    }

    @Override
    protected int[] sortInternalReverse(int[] array) {
        return sortData(array, (arrayData, j, j1) -> {return arrayData[j] < j1;});
    }
    
    private int[] sortData(int[] array, Compare compare) {
        for(int i = 1; i < array.length; i++) {
            int next = array[i];
            int j = i;
            while(j > 0 && compare.compare(array, j - 1, next)) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = next;
        }
        return array;
    }
}

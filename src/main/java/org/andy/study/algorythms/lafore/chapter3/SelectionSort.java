package org.andy.study.algorythms.lafore.chapter3;

/**
 *
 * @author andy
 */
public class SelectionSort extends Sort {

    @Override
    protected int[] sortInternal(int[] array) {
        return sortData(array, (arrayData, j, j1) -> {return array[j] < array[j1];});
    }
    
    @Override
    protected int[] sortInternalReverse(int[] array) {
        return sortData(array, (arrayData, j, j1) -> {return arrayData[j] > arrayData[j1];});
    }

    private int[] sortData(int[] array, Compare compare) {
        for(int i = 0; i < array.length; i++) {
            int minPosition = i;
                    
            for(int j = i; j < array.length; j++) {
                if(compare.compare(array, j, minPosition)) {
                    minPosition = j;
                }
            }
            
            if(i != minPosition) {
                swap(array, i, minPosition);
            }
        }
        return array;
    }
    
}

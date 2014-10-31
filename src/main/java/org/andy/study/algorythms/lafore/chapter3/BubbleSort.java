package org.andy.study.algorythms.lafore.chapter3;

/**
 *
 * @author andy
 */
public class BubbleSort extends Sort {

    @Override
    protected int[] sortInternal(int[] array) {
        return sortData(array, (arrayData, j, j1) -> {return arrayData[j] > arrayData[j1];});
    }

    @Override
    protected int[] sortInternalReverse(int[] array) {
        return sortData(array, (arrayData, j, j1) -> {return arrayData[j] < arrayData[j1];});
        
    }

    private int[] sortData(int[] array, Compare func) {
        for(int i = 0; i < array.length - 1; i++) {
            for(int j = 0; j < array.length - i - 1; j++) {
                if(func.compare(array, j, j+1)) {
                    swap(array, j, j + 1);
                }
            }
        }
        return array;
    }    
}

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
    
    public int[] dedup(int[] array) {
        int[] newArray = new int[array.length];
        System.arraycopy(array, 0, newArray, 0, array.length);
        for (int i = 0; i <= newArray.length - 2; i++) {
            if(newArray[i] == newArray[i + 1]) {
                newArray[i] = -1;
            }
        }
        
        int nextPos = 0;
        for (int j = 0; j < newArray.length; j++) {
            if(newArray[j] != -1) {
                swap(newArray, j, nextPos++);
            }
        }
        
        int length = 0;
        for (int i = newArray.length - 1; i >= 0; i--) {
            if(newArray[i] != -1) {
                length = i + 1;
                break;
            }
        }
        
        int[] resultArray = new int[length];
        System.arraycopy(newArray, 0, resultArray, 0, length);
        return resultArray;
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

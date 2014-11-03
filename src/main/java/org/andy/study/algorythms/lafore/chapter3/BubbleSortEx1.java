package org.andy.study.algorythms.lafore.chapter3;

/**
 *
 * @author andy
 */
public class BubbleSortEx1 extends Sort {

    @Override
    protected int[] sortInternal(int[] array) {
        for(int i = 0; i < (array.length - 1) / 2; i++) {
            for(int j = 0; j < array.length - i - 1; j++) {
                if(array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
            for(int j = array.length - i - 1; j > 0; j--) {
                if(array[j] < array[j - 1]) {
                    swap(array, j, j - 1);
                }
            }
        }
        return array;
    }
}

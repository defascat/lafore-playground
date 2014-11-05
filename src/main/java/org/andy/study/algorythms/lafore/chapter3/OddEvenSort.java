package org.andy.study.algorythms.lafore.chapter3;

/**
 *
 * @author andy
 */
public class OddEvenSort extends Sort {

    @Override
    protected int[] sortInternal(int[] array) {
        boolean sorted = false;
        while(!sorted) {
            sorted = true;
            for(int j = 0; j < array.length - 1; j+=2) {
                if(array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                    sorted = false;
                }
            }
            for(int j = 1; j < array.length - 1; j+=2) {
                if(array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                    sorted = false;
                }
            }
        }
        return array;
    }
}

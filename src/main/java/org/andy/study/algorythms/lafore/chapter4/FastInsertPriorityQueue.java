package org.andy.study.algorythms.lafore.chapter4;

/**
 *
 * @author andy
 */
public class FastInsertPriorityQueue<T extends Number> extends Queue<T> {
    @Override
    public T peek() throws IllegalStateException {
        verifyNonEmpty();
        return (T) array[getMinIndex()];
    }

    @Override
    public T remove() throws IllegalStateException {
        verifyNonEmpty();
        
        int minIndex = getMinIndex();
        T curValue = (T) array[minIndex];
        for(int i = minIndex; i < end + (start > end ? array.length : 0) - 1; i++) {
            array[adjustToSize(i)] = array[adjustToSize(i + 1)];
        }
        end = adjustToSize(end - 1);
        dataCounter--;
        return curValue;
    }


    private int getMinIndex() {
        Long min = new Long(Long.MAX_VALUE);
        int index = -1;
        for(int i = start; i < end + (start > end ? array.length : 0); i++) {
            final Long curValue = ((T) array[adjustToSize(i)]).longValue();
            if(Long.compare(curValue, min) < 0) {
                index = i;
                min = curValue;
            }
        }
        return adjustToSize(index);
    }
    
}

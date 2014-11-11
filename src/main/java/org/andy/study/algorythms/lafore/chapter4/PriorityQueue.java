package org.andy.study.algorythms.lafore.chapter4;

/**
 *
 * @author andy
 */
public class PriorityQueue<T extends Number> extends Queue<T> {
    @Override
    public void insert(T data) throws IllegalStateException {
        if(end == start && dataCounter > 0) {
            throw new IllegalStateException();
        }        
        
        /* array[end] = data; */
        int rightBorder = (start < end || dataCounter == 0) ? end : end + array.length;
        int i = start;
        while(i < rightBorder) {
            if(((T)array[adjustToSize(i)]).longValue() >= data.longValue()) {
                break;
            }
            i++;
        }
        int k = rightBorder;
        while(k > i) {
            array[adjustToSize(k)] = array[adjustToSize(k - 1)];
            k--;
        }
        array[i] = data;
        end = adjustToSize(end + 1);
        dataCounter++;
    }

}

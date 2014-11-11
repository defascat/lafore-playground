package org.andy.study.algorythms.lafore.chapter4;

/**
 *
 * @author andy
 */
public class Queue<T> {
    protected Object[] array = new Object[10];
    protected int start;
    protected int end;
    protected int dataCounter;
    
    public void insert(T data) throws IllegalStateException {
        if(end == start && dataCounter > 0) {
            throw new IllegalStateException();
        }
        array[end] = data;
        end = adjustToSize(end + 1);
        dataCounter++;
    }
    
    public T remove() throws IllegalStateException {
        if(start == end  && dataCounter == 0) {
            throw new IllegalStateException();
        }
        T curValue = (T) array[start];
        array[start] = -1;
        start = adjustToSize(start + 1);
        dataCounter--;
        return curValue;
    }
    
    public T peek() throws IllegalStateException {
        if(start == end && dataCounter == 0) {
            throw new IllegalStateException();
        }
        return (T) array[start];
    }
    
    public boolean isEmpty() {
        return start == end && dataCounter == 0;
    }

    protected int adjustToSize(int i) {
        return i % array.length;
    }
}

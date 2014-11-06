package org.andy.study.algorythms.lafore.chapter4;

/**
 *
 * @author andy
 */
public class Queue<T> {
    private Object[] array = new Object[10];
    private int start;
    private int end;
    private int dataCounter;
    
    public void insert(T data) throws IllegalStateException {
        if(end == start && dataCounter > 0) {
            throw new IllegalStateException();
        }
        array[end] = data;
        end = (end + 1) % array.length;
        dataCounter++;
    }
    
    public T remove() throws IllegalStateException {
        if(start == end  && dataCounter == 0) {
            throw new IllegalStateException();
        }
        T curValue = (T) array[start];
        start = (start + 1) % array.length;
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
}

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
        verifyNotFull();
        array[end] = data;
        end = adjustToSize(end + 1);
        dataCounter++;
    }
    
    public T remove() throws IllegalStateException {
        verifyNonEmpty();
        
        T curValue = (T) array[start];
        array[start] = -1;
        start = adjustToSize(start + 1);
        dataCounter--;
        return curValue;
    }
    
    public T peek() throws IllegalStateException {
        verifyNonEmpty();
        return (T) array[start];
    }
    
    public boolean isEmpty() {
        return start == end && dataCounter == 0;
    }

    protected int adjustToSize(int i) {
        return (i + array.length) % array.length;
    }
    
    public String print() {
        String result = "";
        for(int i = start; i < end + (start > end ? array.length : 0); i++) {
            if(!result.isEmpty()) {
                result += ",";
            }
            result += array[adjustToSize(i)];
        }
        return "[" + result + "]";
    } 

    protected void verifyNonEmpty() throws IllegalStateException {
        if (start == end && dataCounter == 0) {
            throw new IllegalStateException();
        }
    }

    protected void verifyNotFull() throws IllegalStateException {
        if (end == start && dataCounter > 0) {
            throw new IllegalStateException();
        }
    }
}

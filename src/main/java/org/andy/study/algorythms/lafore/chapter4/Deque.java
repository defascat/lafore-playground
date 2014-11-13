package org.andy.study.algorythms.lafore.chapter4;

/**
 *
 * @author andy
 */
public class Deque<T> {
    protected Object[] array = new Object[10];
    protected int start;
    protected int end;
    protected int dataCounter;
    
    public void insertRight(T data) throws IllegalStateException {
        if(end == start && dataCounter > 0) {
            throw new IllegalStateException();
        }
        array[end] = data;
        end = adjustToSize(end + 1);
        dataCounter++;
    }
    
    public T removeLeft() throws IllegalStateException {
        if(start == end  && dataCounter == 0) {
            throw new IllegalStateException();
        }
        T curValue = (T) array[start];
        array[start] = -1;
        start = adjustToSize(start + 1);
        dataCounter--;
        return curValue;
    }

    public void insertLeft(T data) throws IllegalStateException {
        if(end == start && dataCounter > 0) {
            throw new IllegalStateException();
        }
        start = adjustToSize(start - 1);
        array[start] = data;
        dataCounter++;
    }
    
    public T removeRight() throws IllegalStateException {
        if(start == end  && dataCounter == 0) {
            throw new IllegalStateException();
        }
        end = adjustToSize(end - 1);
        T curValue = (T) array[end];
        array[end] = -1;
        dataCounter--;
        return curValue;
    }

    public T peekLeft() throws IllegalStateException {
        if(start == end && dataCounter == 0) {
            throw new IllegalStateException();
        }
        return (T) array[start];
    }

    public T peekRight() throws IllegalStateException {
        if(start == end && dataCounter == 0) {
            throw new IllegalStateException();
        }
        return (T) array[adjustToSize(end - 1)];
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
    
    public String printReverse() {
        String result = "";
        for(int i = end - 1 + (start > end ? array.length : 0); i >=start ; i--) {
            if(!result.isEmpty()) {
                result += ",";
            }
            result += array[adjustToSize(i)];
        }
        return "[" + result + "]";
    } 
}

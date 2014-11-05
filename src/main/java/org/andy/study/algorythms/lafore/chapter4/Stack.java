package org.andy.study.algorythms.lafore.chapter4;

/**
 *
 * @author andy
 */
public class Stack<T> {
    Object[] array = new Object[10];
    int pointer = -1;
    
    public T pop() throws IllegalAccessException {
        if(pointer < 0) {
            throw new IllegalAccessException();
        }
        return (T) array[pointer--];
    }
    
    public T peek() throws IllegalAccessException {
        if(pointer < 0) {
            throw new IllegalAccessException();
        }
        return (T) array[pointer];
    }
    
    public void push(T item) throws IllegalAccessException {
        if(pointer + 1 >= array.length) {
            throw new IllegalAccessException();
        }
        array[++pointer] = item;
    }
    
    public boolean isEmpty() {
        return pointer < 0;
    }
    
}

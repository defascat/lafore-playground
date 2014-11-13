
package org.andy.study.algorythms.lafore.chapter4;

/**
 *
 * @author andy
 */
public class DequeStack<T> extends Stack<T> {
    private final Deque<T> deque = new Deque<>();
    
    @Override
    public T pop() throws IllegalAccessException {
        return deque.removeRight();
    }
    
    @Override
    public T peek() throws IllegalAccessException {
        return deque.peekRight();
    }
    
    @Override
    public void push(T item) throws IllegalAccessException {
        deque.insertRight(item);
    }
    
    @Override
    public boolean isEmpty() {
        return deque.isEmpty();
    }

}

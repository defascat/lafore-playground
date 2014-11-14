package org.andy.study.algorythms.lafore.chapter5;

import org.andy.study.algorythms.lafore.chapter4.Stack;

/**
 *
 * @author andy
 */
public class LinkStack<T> extends Stack<T> {
    private LinkList<T> linkList = new LinkList<>();
    
    @Override
    public boolean isEmpty() {
        return linkList.isEmpty();
    }

    @Override
    public void push(T item) throws IllegalAccessException {
        linkList.insertFirst(item);
    }

    @Override
    public T peek() throws IllegalAccessException {
        validateHasData();
        return linkList.getFirst();
    }

    private void validateHasData() throws IllegalAccessException {
        if(isEmpty()) {
            throw new IllegalAccessException();
        }
    }

    @Override
    public T pop() throws IllegalAccessException {
        validateHasData();
        return linkList.deleteFirst();
    }
    
}

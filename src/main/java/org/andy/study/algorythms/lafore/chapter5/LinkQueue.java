package org.andy.study.algorythms.lafore.chapter5;

import org.andy.study.algorythms.lafore.chapter4.Queue;

/**
 *
 * @author andy
 */
public class LinkQueue<T> extends Queue<T> {
    private LinkList<T> list = new LinkList<>();
    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public T peek() throws IllegalStateException {
        return list.getFirst();
    }

    @Override
    public T remove() throws IllegalStateException {
        return list.deleteFirst();
    }

    @Override
    public void insert(T data) throws IllegalStateException {
        list.insertLast(data);
    }
    
    public String print() {
        return list.print();
    } 

}

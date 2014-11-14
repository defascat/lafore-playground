package org.andy.study.algorythms.lafore.chapter5;

import java.util.Objects;

/**
 *
 * @author andy
 */
public class LinkList<T> {

    private Link<T> head;

    public void insertFirst(T item) {
        final Link<T> newItem = new Link<>(item);
        newItem.setNext(head);
        if(head != null) {
            head.setPrevious(newItem);
        }
        head = newItem;
    }
    
    public void deleteFirst() {
        if(isEmpty()) {
            throw new IllegalStateException();
        }
        head = head.getNext();
        if (head != null) {
            head.setPrevious(null);
        }
    }

    public boolean remove(T item) {
        Link<T> link = head;
        while (link != null) {
            if (Objects.equals(link.getData(), item)) {
                if (link.getPrevious() != null) {
                    link.getPrevious().setNext(link.getNext());
                    link.getNext().setPrevious(link.getPrevious());
                } else {
                    deleteFirst();                    
                }
                return true;
            }
            link = link.getNext();
        }
        return false;
    }

    public int indexOf(T item) {
        int i = 0;
        Link<T> link = head;
        while (link != null) {
            if (Objects.equals(link.getData(), item)) {
                return i;
            }
            link = link.getNext();
            i++;
        }
        return -1;
    }
    
    public boolean isEmpty() {
        return head == null;
    }    
}

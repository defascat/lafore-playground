package org.andy.study.algorythms.lafore.chapter5;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 *
 * @author andy
 */
public class LinkList<T> {

    protected Link<T> head;
    protected Link<T> tail;

    public void insertFirst(T item) {
        final Link<T> newItem = new Link<>(item);
        if(head != null) {
            newItem.setNext(head);
            head.setPrevious(newItem);
        } else {
            tail = newItem;
        }
        head = newItem;
    }
    
    public void insertLast(T item) {
        final Link<T> newItem = new Link<>(item);
        if(tail != null) {
            newItem.setPrevious(tail);
            tail.setNext(newItem);
        } else {
            head = newItem;
        }
        tail = newItem;
    }
    
    public T deleteFirst() {
        T val = getFirst();
        head = head.getNext();
        if (head != null) {
            head.setPrevious(null);
        }
        if(head == null) {
            tail = null;
        }
        return val;
    }

    public T getFirst() throws IllegalStateException {
        if(isEmpty()) {
            throw new IllegalStateException();
        }
        T val = head.getData();
        return val;
    }

    public T getLast() throws IllegalStateException {
        if(isEmpty()) {
            throw new IllegalStateException();
        }
        T val = tail.getData();
        return val;
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
    
    public String print() {
        String result = "";
        Link<T> link = head;
        while(link != null) {
            if(!result.isEmpty()) {
                result += ",";
            }
            result += link.getData();
            link = link.getNext();
        }
        return "[" + result + "]";
    } 
    
    public Iterator<T> iterator() {
        return new ListTerator();
    }

    class ListTerator implements Iterator<T> {
        private Link<T> current = null;
        private boolean endReached = isEmpty();
        @Override
        public boolean hasNext() {
            if(endReached) {
                return false;
            }
            
            if(current != null) {
                return current.getNext() != null;
            }
            return !isEmpty();
        }

        @Override
        public T next() {
            if(endReached) {
                throw new NoSuchElementException();
            }
            
            if(current == null) {
                current = head;
            } else {
                current = current.getNext();
            }
            
            if(current.getNext() == null) {
                endReached = true;
            }
            return current.getData();
        }
    }
}

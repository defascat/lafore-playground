package org.andy.study.algorythms.lafore.chapter5;

/**
 *
 * @author andy
 */
public class CycledList<T> {
    private Link<T> current;
    
    public void add(T item) {
        Link<T> link = new Link<>(item);
        if(current == null) {
            current = link;
        } else {
            getLast().setNext(link);
        }
        link.setNext(current);    
    }
    
    public boolean delete(T item) {
        if(current != null) {
            if(current == current.getNext() && current.getData().equals(item)) {
                current = null;
                return true;
            } else {
                Link<T> cur = current;
                Link<T> prev = null;
                while(!cur.getData().equals(item) && cur.getNext() != current) {
                    prev = cur;
                    cur = cur.getNext();
                }
                if(cur.getData().equals(item)) {
                    if(prev != null) {
                        prev.setNext(cur.getNext());
                    } else {
                        final Link<T> next = cur.getNext();
                        getLast().setNext(next);
                        current = next;
                        
                    }
                    return true;
                }
            }
        }        
        return false;
    }
    
    public boolean contains(T item) {
        if(current != null) {
            Link<T> cur = current;
            if(cur.getData().equals(item)) {
                return true;
            }
            
            while(cur.getNext() != current) {
                cur = cur.getNext();
                if(cur.getData().equals(item)) {
                    return true;
                }
            }
        }
        return false;
    }

    private Link<T> getLast() {
        return getPrevious(current);
    }
    
    private Link<T> getPrevious(Link<T> item) {
        Link<T> cur = item;
        while(cur.getNext() != item) {
            cur = cur.getNext();
        }
        return cur;
    }

    boolean isEmpty() {
        return current == null;
    }
}

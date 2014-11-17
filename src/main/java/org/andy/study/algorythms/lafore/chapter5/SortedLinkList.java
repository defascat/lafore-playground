package org.andy.study.algorythms.lafore.chapter5;

/**
 *
 * @author andy
 */
public class SortedLinkList<T extends Number> extends LinkList<T> {
    public void insert(T data) {
        Link<T> prev = head;
        if(prev == null) {
            insertFirst(data);
            return;
        }
        
        while(prev != null &&
                Long.compare(prev.getData().longValue(), data.longValue()) < 0) {
            prev = prev.getNext();
        }
        
        if(prev == null) {
            insertLast(data);
            return;
        }
        
        final Link<T> previous = prev.getPrevious();
        if(previous == null) {
            insertFirst(data);
        } else {
            Link<T> item = new Link<>(data);
            item.setNext(prev);
            prev.setPrevious(item);
            
            item.setPrevious(previous);
            previous.setNext(item);
        }
        
    }
}

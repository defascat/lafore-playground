package org.andy.study.algorythms.lafore.chapter5;

/**
 *
 * @author andy
 */
class Link<T> {
    private Link<T> previous;
    private Link<T> next;
    private final T data;
    
    public Link(T data) {
        this.data = data;
    }

    protected Link<T> getPrevious() {
        return previous;
    }

    public void setPrevious(Link<T> previous) {
        this.previous = previous;
    }

    public Link<T> getNext() {
        return next;
    }

    protected void setNext(Link<T> next) {
        this.next = next;
    }

    public T getData() {
        return data;
    }
}

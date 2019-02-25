package lesson4.List;

import lesson3.queue.Queue;

public class MyLinkedQueue<E extends Comparable<? super E>> implements Queue<E> {

    private final MyTwoSideLinkedList<E> data;

    public MyLinkedQueue() {
        data = new MyTwoSideLinkedList<>();
    }

    @Override
    public void insert(E value) {
        data.insert(value);
    }

    @Override
    public E remove() {
        return data.removeLast();
    }

    @Override
    public E peek() {
        return data.getFirstElement();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public int size() {
        return data.getSize();
    }
}

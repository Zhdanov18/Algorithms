package lesson3.deque;

import lesson3.queue.Queue;

public interface Deque<E extends Object & Comparable<? super E>> extends Queue<E>{

    public void insertLeft(E value);
    public void insertRight(E value);
    public E removeLeft();
    public E removeRight();
    public E peekLeft();
    public E peekRight();

}

package lesson3.queue;

public interface Queue<E extends Object & Comparable<? super E>> {

    void insert(E value);
    E remove();
    E peek();

    boolean isEmpty();
    boolean isFull();
    int size();
}

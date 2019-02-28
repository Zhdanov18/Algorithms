package lesson4.List;

public interface LinkedList<E> {

    void insert(E value);
    E remove();
    boolean remove(E value);
    boolean find(E value);

    boolean isEmpty();
    int getSize();
    E getFirstElement();
}

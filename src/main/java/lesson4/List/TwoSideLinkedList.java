package lesson4.List;

public interface TwoSideLinkedList<E> extends LinkedList<E> {

    void insertLast(E value);
    E removeLast();

}

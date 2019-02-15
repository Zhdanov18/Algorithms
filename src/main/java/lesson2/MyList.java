package lesson2;

public interface MyList<E extends Comparable> {

    E get(int index);
    void add(E value);
    boolean remove(E value);
    boolean remove(int index);
    int find(E value);

    void sortBubble();
    void sortSelect();
    void sortInsert();
}

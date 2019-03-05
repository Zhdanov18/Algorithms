package lesson6;

public interface Tree<E extends Comparable<? super E>> {

    enum TraverseMode {IN_ORDER, PRE_ORDER, POST_ORDER}
    void add(E value);
    boolean remove(E value);
    boolean find(E value);
    boolean isEmpty();
    void display();
    void traverse(TraverseMode traverseMode);

    boolean isBalanced();
    int height();

}

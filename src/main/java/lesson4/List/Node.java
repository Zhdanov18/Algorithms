package lesson4.List;

import java.util.Objects;

public class Node<E> {

    private E data;
    private Node<E> next;

    public Node(E data) {
        this.data = data;
    }

    public E getData(){
        return data;
    }

    public Node<E> getNext(){
        return next;
    }

    public void setNext(Node<E> next){
        this.next = next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node<?> node = (Node<?>) o;
        return data.equals(node.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                '}';
    }
}

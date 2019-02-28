package lesson4.List;

public class MyTwoSideLinkedList<E> extends MyLinkedList<E> implements TwoSideLinkedList<E> {

    private Node<E> last;

    @Override
    public void insert(E value) {
        super.insert(value);
        if (getSize() == 1) {
            last = first;
        }
    }

    @Override
    public E remove() {
        E removed = super.remove();
        if (isEmpty()) {
            last = null;
        }
        return removed;
    }

    @Override
    public boolean remove(E value) {
        Node<E> current = first;
        Node<E> previous = null;
        while ( current != null ) {
            if ( current.getData().equals(value) ) {
                break;
            }
            previous = current;
            current = current.getNext();
        }
        if (current == null) {
            return false;
        }
        if (current == first) {
            first = first.getNext();
        } else if (current == last) {
            last = previous;
            previous.setNext(null);
        } else {
            previous.setNext(current.getNext());
        }
        size--;
        return true;
    }

    @Override
    public void insertLast(E value) {
        Node<E> newNode = new Node<>(value);
        if (isEmpty()) {
            first = newNode;
        }
        else {
            last.setNext(newNode);
        }
        last = newNode;
        size++;
    }

    @Override
    public E removeLast() {
        Node<E> current = first;
        Node<E> previous = null;
        while ( current != null ) {
            if ( current == last ) {
                previous.setNext(null);
                last = previous;
                size--;
                return current.getData();
            }
            previous = current;
            current = current.getNext();
        }
        return null;
    }

}

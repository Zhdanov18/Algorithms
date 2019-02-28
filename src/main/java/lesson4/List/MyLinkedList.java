package lesson4.List;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<E> implements LinkedList<E>, Iterable<E> {

    protected Node<E> first;
    protected int size;

    @Override
    public void insert(E value) {
        Node<E> newNode = new Node<>(value);
        newNode.setNext(first);
        first = newNode;
        size++;
    }

    @Override
    public E remove() {
        if(isEmpty()){
            return null;
        }
        Node<E> removed = first;
        first = removed.getNext();
        size--;
        return removed.getData();
    }

    @Override
    public boolean remove(E value){
        return removeGen(value);
    }

    public boolean removeGen(Object value){
        Node<E> current = first;
        Node<E> previous = null;
        boolean isNode = value.getClass().getSimpleName().equals("Node");
        while (current != null){
            if((!isNode && current.getData().equals(value)) || (isNode && current == value)){
                break;
            }
            previous = current;
            current = current.getNext();
        }
        if(current == null){
            return false;
        }
        if(current == first){
            first = current.getNext();
        } else {
            previous.setNext(current.getNext());
        }
        size--;
        return false;
    }

    @Override
    public boolean find(E value) {
        Node<E> current = first;
        while (current != null){
            if(current.getData().equals(value)){
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public E getFirstElement() {
        return first.getData();
    }

    @Override
    public Iterator<E> iterator() {
        return new MyLinkedListIterator();
    }

//сделаем класс итератора внутренним, упрощается код и удобнее реализовать - доступ к данным внешнего класса
    private class MyLinkedListIterator implements Iterator {
        private Node<E> current;
        private Node<E> cursor;

        public MyLinkedListIterator() {
            cursor = first;
        }

        @Override
        public boolean hasNext() {
            return cursor != null;
        }

        @Override
        public E next() {
            if(cursor == null){
                throw new NoSuchElementException();
            }
            current = cursor;
            cursor = cursor.getNext();
            return current.getData();
        }

        @Override
        public void remove() {
//            throw new UnsupportedOperationException();
            removeGen(current);
        }
    }
}

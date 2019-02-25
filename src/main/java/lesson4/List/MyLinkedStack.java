package lesson4.List;

import lesson3.stack.Stack;

public class MyLinkedStack<E> implements Stack<E> {

    private final MyLinkedList<E> data;

    public MyLinkedStack() {
        data = new MyLinkedList<>();
    }

    @Override
    public void push(E value) {
        data.insert(value);
    }

    @Override
    public E pop() {
        return data.remove();
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
}

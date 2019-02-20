package lesson3.stack;

import lesson3.stack.Stack;

public class MyStack<E> implements Stack<E> {

    private E data[];
    private int top;

    public MyStack(int maxSize) {
        this.data = (E[]) new Object[maxSize];
        this.top = -1;
    }

    @Override
    public void push(E value) {
        data[++top] = value;
    }

    @Override
    public E pop() {
        return data[top--];
    }

    @Override
    public E peek() {
        return data[top];
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public boolean isFull() {
        return data.length == top + 1;
    }
}

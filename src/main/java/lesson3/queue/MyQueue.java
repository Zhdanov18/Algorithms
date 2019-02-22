package lesson3.queue;

public class MyQueue<E extends Object & Comparable<? super E>> implements Queue<E> {

    protected static final int DEFAULT_REAR = -1;
    protected static final int DEFAULT_FRONT = 0;

    protected E data[];
    protected int front, rear, size;

    public MyQueue(int maxSize) {
        data = (E[]) new Object[maxSize];
        front = DEFAULT_FRONT;
        rear = DEFAULT_REAR;
    }

    @Override
    public void insert(E value) {
        if(rear == data.length - 1){
            rear = DEFAULT_REAR;
        }
        data[++rear] = value;
        size++;
    }

    @Override
    public E remove() {
        E result = data[front++];
        size--;
        if(front == data.length){
            front = DEFAULT_FRONT;
        }
        return result;
    }

    @Override
    public E peek() {
        return data[front];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == data.length;
    }

    @Override
    public int size() {
        return size;
    }
}

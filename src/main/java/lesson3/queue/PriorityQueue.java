package lesson3.queue;

public class PriorityQueue<E extends Object & Comparable<? super E>> extends MyQueue<E> {

    public PriorityQueue(int maxSize) {
        super(maxSize);
    }

    @Override
    public void insert(E value) {
        if (isEmpty()) {
            data[size++] = value;
            return;
        }

        int index;
        for (index = size - 1; index >= 0 ; index--) {
            if (value.compareTo(data[index]) > 0) {
                data[index + 1] = data[index];
            }
            else {
                break;
            }
        }

        data[index + 1] = value;
        size++;
    }

    @Override
    public E remove() {
        return data[--size];
    }

    @Override
    public E peek() {
        return data[size - 1];
    }
}

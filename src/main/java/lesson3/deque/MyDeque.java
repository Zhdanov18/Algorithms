package lesson3.deque;

public class MyDeque<E extends  Object & Comparable<? super E>> implements Deque<E> {

    private E[] data;
    private static int defaultLeft, defaultRight;
    private int left, right, size;

    public MyDeque(int maxSize) {
        data = (E[]) new Object[maxSize];
        left = defaultLeft = -1;
        right = defaultRight = data.length;
        size = 0;
    }

    @Override
    public void insertLeft(E value) {
        if(left == defaultRight - 1){
            left = defaultLeft;
        }
        data[++left] = value;
        size++;
    }

    @Override
    public void insertRight(E value) {
        if(right == defaultLeft + 1){
            right = defaultRight;
        }
        data[--right] = value;
        size++;
    }

    @Override
    public E removeLeft() {
        left = checkLeftBorder();
        size--;
        return data[left--];
    }

    @Override
    public E removeRight() {
        right = checkRightBorder();
        size--;
        return data[right++];
    }

    private int checkLeftBorder(){
        return (left == defaultLeft) ? defaultRight - 1 : left;
    }

    private int checkRightBorder(){
        return (right == defaultRight) ? defaultLeft + 1 : right;
    }

    @Override
    public E peekLeft() {
        return data[checkLeftBorder()];
    }

    @Override
    public E peekRight() {
        return data[checkRightBorder()];
    }

    @Override
    public void insert(E value) {
        insertLeft(value);
    }

    @Override
    public E remove() {
        return removeRight();
    }

    @Override
    public E peek() {
        return peekRight();
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

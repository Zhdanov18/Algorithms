package lesson2;

import java.util.Arrays;

public class MyArrayList<E extends Comparable> implements MyList, Cloneable{
    private static final int DEFAULT_SIZE = 16;
    private static final int INVALID_INDEX = -1;

    protected E[] data;
    protected int size;

    public MyArrayList(){
        this(DEFAULT_SIZE);
    }

    public MyArrayList(int size){
        this.data = (E[]) new Comparable[size];
    }

    @Override
    public E get(int index) {
        if(index > size)
            return null;
        return data[index];
    }

    @Override
    public void add(Comparable value) {
        checkSize();
        data[size++] = (E) value;
    }

    protected void checkSize(){
        if(size < data.length){
            return;
        }
        data = Arrays.copyOf(data, size * 2);
    }

    @Override
    public boolean remove(Comparable value) {
        int index = find(value);
        if(index != INVALID_INDEX){
            return remove(index);
        }
        return false;
    }

    @Override
    public boolean remove(int index) {
        if(index < 0 || index >= size){
            return false;
        }
        if(size > 1){
            for (int i = index; i < size - 1; i++) {
                data[i] = data[i + 1];
            }
        }
        data[size] = null;
        size--;
        return true;
    }

    @Override
    public int find(Comparable value) {
        for(int i = 0; i < data.length; i++){
            if(value.equals(data[i])){
                return i;
            }
        }
        return INVALID_INDEX;
    }

    @Override
    public void sortBubble() {
        for (int i = 0; i < size - 1; i++) {
            for(int j = 0; j < size - 1 - i; j++){
                if(data[j].compareTo(data[j + 1]) > 0){
                    flip(j, j + 1);
                }
            }
        }
    }

    @Override
    public void sortSelect() {
        int mark;
        for (int i = 0; i < size - 1; i++) {
            mark = i;
            for (int j = i + 1; j < size; j++) {
                if(data[mark].compareTo(data[j]) > 0){
                    mark = j;
                }
            }
            flip(i, mark);
        }
    }

    @Override
    public void sortInsert() {
        for (int i = 1; i < size; i++) {
            E tmp = data[i];
            int in = i;
            while (in > 0 && data[in - 1].compareTo(tmp) >= 0){
                data[in] = data[in - 1];
                --in;
            }
            data[in] = tmp;
        }
    }

    public MyArrayList<E> clone() throws CloneNotSupportedException{
        MyArrayList<E> dest = (MyArrayList) super.clone();
        dest.data = data.clone();
        return dest;
    }

    private void flip(int index1, int index2) {
        E tmp = data[index1];
        data[index1] = data[index2];
        data[index2] = tmp;
    }

    public void printAll() {
        for(E value: data){
            System.out.print(value + " ");
        }
        System.out.println();
    }
}

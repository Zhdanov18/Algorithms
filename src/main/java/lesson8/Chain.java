package lesson8;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Objects;

public class Chain<E> {

    private class Entry {
        private E item;
        private int value;

        public Entry(E item, int value) {
            this.item = item;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Entry{" + "item=" + item.toString() + ", value=" + value + '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Entry entry = (Entry) o;
            return item.equals(entry.item);
        }

        @Override
        public int hashCode() {
            return Objects.hash(item);
        }
    }

    private LinkedList<Entry>[] data;
    private ListIterator<Entry> entryListIterator;
    private Entry currentEntry;
    private int size;

    public Chain(int maxSize) {
        this.data = new LinkedList[maxSize];
    }

    private int hashFunc(int key) {
        return key % data.length;
    }

    private int getIndex(E item) {
        return hashFunc(item.hashCode());
    }

    public void put(E item, int value) {
        int index = getIndex(item);
        if (data[index] == null) {
            data[index] = new LinkedList<>();
        }
        //сравнивать будем только по item, при попытке добавления такого же item с другим value - перезаписываем
        Entry e = new Entry(item, value);
        if (locate(item)) {
            entryListIterator.set(e);
        } else {
            data[index].add(e);
            size++;
        }
    }

    public Integer get(E item) {
        if (locate(item)) {
            return currentEntry.value;
        }
        return null;
    }

    public boolean remove(E item) {
        if (locate(item)) {
            entryListIterator.remove();
            size--;
            return true;
        }
        return false;
    }

    private boolean locate(E item) {
        int index = getIndex(item);
        if (data[index] == null) {
            return false;
        }
        entryListIterator = data[index].listIterator();
        while (entryListIterator.hasNext()) {
            currentEntry = entryListIterator.next();
            if (currentEntry.item.equals(item)) {
                return true;
            }
        }
        return false;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void display() {
        System.out.println("-----------");
        for (int i = 0; i < data.length; i++) {
            System.out.println(String.format("%d = [%s]", i, data[i]));
        }
        System.out.println("-----------");
    }
}

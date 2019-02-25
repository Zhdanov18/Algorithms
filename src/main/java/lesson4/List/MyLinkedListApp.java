package lesson4.List;

import java.util.Iterator;
import java.util.function.Consumer;

public class MyLinkedListApp {
    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.remove(2);
        list.insert(4);

        Iterator listIterator = list.iterator();
        while (listIterator.hasNext()){
            System.out.print(listIterator.next() + " ");
        }
        listIterator.remove();

        System.out.println();
        for(Integer i: list){
            System.out.print(i + " ");
        }

        System.out.println();
        Consumer consumer = (obj) -> System.out.print(obj + " ");
        list.forEach(consumer);
     }
}
//        4 3 1
//        4 3
//        4 3

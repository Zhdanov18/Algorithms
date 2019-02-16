package lesson2;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Main {
    final static int listSize = 100000;

    public static void fillMyList(MyArrayList<?> myList){
        Random r = new Random();
        for (int i = 0; i < listSize; i++) {
            myList.add(r.nextInt(100));
        }
    }

    public static void timePrint(String text, long start){
        //переводим в секунды и тратим время на вызов метода, но в нашем случае это некритично
        System.out.println(text + ", cекунд: " + TimeUnit.NANOSECONDS.toSeconds(System.nanoTime() - start));
    }

    public static void main(String[] args) {
        MyArrayList<Integer>[] myList = new MyArrayList[3];
        for (int i = 0; i < myList.length; i++) {
            myList[i] = new MyArrayList<Integer>(listSize);
        }
        fillMyList(myList[0]);

        try {
            for (int i = 1; i < myList.length; i++) {
                myList[i] = myList[0].clone();
            }
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        long start = System.nanoTime();
        myList[0].sortBubble();
        timePrint("Пузырьковая сортировка", start);

        start = System.nanoTime();
        myList[1].sortSelect();
        timePrint("Сортировка выбором", start);

        start = System.nanoTime();
        myList[2].sortInsert();
        timePrint("Сортировка вставкой", start);
    }
}
//Вывод на 100000 элементов:
//Пузырьковая сортировка, секунд: 38
//Сортировка выбором, секунд: 12
//Сортировка вставкой, секунд:3

//Вывод на 1000000 элементов:
//Пузырьковая сортировка, секунд: 3871
//Сортировка выбором, секунд: 1252
//Сортировка вставкой, секунд:395

//Результат: при увеличении количества элементов на порядок, длительность сортировки возрастает примерно на два порядка
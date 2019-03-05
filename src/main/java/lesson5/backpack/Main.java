package lesson5.backpack;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Книга", 1, 600));
        items.add(new Item("Бинокль", 2, 5000));
        items.add(new Item("Аптечка", 4, 1500));
        items.add(new Item("Ноутбук", 2, 40000));
        items.add(new Item("Котелок", 1, 500));

        Backpack backpack = new Backpack(3);
        backpack.getContent(items);
        System.out.println(" ");

        backpack.setMaxWeight(4);
        backpack.getContent(items);
    }
}

//        Item{name='Книга', weight=1, price=600}
//        Item{name='Ноутбук', weight=2, price=40000}
//
//        Item{name='Бинокль', weight=2, price=5000}
//        Item{name='Ноутбук', weight=2, price=40000}

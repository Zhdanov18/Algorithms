package lesson8;

public class Main {
    public static void main(String[] args) {

        Chain<Item> chain = new Chain(10);

        chain.put(new Item("apple"), 10);
        chain.put(new Item("banana"), 15);
        chain.put(new Item("lemon"), 30);
        chain.put(new Item("potato"), 50);
        chain.put(new Item("potato"), 91);
        chain.put(new Item("grape"), 45);
        chain.put(new Item("apricot"), 66);
        chain.put(new Item("avocado"), 80);

        System.out.println("Size is " + chain.getSize());
        chain.display();

        System.out.println("Cost potato is " + chain.get(new Item("potato")));
        System.out.println("Cost avocado is " + chain.get(new Item("avocado")));

        chain.remove(new Item("avocado"));
        System.out.println("Cost avocado is " + chain.get(new Item("avocado")));

        chain.display();
    }
}
//        Size is 7
//        -----------
//        0 = [null]
//        1 = [null]
//        2 = [[Entry{item=Item{name='potato'}, value=91}]]
//        3 = [[Entry{item=Item{name='grape'}, value=45}]]
//        4 = [null]
//        5 = [null]
//        6 = [null]
//        7 = [[Entry{item=Item{name='apple'}, value=10}, Entry{item=Item{name='apricot'}, value=66}, Entry{item=Item{name='avocado'}, value=80}]]
//        8 = [[Entry{item=Item{name='banana'}, value=15}, Entry{item=Item{name='lemon'}, value=30}]]
//        9 = [null]
//        -----------
//        Cost potato is 91
//        Cost avocado is 80
//        Cost avocado is null
//        -----------
//        0 = [null]
//        1 = [null]
//        2 = [[Entry{item=Item{name='potato'}, value=91}]]
//        3 = [[Entry{item=Item{name='grape'}, value=45}]]
//        4 = [null]
//        5 = [null]
//        6 = [null]
//        7 = [[Entry{item=Item{name='apple'}, value=10}, Entry{item=Item{name='apricot'}, value=66}]]
//        8 = [[Entry{item=Item{name='banana'}, value=15}, Entry{item=Item{name='lemon'}, value=30}]]
//        9 = [null]
//        -----------

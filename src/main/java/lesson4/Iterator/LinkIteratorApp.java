package lesson4.Iterator;

public class LinkIteratorApp {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        LinkIterator itr = new LinkIterator(list);

        itr.insertAfter("Artem", 20);
        itr.insertBefore("Sergey", 10);
        itr.insertBefore("Andrey", 12);
        itr.insertAfter("Alexey", 16);

        list.display();

        System.out.print("getCurrent(): ");
        itr.getCurrent().display​();

        System.out.println("deleteCurrent(): " + itr.deleteCurrent());
        list.display();

        System.out.print("getCurrent(): ");
        itr.getCurrent().display​();

        itr.reset();
        System.out.print("reset(): ");
        itr.getCurrent().display​();

        itr.nextLink();
        System.out.print("nextLink(): ");
        itr.getCurrent().display​();

        System.out.println("atEnd(): " + itr.atEnd());

        itr.nextLink();
        System.out.print("nextLink(): ");
        itr.getCurrent().display​();
        System.out.println("atEnd(): " + itr.atEnd());
    }
}
//        Name: Andrey, age: 12
//        Name: Alexey, age: 16
//        Name: Sergey, age: 10
//        Name: Artem, age: 20
//        getCurrent(): Name: Alexey, age: 16
//        deleteCurrent(): Alexey
//        Name: Andrey, age: 12
//        Name: Sergey, age: 10
//        Name: Artem, age: 20
//        getCurrent(): Name: Sergey, age: 10
//        reset(): Name: Andrey, age: 12
//        nextLink(): Name: Sergey, age: 10
//        atEnd(): false
//        nextLink(): Name: Artem, age: 20
//        atEnd(): true

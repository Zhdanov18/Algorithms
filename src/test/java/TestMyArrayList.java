import lesson2.MyArrayList;
import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

public class TestMyArrayList {
    public static final int INVALID_VALUE = 55;

    @Test
    public void test_search() {
        MyArrayList<Integer> myList = new MyArrayList(3);
        myList.add(10);
        myList.add(3);
        myList.add(7);

        Assert.assertTrue(myList.find(10) == 0);
        Assert.assertTrue(myList.find(3) == 1);
        Assert.assertTrue(myList.find(INVALID_VALUE) == -1);

        Assert.assertThat(myList.find(7), Is.is(2));
    }

    @Test
    public void test_sort_bubble(){
        MyArrayList<Integer> myList = new MyArrayList(3);
        myList.add(10);
        myList.add(3);
        myList.add(7);
        myList.sortBubble();
        Assert.assertEquals((long) myList.get(0), 3);
        Assert.assertEquals((long) myList.get(1), 7);
        Assert.assertEquals((long) myList.get(2), 10);
        //при изменении в MyArrayList возвращаемого значения метода get c Comparable на E касты пришлось делать в тестах
        //хотя можно использовать другие утверждения, как в следующем тесте
    }

    @Test
    public void test_sort_select(){
        MyArrayList<Integer> myList = new MyArrayList(3);
        myList.add(10);
        myList.add(3);
        myList.add(7);
        myList.sortSelect();
        Assert.assertThat(myList.get(0), Is.is(3));
        Assert.assertThat(myList.get(1), Is.is(7));
        Assert.assertThat(myList.get(2), Is.is(10));
    }

    @Test
    public void test_sort_insert(){
        MyArrayList<Integer> myList = new MyArrayList(3);
        myList.add(10);
        myList.add(3);
        myList.add(7);
        myList.sortInsert();
        Assert.assertThat(myList.get(0), Is.is(3));
        Assert.assertThat(myList.get(1), Is.is(7));
        Assert.assertThat(myList.get(2), Is.is(10));
    }

}

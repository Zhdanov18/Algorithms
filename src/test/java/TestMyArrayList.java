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
        Assert.assertEquals(myList.get(0), 3);
        Assert.assertEquals(myList.get(1), 7);
        Assert.assertEquals(myList.get(2), 10);
    }

    @Test
    public void test_sort_select(){
        MyArrayList<Integer> myList = new MyArrayList(3);
        myList.add(10);
        myList.add(3);
        myList.add(7);
        myList.sortSelect();
        Assert.assertEquals(myList.get(0), 3);
        Assert.assertEquals(myList.get(1), 7);
        Assert.assertEquals(myList.get(2), 10);
    }

    @Test
    public void test_sort_insert(){
        MyArrayList<Integer> myList = new MyArrayList(3);
        myList.add(10);
        myList.add(3);
        myList.add(7);
        myList.sortInsert();
        Assert.assertEquals(myList.get(0), 3);
        Assert.assertEquals(myList.get(1), 7);
        Assert.assertEquals(myList.get(2), 10);
    }

}

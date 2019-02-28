package lesson4;

import lesson4.List.MyLinkedQueue;
import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

public class TestMyLinkedQueue {

    @Test
    public void test_insert(){
        MyLinkedQueue<Integer> queue = new MyLinkedQueue<Integer>();

        Assert.assertTrue(queue.isEmpty());

        queue.insert(1);
        queue.insert(2);
        queue.insert(3);

        Assert.assertFalse(queue.isFull());
        Assert.assertEquals(queue.size(), 3);
    }

    @Test
    public void test_remove(){
        MyLinkedQueue<Integer> queue = new MyLinkedQueue<Integer>();

        Assert.assertTrue(queue.isEmpty());

        queue.insert(1);
        queue.insert(2);

        Assert.assertThat(queue.remove(), Is.is(1));

        queue.insert(3);
        queue.insert(4);

        Assert.assertThat(queue.remove(), Is.is(2));

        queue.insert(5);

        Assert.assertThat(queue.remove(), Is.is(3));
        Assert.assertThat(queue.remove(), Is.is(4));

        Assert.assertEquals(queue.size(), 1);
    }
}

package lesson3;

import lesson3.queue.MyQueue;
import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

public class TestMyQueue {

    @Test
    public void test_insert(){
        MyQueue<Integer> queue = new MyQueue<Integer>(3);

        Assert.assertTrue(queue.isEmpty());

        queue.insert(1);
        queue.insert(2);
        queue.insert(3);

        Assert.assertTrue(queue.isFull());
        Assert.assertEquals(queue.size(), 3);
    }

    @Test
    public void test_remove(){
        MyQueue<Integer> queue = new MyQueue<Integer>(3);

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

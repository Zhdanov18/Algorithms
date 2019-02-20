package lesson3;

import lesson3.deque.MyDeque;
import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

public class TestMyDeque {
    @Test
    public void test_insert(){
        MyDeque<Integer> deque = new MyDeque<Integer>(3);

        Assert.assertTrue(deque.isEmpty());

        deque.insertLeft(1);
        deque.insertRight(2);
        deque.insertRight(3);
        Assert.assertThat(deque.peekLeft(), Is.is(1));
        Assert.assertThat(deque.peek(), Is.is(3));

        Assert.assertTrue(deque.isFull());
        Assert.assertEquals(deque.size(), 3);
    }

    @Test
    public void test_remove(){
        MyDeque<Integer> deque = new MyDeque<Integer>(3);

        Assert.assertTrue(deque.isEmpty());

        deque.insertLeft(1);
        Assert.assertThat(deque.peekRight(), Is.is(1));

        deque.insertLeft(2);

        Assert.assertThat(deque.removeRight(), Is.is(1));

        deque.insertRight(3);
        deque.insertRight(4);

        Assert.assertThat(deque.peekRight(), Is.is(4));
        Assert.assertThat(deque.removeLeft(), Is.is(2));

        deque.insertRight(5);

        Assert.assertThat(deque.removeLeft(), Is.is(3));

        Assert.assertEquals(deque.size(), 2);
    }

}

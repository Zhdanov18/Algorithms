package lesson4;

import lesson4.List.MyLinkedStack;
import org.junit.Assert;
import org.junit.Test;

public class TestMyLinkedStack {
    @Test
    public void test_empty_push_full(){
        MyLinkedStack<Integer> stack = new MyLinkedStack<Integer>();

        Assert.assertTrue(stack.isEmpty());

        stack.push(1);
        stack.push(2);
        stack.push(3);

        Assert.assertFalse(stack.isFull());
    }

    @Test
    public void test_pop_peek(){
        MyLinkedStack<Integer> stack = new MyLinkedStack<Integer>();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        Assert.assertTrue(stack.pop() == 3);
        Assert.assertTrue(stack.pop() == 2);

        Assert.assertTrue(stack.peek() == 1);

        Assert.assertTrue(stack.pop() == 1);
    }
}

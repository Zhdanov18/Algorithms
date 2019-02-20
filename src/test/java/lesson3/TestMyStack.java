package lesson3;

import lesson3.stack.MyStack;
import org.junit.Assert;
import org.junit.Test;

public class TestMyStack {

    @Test
    public void test_empty_push_full(){
        MyStack<Integer> stack = new MyStack<Integer>(3);

        Assert.assertTrue(stack.isEmpty());

        stack.push(1);
        stack.push(2);
        stack.push(3);

        Assert.assertTrue(stack.isFull());
    }

    @Test
    public void test_pop_peek(){
        MyStack<Integer> stack = new MyStack<Integer>(3);

        stack.push(1);
        stack.push(2);
        stack.push(3);

        Assert.assertTrue(stack.pop() == 3);
        Assert.assertTrue(stack.pop() == 2);

        Assert.assertTrue(stack.peek() == 1);

        Assert.assertTrue(stack.pop() == 1);
    }
}

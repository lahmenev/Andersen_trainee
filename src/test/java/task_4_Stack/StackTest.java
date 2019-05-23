package task_4_Stack;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * email : s.lakhmenev@andersenlab.com
 *
 * @author Lakhmenev Sergey
 * @version 1.1
 */
public class StackTest {

    /**
     * Put String and Integer elements to each stack and check amount of elements
     */
    @Test
    public void testAdd() {
        MyStack<String> stackStr = new MyStack<>(4);
        stackStr.push("red");
        stackStr.push("green");
        stackStr.push("blue");

        MyStack<Integer> stackInt = new MyStack<>(4);
        stackInt.push(1);
        stackInt.push(2);
        stackInt.push(3);

        assertEquals(3, stackStr.size());
        assertEquals(3, stackInt.size());
    }

    /**
     * Put null in the specified stack. NullPointerException is expected
     */
    @Test(expected = NullPointerException.class)
    public void testAddNullElem() {
        MyStack<String> stack = new MyStack<>(5);
        stack.push("red");
        stack.push("green");
        stack.push(null);
    }

    /**
     * Put more elements in the stack than it contain. ArrayIndexOutOfBoundsException is expected
     */
    @Test(expected = IllegalStateException.class)
    public void testAddFullArray() {
        MyStack<String> stack = new MyStack<>(2);
        stack.push("red");
        stack.push("green");
        stack.push("black");
    }

    /**
     * Remove one element from the specified stack and check amount of elements
     */
    @Test
    public void testRemove() {
        MyStack<String> stack = new MyStack<>(3);
        stack.push("red");
        stack.push("green");
        stack.push("black");
        stack.pop();

        assertEquals(2, stack.size());
    }

    /**
     * Remove element from empty stack. IllegalStateException is expected
     */
    @Test(expected = IllegalStateException.class)
    public void testRemoveEmptyStack() {
        MyStack<String> stack = new MyStack<>(3);
        stack.pop();
    }

    /**
     * Getting element from top of the specified stack
     */
    @Test
    public void testGetTop() {
        MyStack<String> stack = new MyStack<>(3);
        stack.push("red");
        stack.push("green");
        stack.push("white");

        assertEquals("white", stack.peek());
    }

    /**
     * Getting element from empty stack. IllegalStateException is expected
     */
    @Test(expected = IllegalStateException.class)
    public void testGetNoItem() {
        MyStack<String> stack = new MyStack<>(2);
        stack.peek();
    }
}

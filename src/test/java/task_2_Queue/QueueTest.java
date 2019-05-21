package task_2_Queue;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * email : s.lakhmenev@andersenlab.com
 *
 * @author Lakhmenev Sergey
 * @version 1.1
 */
public class QueueTest {

    /**
     * Put one String element to specified queue and check amount of elements
     */
    @Test
    public void testAddString() {
        MyQueue<String> queue = new MyQueue<>(5);
        queue.add("red");
        assertEquals(1, queue.getCount());
    }

    /**
     * Put one Integer element to specified queue and check amount of elements
     */
    @Test
    public void testAddInteger() {
        MyQueue<Integer> queue = new MyQueue<>(5);
        queue.add(2);
        assertEquals("the result must be 1",1, queue.getCount());
    }

    /**
     * Put two elements to specified queue and check amount of elements
     */
    @Test
    public void testAddAnyElem() {
        MyQueue<String> queue = new MyQueue<>(5);
        queue.add("red");
        queue.add("blue");
        assertEquals("the result must be 2",2, queue.getCount());
    }

    /**
     * Put null in the specified queue. NullPointerException is expected
     */
    @Test(expected = NullPointerException.class)
    public void testAddNullElem() {
        MyQueue<String> queue = new MyQueue<>(5);
        queue.add(null);
    }

    /**
     * Put more elements in the queue than it contain. ArrayIndexOutOfBoundsException is expected
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testAddFullArray() {
        MyQueue<String> queue = new MyQueue<>(5);
        queue.add("red");
        queue.add("green");
        queue.add("yellow");
        queue.add("black");
        queue.add("white");
        queue.add("brown");
    }

    /**
     * Remove one element from the specified queue and check amount of elements
     */
    @Test
    public void testDelete() {
        MyQueue<String> queue = new MyQueue<>(5);
        queue.add("red");
        queue.add("blue");
        queue.add("green");
        queue.remove();
        assertEquals("the result must be 2",2,queue.getCount());
    }

    /**
     * Remove element from empty queue. IllegalStateException is expected
     */
    @Test(expected = IllegalStateException.class)
    public void testDelException() {
        MyQueue<String> queue = new MyQueue<>(5);
        queue.remove();
    }
}

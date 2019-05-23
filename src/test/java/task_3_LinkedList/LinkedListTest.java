package task_3_LinkedList;

import org.junit.Test;
import java.util.NoSuchElementException;
import static org.junit.Assert.*;

/**
 * email : s.lakhmenev@andersenlab.com
 *
 * @author Lakhmenev Sergey
 * @version 1.1
 */
public class LinkedListTest {

    /**
     * Put two String elements to list and check amount of elements
     */
    @Test
    public void testAddString() {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.add("red");
        list.add("green");
        assertEquals(2, list.size());
    }

    /**
     * Put three Integer elements to list and check amount of elements
     */
    @Test
    public void testAddInteger() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(3, list.size());
    }

    /**
     * Put three elements in list and than put element to one index.
     * Check amount of list and each elements by index
     */
    @Test
    public void testAddElemByIndex() {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.add("red");
        list.add("green");
        list.add("blue");
        list.add(1, "black");

        assertEquals(4, list.size());
        assertEquals("red", list.get(0));
        assertEquals("black", list.get(1));
        assertEquals("green", list.get(2));
        assertEquals("blue", list.get(3));
    }

    /**
     * Put element in list by index number three. IndexOutOfBoundsException is expected
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddException() {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.add("red");
        list.add("green");
        list.add(3, "gold");
    }

    /**
     * Removes last element from list. Check amount and get last index
     */
    @Test
    public void testRemoveLast() {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.add("red");
        list.add("green");
        list.removeLast();

        assertEquals(1, list.size());
        assertEquals("red", list.get());
    }

    /**
     * Removes element by index number 0. Check amount of list and position of remaining elements
     */
    @Test
    public void testRemoveByIndex() {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.add("red");
        list.add("green");
        list.add("black");
        list.remove(0);

        assertEquals(2, list.size());
        assertEquals("green", list.get(0));
        assertEquals("black", list.get(1));
    }

    /**
     * Removes specified element from list. Check amount of list and position of remaining elements
     */
    @Test
    public void testRemoveByObj() {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.add("red");
        list.add("green");
        list.add("black");
        list.remove("red");

        assertEquals(2, list.size());
        assertEquals("green", list.get(0));
        assertEquals("black", list.get(1));
    }

    /**
     * Removes element which is not in the list. IndexOutOfBoundsException is expected
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void removeNotSuchElem() {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.add("red");
        list.add("blue");
        list.add("green");
        list.remove("yellow");
    }

    /**
     * Removes element with wrong index. IndexOutOfBoundsException is expected
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void removeIndexExc() {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.add("red");
        list.add("blue");
        list.add("green");
        list.remove(6);
    }

    /**
     * Removes element from empty list. NoSuchElementException is expected
     */
    @Test(expected = NoSuchElementException.class)
    public void removeEmptyList() {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.remove("red");
    }
}

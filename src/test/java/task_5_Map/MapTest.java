package task_5_Map;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * email : s.lakhmenev@andersenlab.com
 *
 * @author Lakhmenev Sergey
 * @version 1.1
 */
public class MapTest {

    /**
     * Puts pairs into the map and check amount of pair
     */
    @Test
    public void testAdd() {
        MyMap<String, Integer> map = new MyMap<>(16);
        map.put("color", 1);
        map.put("price", 200);
        map.put(null, 10);
        map.put("color", 3);

        assertEquals(3, map.size());
    }

    /**
     * Puts pairs into full map. ArrayIndexOutOfBoundsException is expected
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testAddIsFull() {
        MyMap<String, Integer> map = new MyMap<>(2);
        map.put("color", 1);
        map.put("price", 200);
        map.put(null, 10);
        map.put("color", 3);
    }

    /**
     * Puts two null elements into the map. IllegalArgumentException is expected
     */
    @Test(expected = IllegalArgumentException.class)
    public void testTwoNullElem() {
        MyMap<String, Integer> map = new MyMap<>(2);
        map.put(null, 1);
        map.put("price", 200);
        map.put(null, 10);
        map.put("color", 3);
    }

    /**
     * Removes pair from map and check amount
     */
    @Test
    public void testRemove() {
        MyMap<String, Integer> map = new MyMap<>(16);
        map.put("color", 1);
        map.put("price", 1000);
        map.put("color", 7);
        map.put(null, 40);
        map.remove("price");

        assertEquals(2, map.size());
    }

    /**
     * Removes pair from empty map. ArrayIndexOutOfBoundsException is expected
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testRemoveIsEmpty() {
        MyMap<String, Integer> map = new MyMap<>(16);
        map.remove("color");
    }

    /**
     * Gets value by key from map
     */
    @Test
    public void testGet() {
        MyMap<String, Integer> map = new MyMap<>(16);
        map.put("color", 1);
        map.put("price", 1000);
        map.put("color", 7);
        map.put(null, 40);

        int value = map.get("color");

        assertEquals(7, value);
    }

    /**
     * Gets value by key from empty map. ArrayIndexOutOfBoundsException is expected
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testGetIsEmpty() {
        MyMap<String, Integer> map = new MyMap<>(16);
        map.get("color");
    }
}

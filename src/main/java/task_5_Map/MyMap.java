package task_5_Map;

import java.util.Objects;

/**
 * email : s.lakhmenev@andersenlab.com
 *
 * @author Lakhmenev Sergey
 * @version 1.1
 */
public class MyMap<K, V> implements MapInterface<K, V> {

    private Node<K, V>[] table;
    private int capacity;
    private int nullCounter;
    private int countItem;

    public MyMap(int capacity) {
        this.capacity = capacity;
        table = new Node[capacity];
    }

    /**
     * Put pair in the map. Pair with the same key will be overwritten
     *
     * @param key key of pair
     * @param value value of pair
     * @throws ArrayIndexOutOfBoundsException if map is full
     */
    @Override
    public void put(K key, V value) throws ArrayIndexOutOfBoundsException {

        if (isFull()) {
            throw new ArrayIndexOutOfBoundsException("Map is full");
        }

        int hash = hash(key);
        Node<K, V> newNode = new Node<>(hash, key, value, null);
        int index = hash & (capacity - 1);

        if (key == null) {
            nullCounter++;
        }

        if (nullCounter > 1) {
            throw new IllegalArgumentException("HashMap can keep only one null key");
        }

        if (table[index] == null) {
            table[index] = newNode;
            countItem++;
        } else {
            Node<K, V> currentNode = table[index];
            Node<K, V> prevNode = null;

            while (currentNode != null) {

                if (currentNode.key == null) {
                    table[index] = newNode;

                    if (nullCounter == 1) {
                        return;
                    }

                    countItem++;
                    return;
                }

                if (currentNode.key.equals(key)) {
                    if (prevNode == null) {
                        newNode.next = currentNode.next;
                        table[index] = newNode;
                        return;
                    } else {
                        prevNode.next = newNode;
                        return;
                    }
                } else {
                    prevNode = currentNode;
                    currentNode = currentNode.next;
                }
            }

            prevNode.next = newNode;
            countItem++;
        }
    }

    /**
     * Remove a pair from map by key
     *
     * @param key key of pair to bo deleted
     * @throws ArrayIndexOutOfBoundsException if map is empty
     */
    @Override
    public void remove(K key) throws ArrayIndexOutOfBoundsException {

        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("Map is empty");
        }

        int hash = hash(key);
        int index = hash & (capacity - 1);

        Node<K, V> currentNode = table[index];
        Node<K, V> prevNode = null;

        while (currentNode != null) {

            if (currentNode.key.equals(key)) {

                if (prevNode == null) {
                    table[index] = currentNode.next;
                    countItem--;
                    return;
                } else {
                    prevNode.next = currentNode.next;
                    countItem--;
                    return;
                }
            }

            prevNode = currentNode;
            currentNode = currentNode.next;
        }
    }

    /**
     * Display elements of specified Map
     */
    @Override
    public void printMap() {
        for (int i = 0; i < capacity; i++) {
            Node<K, V> node = table[i];

            while (node != null) {
                System.out.println(node);
                node = node.next;
            }
        }
    }

    /**
     * Returns value of pair by key
     *
     * @param key key of pair
     * @return value of pair
     * @throws ArrayIndexOutOfBoundsException if map is empty
     */
    @Override
    public V get(K key) throws ArrayIndexOutOfBoundsException {

        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("Map is empty");
        }

        int hash = hash(key);
        int index = hash & (capacity - 1);
        Node<K, V> node = table[index];

        while (node != null) {

            if (node.key.equals(key)) {
                return node.value;
            }

            node = node.next;
        }

        return null;
    }

    /**
     * Getting amount of pairs in the specified map
     *
     * @return amount of pairs in specified map
     */
    @Override
    public int size() {
        return countItem;
    }

    /**
     * This implementation returns true if specified map is null
     *
     * @return true if size == 0
     */
    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * This implementation returns true if specified map is full
     *
     * @return true if map is full
     */
    @Override
    public boolean isFull() {
        return countItem == capacity;
    }

    /**
     * Structure of pair array for map
     *
     * @param <K> key of pair
     * @param <V> value of pair
     */
    static class Node<K, V> implements MapInterface.Entry<K, V> {

        Node<K,V> next;
        final int hash;
        final K key;
        V value;

        public Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        /**
         * Getting value of pair
         *
         * @return value of pair
         */
        @Override
        public V getValue() {
            return value;
        }

        /**
         * Getting key of pair
         *
         * @return key of pair
         */
        @Override
        public K getKey() {
            return key;
        }

        /**
         * Returns a string with key and value of pair
         *
         * @return a string contains value and key of pair
         */
        @Override
        public String toString() {
            return key + " = " + value;
        }

        /**
         * Returns hashcode specified pair
         *
         * @return hashCode of pair object
         */
        @Override
        public final int hashCode() {
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }

        /**
         * Compare two objects with each other
         *
         * @param o the reference object with which to compare
         * @return true if both objects are equivalent
         */
        @Override
        public final boolean equals(Object o) {

            if (o == this)
                return true;

            if (o instanceof MapInterface.Entry) {
                MapInterface.Entry<?,?> e = (MapInterface.Entry<?,?>)o;

                if (Objects.equals(key, e.getKey()) &&
                        Objects.equals(value, e.getValue()))
                    return true;
            }

            return false;
        }
    }

    /**
     * Returns hash of object by key
     *
     * @param key key of object
     * @return hash of object by key
     */
    private int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
}

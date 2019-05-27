package task_5_Map;

/**
 * email : s.lakhmenev@andersenlab.com
 *
 * @author Lakhmenev Sergey
 * @version 1.1
 */
public interface MapInterface<K, V> {

    /**
     * Getting amount of pairs in the specified map
     *
     * @return amount of pairs in specified map
     */
    int size();

    /**
     * This implementation returns true if specified map is null
     *
     * @return true if size == 0
     */
    boolean isEmpty();

    /**
     * This implementation returns true if specified map is full
     *
     * @return true if map is full
     */
    boolean isFull();

    /**
     * Put pair in the map. Pair with the same key will be overwritten
     *
     * @param key key of pair
     * @param value value of pair
     * @throws ArrayIndexOutOfBoundsException if map is full
     */
    void put(K key, V value);

    /**
     * Returns value of pair by key
     *
     * @param key key of pair
     * @return value of pair
     * @throws ArrayIndexOutOfBoundsException if map is empty
     */
    V get(K key);

    /**
     * Remove a pair from map by key
     *
     * @param key key of pair to bo deleted
     * @throws ArrayIndexOutOfBoundsException if map is empty
     */
    void remove(K key);

    /**
     * Display elements of specified Map
     */
    void printMap();

    /**
     * Structure of pair array for map
     *
     * @param <K> key of pair
     * @param <V> value of pair
     */
    interface Entry<K, V> {

        /**
         * Getting value of pair
         *
         * @return value of pair
         */
        V getValue();

        /**
         * Getting key of pair
         *
         * @return key of pair
         */
        K getKey();

        /**
         * Returns a string with key and value of pair
         *
         * @return a string contains value and key of pair
         */
        String toString();
    }
}

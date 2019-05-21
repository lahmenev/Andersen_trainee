package task_2_Queue;

/**
 * email : s.lakhmenev@andersenlab.com
 *
 * @author Lakhmenev Sergey
 * @version 1.1
 */
public class MyQueue<T> {

    private T[] queue;
    private int capacity;
    private int count;
    private int takeIndex;
    private int putIndex;

    /**
     * Creates a queue with the given capacity
     *
     * @param capacity
     * @throws IllegalArgumentException if {@code capacity < 1}
     */
    public MyQueue(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity should be greater than 0");
        }
        this.capacity = capacity;
        queue = (T[]) new Object[capacity];
    }

    /**
     *Insert the specified element at the tail of this queue
     *
     * @param data the element to add
     * @throws NullPointerException if the specified element is null
     * @throws ArrayIndexOutOfBoundsException if this queue is full
     */
    public void add(T data) throws NullPointerException, ArrayIndexOutOfBoundsException {
        if (data == null) {
            throw new NullPointerException();
        }
        if (isFull()) {
            throw new ArrayIndexOutOfBoundsException("Current queue is full");
        }
        queue[putIndex] = data;
        putIndex = (putIndex + 1)%capacity;
        count++;
    }

    /**
     * Remove the element from the head of queue
     *
     * @throws IllegalStateException if the specified array is null
     */
    public void remove() throws IllegalStateException{
        if (isEmpty()) {
            throw new IllegalStateException("There are no elements in the queue");
        }
        queue[takeIndex] = null;
        takeIndex = (takeIndex + 1)%capacity;
        count--;
    }

    /**
     * Retrieving an element from the queue
     *
     * @return an element from head of queue
     * @throws IllegalStateException if the specified array is null
     */
    public T get() throws IllegalStateException {
        if (isEmpty()) {
            throw new IllegalStateException("There are no elements in the queue");
        }
        return queue[takeIndex];
    }

    /**
     * This implementation returns true if specified queue is null
     */
    private boolean isEmpty() {
        return (count == 0);
    }

    /**
     * This implementation returns true if specified queue is full
     */
    private boolean isFull() {
        return count == capacity;
    }

    /**
     * Display elements of specified queue including null elements
     */
    public void printQueue() {
        System.out.print("Elements : ");
        for (int i = 0; i < capacity; i++) {
            System.out.print(queue[(takeIndex + i)%5] + " ");
        }
    }

    /**
     * The current count of queue
     *
     * {@link MyQueue#count}
     */
    public int getCount() {
        return count;
    }
}

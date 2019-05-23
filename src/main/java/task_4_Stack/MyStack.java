package task_4_Stack;

/**
 * email : s.lakhmenev@andersenlab.com
 *
 * @author Lakhmenev Sergey
 * @version 1.1
 */
public class MyStack<T> implements MyList<T> {

    private T[] stackArray;
    private int capacity;
    private int top;

    /**
     * Creates the stack with the given capacity
     *
     * @param capacity the size of stack
     * @throws IllegalArgumentException if {@code capacity < 1}
     */
    public MyStack(int capacity) {

        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity should be greater than 0");
        }

        this.capacity = capacity;
        stackArray = (T[]) new Object[capacity];
    }

    /**
     * Looks at the object at the top of this stack without removing it
     * from the stack
     *
     * @throws IllegalStateException if there are no elements in the stack
     */
    @Override
    public T peek() throws IllegalStateException {

        if (isEmpty()) {
            throw new IllegalStateException("There are no elements in the stack");
        }

        return stackArray[top - 1];
    }

    /**
     * Pushes an item onto the top of this stack
     *
     * @param obj the item to be pushed onto this stack
     * @throws NullPointerException if the specified element is null
     * @throws IllegalStateException if current stack is full
     */
    @Override
    public void push(T obj) throws NullPointerException, IllegalStateException {

        if (obj == null) {
            throw new NullPointerException("Element must be not null");
        }

        if (isFull()) {
            throw new IllegalStateException("Current stack is full");
        }

        stackArray[top] = obj;
        top++;
    }

    /**
     * Removes the object at the top of this stack
     *
     * @throws IllegalStateException if there are no elements in the stack
     */
    @Override
    public void pop() throws IllegalStateException {

        if (isEmpty()) {
            throw new IllegalStateException("There are no elements in the stack");
        }

        stackArray[top - 1] = null;
        top--;
    }

    /**
     * Returns the size of list
     *
     * @return the size of list
     */
    @Override
    public int size() {
        return top;
    }

    /**
     * Returns true if specified stack is null
     *
     * @return true if specified stack is null
     */
    @Override
    public boolean isEmpty() {
        return top == 0;
    }

    /**
     * Returns true if specified stack is full
     *
     * @return true if specified stack is full
     */
    @Override
    public boolean isFull() {
        return top == capacity ;
    }

    /**
     * Display elements of specified stack including null elements
     */
    public void printStack() {
        System.out.print("Elements: ");

        for (int i = 0; i < capacity; i++) {
            System.out.print(stackArray[i] + " ");
        }
    }
}

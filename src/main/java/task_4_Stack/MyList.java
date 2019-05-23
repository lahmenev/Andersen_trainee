package task_4_Stack;

/**
 * email : s.lakhmenev@andersenlab.com
 *
 * @author Lakhmenev Sergey
 * @version 1.1
 */
public interface MyList<T> {

    /**
     * Looks at the object at the top of this stack without removing it
     * from the stack
     *
     * @throws IllegalStateException if there are no elements in the stack
     */
    T peek();

    /**
     * Push an item onto the top of this stack
     *
     * @param obj the item to be pushed onto this stack
     * @throws NullPointerException if the specified element is null
     * @throws IllegalStateException if current stack is full
     */
    void push(T obj);

    /**
     * Removes the object at the top of this stack
     *
     * @throws IllegalStateException if there are no elements in the stack
     */
    void pop();

    /**
     * Returns the size of list
     *
     * @return the size of list
     */
    int size();

    /**
     * Returns true if specified stack is null
     *
     * @return true if specified stack is null
     */
    boolean isEmpty();

    /**
     * Returns true if specified stack is full
     *
     * @return true if specified stack is full
     */
    boolean isFull();
}

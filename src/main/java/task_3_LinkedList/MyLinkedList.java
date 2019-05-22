package task_3_LinkedList;

import java.util.NoSuchElementException;

/**
 * email : s.lakhmenev@andersenlab.com
 *
 * @author Lakhmenev Sergey
 * @version 1.1
 */
public class MyLinkedList<T> {

    private int size;
    private Node<T> first;
    private Node<T> last;

    /**
     * Appends the specified element to the end of this list
     *
     * @param e element to be appended to this list
     */
    public void add(T e) {

        if (first == null) {
            Node<T> firstNode = new Node<>(null, e,null);
            first = last = firstNode;
        } else {
            Node<T> node = new Node<>(last, e, null);
            last.next = node;
            last = node;
        }

        size++;
    }

    /**
     * Inserts the specified element at the specified position in this list.
     *
     * @param index index at which the specified element is to be inserted
     * @param e element to be inserted
     * @throws IndexOutOfBoundsException if index >= size of list or if index < 0
     */
    public void add(int index, T e) throws IndexOutOfBoundsException {

        if ((index < 0) || (index > size)) {
            throw new IndexOutOfBoundsException("Index is: " + index + ", size is: " + size);
        }

        if (index == size) {
            add(e);
        } else {
            Node<T> prevNode = findNodeByIndex(index).prev;
            Node<T> nextNode = findNodeByIndex(index);
            Node<T> newNode = new Node<>(prevNode, e, nextNode);
            nextNode.prev = newNode;

            if (index == 0) {
                first = newNode;
            } else {
                prevNode.next = newNode;
            }
        }

        size++;
    }

    /**
     * Removes the last element from this list
     * @throws NoSuchElementException if list is empty
     */
    public void removeLast() throws NoSuchElementException {

        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }

        if (size == 1) {
            first = last = null;
            size = 0;
        } else {
            Node<T> prevNode = last.prev;
            prevNode.next = null;
            last = prevNode;
            size--;
        }
    }

    /**
     * Removes the element at the specified position in this list
     *
     * @param index the index of the element to be removed
     * @throws IndexOutOfBoundsException if index >= size of list or if index < 0
     */
    public void remove(int index) throws IndexOutOfBoundsException {
        Node<T> prevNode = findNodeByIndex(index).prev;
        Node<T> nextNode = findNodeByIndex(index).next;

        if ((index < 0) || (index >= size)) {
            throw new IndexOutOfBoundsException("Index is: " + index + ", size is: " + size);
        }

        if (size == 1) {
            first = last = null;
        } else if (index == (size - 1)) {
            last.prev.next = null;
            last = last.prev;
        } else {
            if (index == 0) {
                first = nextNode;
                nextNode.prev = null;
            } else {
                prevNode.next = nextNode;
                nextNode.prev = prevNode;
            }
        }

        size--;
    }

    /**
     * Removes specified element from list
     *
     * @param o element to be removed from this list, if present
     * @throws NoSuchElementException if list is empty
     * @throws IndexOutOfBoundsException if there is no such element in the list
     */
    public void remove(Object o) throws NoSuchElementException, IndexOutOfBoundsException {

        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }

        Node<T> delNode = findNodeByObj(o);

        if (delNode == null) {
            throw new IndexOutOfBoundsException("There is no such element");
        }

        Node<T> prevNode = delNode.prev;
        Node<T> nextNode = delNode.next;

        if (size == 1) {
            first = last = null;
        } else if (prevNode == null) {
            first = nextNode;
            nextNode.prev = null;
        } else if (nextNode == null) {
            last = prevNode;
            prevNode.next = null;
        } else {
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
        }

        size--;
    }

    /**
     * Getting last element from list
     *
     * @return the element at the specified position in this list
     * @throws NoSuchElementException if list is empty
     * @throws IndexOutOfBoundsException if index >= size of list or if index < 0
     */
    public T get() throws NoSuchElementException, IndexOutOfBoundsException {

        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }

        return last.item;
    }

    /**
     * Getting element by index from list
     *
     * @param index index of the element to return
     * @return the element at the specified position in this list
     * @throws NoSuchElementException if list is empty
     * @throws IndexOutOfBoundsException if index >= size of list or if index < 0
     */
    public T get(int index) throws NoSuchElementException, IndexOutOfBoundsException {

        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }

        if ((index < 0) || (index >= size)) {
            throw new IndexOutOfBoundsException("Index is: " + index + ", size is: " + size);
        }

        return findNodeByIndex(index).item;
    }

    /**
     * Display elements of specified LinkedList
     *
     */
    public void print() {
        Node<T> node = first;
        System.out.print("Elements: ");

        while (node != null) {
            System.out.print(node.item + " ");
            node = node.next;
        }
    }

    private static class Node<T> {
        T item;
        Node<T> next;
        Node<T> prev;

        Node(Node<T> prev, T element, Node<T> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    /**
     * Searching Node by index
     *
     * @param index the index of searching index
     * @return Returns the Node at the specified element index.
     */
    private Node<T> findNodeByIndex(int index) {
        Node<T> node;

        if (index < (size / 2)) {
            node = first;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }

            return node;
        } else {
            node = last;

            for (int i = size - 1; i > index; i--) {
                node = node.prev;
            }

            return node;
        }
    }

    /**
     * Searching Node by object
     *
     * @param o the object being searched
     * @return Returns the Node at the specified element
     */
    public Node<T> findNodeByObj(Object o) {
        Node<T> searchNode = null;

        for (Node<T> node = first; node != null; node = node.next) {

            if (o.equals(node.item)) {
                searchNode = node;
            }
        }

        return searchNode;
    }

    /**
     * This implementation returns true if specified list is null
     */
    private boolean isEmpty() {
        return size == 0;
    }

    /**
     * @return Returns the size of list
     */
    public int size() {
        return size;
    }
}

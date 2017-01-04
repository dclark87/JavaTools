package io.github.dclark87.javatools.linkedlists;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Linked List implementation
 *
 * @param <T>
 */
public class LinkedList<T> implements Iterable<T> {

    // Instance field - head of list
    private Node<T> head;

    /**
     * Constructor
     */
    public LinkedList() {
        head = null;
    }

    /**
     * Test if the linked list is empty
     *
     * @return true if list is empty, false otherwise
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     *
     * @param data data to add to the linked list
     */
    public void addFirst(T data) {
        head = new Node<T>(data, head);
    }

    /**
     *
     * @return data to get from head of linked list
     */
    public T getFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        return head.data;
    }

    /**
     * Iterator method implementation
     *
     * @return an iterable linked list
     */
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<T> {
        private Node<T> nextNode;

        public LinkedListIterator() {
            nextNode = head;
        }

        public boolean hasNext() {
            return nextNode != null;
        }

        public T next() {
            if (!hasNext()) throw new NoSuchElementException();
            T res = nextNode.data;
            nextNode = nextNode.next;
            return res;
        }

        public void remove() { throw new UnsupportedOperationException();}

    }

    /**
     * Node static nested class
     *
     * @param <T> the type of data to store in the node
     */
    private static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }
}

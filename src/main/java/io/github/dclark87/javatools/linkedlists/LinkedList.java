package io.github.dclark87.javatools.linkedlists;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Linked List implementation
 *
 * @param <T>
 */
public class LinkedList<T> implements Iterable<T> {

    private Node<T> head;

    /**
     *
     * @return
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
     * @param <T>
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

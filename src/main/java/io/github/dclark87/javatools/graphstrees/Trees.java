package io.github.dclark87.javatools.graphstrees;

import lombok.Data;

/**
 * Class for parsing and manipulating trees
 */
public class Trees {

    /**
     * Binary Tree Node class
     * @param <T> any type of data to store in tree
     */
    @Data
    public static class BinaryTreeNode<T> {
        private T data;
        private BinaryTreeNode<T> leftChild;
        private BinaryTreeNode<T> rightChild;

        /**
         * Constructor for node with data
         * @param data data payload to store in node
         */
        public BinaryTreeNode (T data) {
            this.data = data;
            this.leftChild = null;
            this.rightChild = null;
        }
    }

    /**
     * Binary tree class
     */
    public static class BinaryTree<T> {

        BinaryTreeNode<T> head;

        /**
         * Binary Tree empty constructor
         */
        BinaryTree() {
            this.head = null;
        }

        /**
         * Binary Tree single head node constructor
         * @param data data type to store in the head of the tree
         */
        BinaryTree(T data) {
            this.head = new BinaryTreeNode<T>(data);
        }
    }
}

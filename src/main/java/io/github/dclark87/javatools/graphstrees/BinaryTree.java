package io.github.dclark87.javatools.graphstrees;

import lombok.Data;

import java.util.NoSuchElementException;

/**
 * Binary tree class
 */
@Data
public class BinaryTree<T> {

    private T data;
    private BinaryTree<T> leftChild;
    private BinaryTree<T> rightChild;

    /**
     * Binary Tree single head node constructor
     *
     * @param data data type to store in the head of the tree
     */
    public BinaryTree(T data) {
        this.setData(data);
    }

    /**
     * Insert left child with data below specified root
     *
     * @param data payload to insert into tree at left child
     * @param rootVal data payload of subtree where to insert the child tree
     * @throws NoSuchElementException is thrown if a subtree with the
     * desired root value is not found
     */
    public void insertLeft(T data, T rootVal)
            throws NoSuchElementException {

        // Find subtree with root value
        BinaryTree<T> rootTree = findNode(rootVal);
        // Traversed tree and couldn't find rootVal, throw exception
        if (rootTree == null) {
            throw new NoSuchElementException();
        }

        // Init new left child
        BinaryTree<T> newLeft = new BinaryTree<T>(data);
        BinaryTree<T> oldLeft = rootTree.getLeftChild();
        // If the rootTree is not a leaf, save left child
        if (oldLeft != null) {
            newLeft.setLeftChild(oldLeft);
        }
        rootTree.setLeftChild(newLeft);
    }

    /**
     * Insert right child with data below specified root
     *
     * @param data payload to insert into tree at right child
     * @param rootVal data payload of subtree where to insert the child tree
     * @throws NoSuchElementException is thrown if a subtree with the
     * desired root value is not found
     */
    public void insertRight(T data, T rootVal)
            throws NoSuchElementException {

        // Find subtree with root value
        BinaryTree<T> rootTree = findNode(rootVal);
        // Traversed tree and couldn't find rootVal, throw exception
        if (rootTree == null) {
            throw new NoSuchElementException();
        }

        // Init new right child
        BinaryTree<T> newRight = new BinaryTree<T>(data);
        BinaryTree<T> oldRight = rootTree.getRightChild();
        // If the rootTree is not a leaf, save right child
        if (oldRight != null) {
            newRight.setRightChild(oldRight);
        }
        rootTree.setRightChild(newRight);
    }

    /**
     * Find the node given the provided data; works like a DFS where we
     * traverse left child until we hit a leaf, then we backtrack and check
     * the right child until we hit a leaf
     *
     * @param data subtree data payload to find
     * @return the sub-tree with the desired data payload
     */
    private BinaryTree<T> findNode(T data) {

        // If we found the node with the matching data, return the subtree
        if (this.getData().equals(data)) return this;

        // If there is a left child to go to, pursue it
        BinaryTree<T> thisLeftChild = this.getLeftChild();
        if (thisLeftChild != null) {
            BinaryTree<T> leftFound = thisLeftChild.findNode(data);
            if ((leftFound) != null) return leftFound;
        }
        // Hit a left node leaf, see if we can pursue right child
        BinaryTree<T> thisRightChild = this.getRightChild();
        if (thisRightChild != null) {
            BinaryTree<T> rightFound = thisRightChild.findNode(data);
            if (rightFound != null) return rightFound;
        }

        // Return null if we cannot find the data
        return null;
    }
}

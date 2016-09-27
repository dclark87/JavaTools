package io.github.dclark87.javatools.graphstrees;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test case for the Trees class
 */
public class TreesTest {

    /**
     * Test use of binary tree and nodes classes
     */
    @Test
    public void testBinaryTree() {
        // Test both constructors
        Trees.BinaryTree binaryTree = new Trees.BinaryTree<Integer>();
        binaryTree.head = new Trees.BinaryTreeNode<Integer>(0);
        Trees.BinaryTree binaryTree2 = new Trees.BinaryTree<Integer>(0);
        Assert.assertEquals(binaryTree.head.getData(), binaryTree2.head.getData());
    }
}

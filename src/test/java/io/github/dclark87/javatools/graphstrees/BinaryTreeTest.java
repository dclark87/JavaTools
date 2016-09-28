package io.github.dclark87.javatools.graphstrees;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.NoSuchElementException;

/**
 * Test case for the BinaryTree class
 */
public class BinaryTreeTest {
    private static final BinaryTree<String> binaryTree =
            new BinaryTree<String>("one");

    /**
     * Build the tree
     */
    @BeforeClass
    public static void setUp() {
        binaryTree.insertLeft("two", "one");
        binaryTree.insertRight("three", "one");
        binaryTree.insertLeft("four", "two");
        binaryTree.insertRight("five", "two");
        binaryTree.insertLeft("six", "three");
        binaryTree.insertRight("seven", "three");
    }

    /**
     * Test use of binary tree and nodes classes
     */
    @Test
    public void testBinaryTreeConstructors() {
        // Test both constructors
        Assert.assertEquals(binaryTree.getData(), "one");
    }

    /**
     * Test insert left node
     */
    @Test
    public void testBinaryTreeInsertLeft() {
        BinaryTree<Character> characterBinaryTree =
                new BinaryTree<Character>('a');
        characterBinaryTree.insertLeft('b', 'a');
        characterBinaryTree.insertLeft('c', 'b');
        Assert.assertEquals(characterBinaryTree.getData(), (Character) 'a');
        Assert.assertEquals(characterBinaryTree.getLeftChild().getData(),
                (Character) 'b');
        Assert.assertEquals(characterBinaryTree.getLeftChild().getLeftChild()
                .getData(), (Character) 'c');
    }

    /**
     * Test insert right node
     */
    @Test
    public void testBinaryTreeInsertRight() {
        BinaryTree<String> stringBinaryTree =
                new BinaryTree<String>("ayy");
        stringBinaryTree.insertRight("bee", "ayy");
        stringBinaryTree.insertRight("cee", "bee");
        Assert.assertEquals(stringBinaryTree.getData(), "ayy");
        Assert.assertEquals(stringBinaryTree.getRightChild().getData(), "bee");
        Assert.assertEquals(stringBinaryTree.getRightChild().getRightChild()
                .getData(), "cee");
    }

    /**
     * Assert we are generating an error when the root value cannot be found
     * in tree
     */
    @Test(expected = NoSuchElementException.class)
    public void testElementNotFound() {
        binaryTree.insertLeft("pi", "zero");
    }
}

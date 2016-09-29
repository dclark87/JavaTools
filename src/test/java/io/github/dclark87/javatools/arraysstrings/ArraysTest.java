package io.github.dclark87.javatools.arraysstrings;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class for the Arrays class
 */
public class ArraysTest {

    // Init variables
    private static final int[][] originalMatrix = {{1, 2, 3},
                                                   {4, 5, 6},
                                                   {7, 8, 9}};
    private static final int[][] rotatedMatrix = {{7, 4, 1},
                                                  {8, 5, 2},
                                                  {9, 6, 3}};

    /**
     * Test the rotate matrix method
     */
    @Test
    public void testRotateMatrix90DegreesClockwise() {
        Assert.assertArrayEquals(Arrays.rotateMatrix90DegreesClockwise(originalMatrix), rotatedMatrix);
    }

    /**
     * Test the rotate matrix method in place
     */
    @Test
    public void testRotateMatrix90DegreesClockwiseInPlace() {
        Arrays.rotateMatrix90DegreesClockwiseInPlace(originalMatrix);
        Assert.assertArrayEquals(originalMatrix, rotatedMatrix);
    }

    /**
     * Test we can rotate a simple array to the right by a number
     */
    @Test
    public void testRotateArrayRightByNum() {
        int[] testArr = {1,2,3,4,5,6,7};
        int[] shiftedArr = {5,6,7,1,2,3,4};
        int[] shiftedShiftedArr = {4,5,6,7,1,2,3};
        Arrays.rotateArrayRightByNum(testArr, 3);
        Assert.assertArrayEquals(shiftedArr, testArr);

        Arrays.rotateArrayRightByNum(shiftedArr, 8);
        Assert.assertArrayEquals(shiftedShiftedArr, shiftedArr);
    }
}
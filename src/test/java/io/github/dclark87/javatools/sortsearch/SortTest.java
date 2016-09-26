package io.github.dclark87.javatools.sortsearch;

import io.github.dclark.javatools.sortsearch.Sort;
import org.junit.Assert;
import org.junit.Test;

/**
 * Test the Sort class methods
 */
public class SortTest {

    // Declare an unsorted array
    private static Integer[] unsortedArray = {9,9,4,8,7,6,1,1,0,2,0,6};
    private static Integer[] sortedArray = {0,0,1,1,2,4,6,6,7,8,9,9};

    /**
     * Test the merge sort works properly
     */
    @Test
    public void testMergeSort() {
        Sort.mergeSort(unsortedArray);
        Assert.assertArrayEquals(unsortedArray, sortedArray);
    }
}

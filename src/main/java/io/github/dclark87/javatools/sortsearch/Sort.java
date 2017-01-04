package io.github.dclark87.javatools.sortsearch;

import java.util.Arrays;

/**
 * Class with sorting methods
 */
public class Sort {

    /**
     * Sort an array via the merge-sort algorithm
     *
     * @param array the unsorted array
     * @return the sorted array
     */
    public static Comparable[] mergeSort(Comparable[] array) {

        // If input is one or no elements, return list
        if (array.length <= 1) {
            return array;
        }

        // Split the array into two halves
        int midIdx = array.length/2;
        Comparable[] first = Arrays.copyOfRange(array, 0, midIdx);
        Comparable[] second = Arrays.copyOfRange(array, midIdx, array.length);

        // Recursively call to break into smaller pieces
        mergeSort(first);
        mergeSort(second);

        // Once we've got the first and second arrays sorted, iterate through them
        int firstIdx = 0;
        int secondIdx = 0;
        int mergedIdx = 0;

        while (firstIdx < first.length && secondIdx < second.length) {
            // If first half element is smaller, put that
            if (first[firstIdx].compareTo(second[secondIdx]) < 0) {
                array[mergedIdx] = first[firstIdx];
                firstIdx++;
            }
            else {
                array[mergedIdx] = second[secondIdx];
                secondIdx++;
            }
            mergedIdx++;
        }

        // Copy remainder of first and second lists into array (only one will have any copied in)
        System.arraycopy(first, firstIdx, array, mergedIdx, first.length-firstIdx);
        System.arraycopy(second, secondIdx, array, mergedIdx, second.length-secondIdx);

        // Return the sorted array
        return array;
    }
}

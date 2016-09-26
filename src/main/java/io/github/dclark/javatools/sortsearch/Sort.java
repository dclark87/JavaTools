package io.github.dclark.javatools.sortsearch;

/**
 * Created by Danny on 9/25/16.
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
        Comparable[] first = new Comparable[array.length/2];
        Comparable[] second = new Comparable[array.length-first.length];

    }
}

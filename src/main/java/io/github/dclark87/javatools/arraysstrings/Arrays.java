package io.github.dclark87.javatools.arraysstrings;

/**
 * Class with Array methods
 */
public class Arrays {

    /**
     * Rotate a matrix of integers by 90 degrees clockwise
     *
     * @param matrix an integer array of arrays
     * @return the rotate integer array of arrays
     */
    public static int[][] rotateMatrix90DegreesClockwise(int[][] matrix) {

        // Get matrix dims
        int rows = matrix.length;
        int cols = matrix[0].length;

        // Trivial edge case of single element
        if (rows < 2 && cols < 2) return matrix;

        // Iterate through input and store in rotated output
        int[][] rotated = new int[cols][rows];
        for (int i = 0; i < rows; ++i) {
            int last = cols-1 - i;
            for (int j = 0; j < cols; ++j) {
                rotated[j][last] = matrix[i][j];
            }
        }
        return rotated;
    }

    /**
     * Method to rotate a matrix 90 degrees clockwise in place
     *
     * @param matrix the matrix to rotate
     */
    public static void rotateMatrix90DegreesClockwiseInPlace(int[][] matrix) {

        // Make sure matrix is square
        if (matrix.length != matrix[0].length) {
            throw new IllegalArgumentException("Input matrix must be square!");
        }

        int n = matrix.length;
        // Trivial edge case of single element
        if (n < 2) return;

        // For each ring layer
        for (int layer = 0; layer < n/2; ++layer) {
            int first = layer;
            int last = n-1 - layer;
            // For each element in side of ring
            for (int i = first; i < last; ++i) {
                // Store upper left
                int tmp = matrix[first][i];
                int offset = i-first;

                // Lower left to upper left (rows decrease, cols stay)
                matrix[first][i] = matrix[last-offset][first];
                // Lower right to lower left (rows stay, cols decrease)
                matrix[last-offset][first] = matrix[last][last-offset];
                // Upper right to lower right (rows stay, cols decrease)
                matrix[last][last-offset] = matrix[i][last];
                // Upper left to upper right (rows increase, cols stay)
                matrix[i][last] = tmp;
            }
        }
    }

    /**
     * Reverse an array in-place between (inclusive) the two indices
     * @param array array to reverse
     * @param first first index to begin reverse at, inclusive
     * @param last last index to begin reverse at, inclusive
     */
    private static void reverseArray(int[] array, int first, int last) {
        while (first < last) {
            int temp = array[last];
            array[last] = array[first];
            array[first] = temp;
            first++;
            last--;
        }
    }

    /**
     * Rotate an array, in place, by a given amount
     *
     * @param array the array to rotate
     * @param shift the amount to rotate by
     */
    public static void rotateArrayRightByNum(int[] array, int shift) {
        if (shift == array.length) return;
        if (shift > array.length) {
            shift = shift % array.length;
        }
        int index = array.length-shift;
        reverseArray(array, index, array.length-1);
        reverseArray(array, 0, index-1);
        reverseArray(array, 0, array.length-1);
    }
}
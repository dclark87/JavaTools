package io.github.dclark87.javatools.puzzles;

/**
 * Alphabet character combos
 */
public class AlphaCombos {

    public static final int ASCII_OFFSET = 65;

    /**
     * Print sets of letters
     * @param n print up to n successive letters
     */
    public static void printCombos(int n) {
        int j, k;
        int max = 0;

        // Calculate size of max number to iterate to
        for (int m =n; m > 0; --m) {
            max += (int) Math.pow(26, m);
        }

        // Iterate through up to max
        for (int i=0; i < max; ++i) {
            j = i;
            String out = "";
            // LSB first, then divide and decrement j
            while (j >= 0) {
                k = j % 26;
                out = (char) (k + ASCII_OFFSET) + out;
                j = j/26-1;
            }
            System.out.println(out);
        }
    }
}

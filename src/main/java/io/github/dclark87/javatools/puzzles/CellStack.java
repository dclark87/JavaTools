package io.github.dclark87.javatools.puzzles;

/**
 * |4
 * |2 5
 * |1 3 6
 * -------
 * Coordinate game
 */
public class CellStack {

    /**
     * Main method to return the number of passed-in coords
     *
     * @param x horizontal coordinate, starting at 1
     * @param y vertical coordinate, starting at 1
     * @return integer at location of coordinates
     */
    public static int main(int x, int y) {
        // Init variables
        int num = 1;
        int ybeg;
        int yy;
        int xx;

        // Iterate through horizontal coordinates
        for (xx = 2; xx < x + 1; xx++) {
            num += xx;
        }

        // Init y begining point
        if (x > 1) {
            ybeg = xx-1;
        } else ybeg = 1;

        // Iterate through vertical coordinates
        for (yy=ybeg; yy < ybeg+y-1; yy++) {
            num += yy;
        }

        // Return the number found
        return num;
    }
}

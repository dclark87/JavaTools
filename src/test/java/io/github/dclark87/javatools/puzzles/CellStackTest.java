package io.github.dclark87.javatools.puzzles;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test case for the cell stack coordinate puzzle
 */
public class CellStackTest {

    /**
     * Assert the main method is working as expected
     */
    @Test
    public void testMain() {
        Assert.assertEquals(1, CellStack.main(1, 1));
        Assert.assertEquals(15, CellStack.main(5, 1));
        Assert.assertEquals(11, CellStack.main(1, 5));
        Assert.assertEquals(18, CellStack.main(3, 4));
    }
}

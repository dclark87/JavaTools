package io.github.dclark87.javatools.puzzles;

import org.junit.Assert;
import org.junit.Test;

/**
 * Alphabet character combos test case
 */
public class AlphaCombosTest {

    @Test
    public void testAlphaCombos() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i=0; i < 26; ++i) {
            stringBuilder.append(Character.toChars(i+AlphaCombos.ASCII_OFFSET));
            stringBuilder.append("\n");
        }
        String outString = stringBuilder.toString();
        String combos = AlphaCombos.printCombos(1);
        Assert.assertEquals(outString, combos);
    }
}

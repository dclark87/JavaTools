package io.github.dclark87.javatools.arraysstrings;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class for the Strings class
 */
public class StringsTest {

    // Init variables
    private final String nonDupsString = "abcde";
    private final String dupsString = "aabbccddee";

    /**
     * Test string has all unique characters using hash map method
     */
    @Test
    public void testHasAllUniqueCharsHashMap() {
        Assert.assertTrue(Strings.hasAllUniqueCharsHashMap(nonDupsString));
        Assert.assertFalse(Strings.hasAllUniqueCharsHashMap(dupsString));
    }

    /**
     * Test string has all unique characters using bit mask method
     */
    @Test
    public void hasAllUniqueCharsBitMask() {
        Assert.assertTrue(Strings.hasAllUniqueCharsBitMask(nonDupsString));
        Assert.assertFalse(Strings.hasAllUniqueCharsBitMask(dupsString));
    }
}
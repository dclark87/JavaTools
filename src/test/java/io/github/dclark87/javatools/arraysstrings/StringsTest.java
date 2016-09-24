package io.github.dclark87.javatools.arraysstrings;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
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
    public void testHasAllUniqueCharsBitMask() {
        Assert.assertTrue(Strings.hasAllUniqueCharsBitMask(nonDupsString));
        Assert.assertFalse(Strings.hasAllUniqueCharsBitMask(dupsString));
    }

    /**
     * Test method removes duplicate characters
     */
    @Test
    public void testRemoveDupCharsFromString() {
        int nonDupsLength = nonDupsString.length();

        // Call method and assert size hasn't changed
        Strings.removeDupCharsFromString(nonDupsString);
        Assert.assertEquals(nonDupsLength, nonDupsString.length());

        // Call method and assert size has changed
        Strings.removeDupCharsFromString(dupsString);
        Assert.assertEquals(dupsString.length(), 5);
    }
}
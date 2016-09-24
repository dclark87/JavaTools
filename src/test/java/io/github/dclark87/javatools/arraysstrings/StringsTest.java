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
     * Test method removes duplicate characters with sub-string method
     */
    @Test
    public void testRemoveDupeCharsFromString() {
        // Call method and assert size hasn't changed
        String dupesNeedNotRemoved = Strings.removeDupeCharsFromString(nonDupsString);
        Assert.assertEquals(dupesNeedNotRemoved.length(), nonDupsString.length());

        // Call method and assert size has changed
        String dupesNeedRemoved = Strings.removeDupeCharsFromString(dupsString);
        Assert.assertEquals(dupesNeedRemoved.length(), 5);
    }

    /**
     * Test method removes duplicate characters with bit-mask method
     */
    @Test
    public void testRemoveDupeCharsFromString2() {
        // Call method and assert size hasn't changed
        String dupesNeedNotRemoved = Strings.removeDupeCharsFromString2(nonDupsString);
        Assert.assertEquals(dupesNeedNotRemoved.length(), nonDupsString.length());

        // Call method and assert size has changed
        String dupesNeedRemoved = Strings.removeDupeCharsFromString2(dupsString);
        Assert.assertEquals(dupesNeedRemoved.length(), 5);    }
}
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
    private static final String nonDupesString = "abcde";
    private static final String dupesString = "aabbccddee";

    /**
     * Test string has all unique characters using hash map method
     */
    @Test
    public void testHasAllUniqueCharsHashMap() {
        Assert.assertTrue(Strings.hasAllUniqueCharsHashMap(nonDupesString));
        Assert.assertFalse(Strings.hasAllUniqueCharsHashMap(dupesString));
    }

    /**
     * Test string has all unique characters using bit mask method
     */
    @Test
    public void testHasAllUniqueCharsBitMask() {
        Assert.assertTrue(Strings.hasAllUniqueCharsBitMask(nonDupesString));
        Assert.assertFalse(Strings.hasAllUniqueCharsBitMask(dupesString));
    }

    /**
     * Test method removes duplicate characters with sub-string method
     */
    @Test
    public void testRemoveDupeCharsFromString() {
        // Call method and assert size hasn't changed
        String dupesNeedNotRemoved = Strings.removeDupeCharsFromString(nonDupesString);
        Assert.assertEquals(dupesNeedNotRemoved.length(), nonDupesString.length());

        // Call method and assert size has changed
        String dupesNeedRemoved = Strings.removeDupeCharsFromString(dupesString);
        Assert.assertEquals(dupesNeedRemoved.length(), 5);
    }

    /**
     * Test method removes duplicate characters with bit-mask method
     */
    @Test
    public void testRemoveDupeCharsFromString2() {
        // Call method and assert size hasn't changed
        String dupesNeedNotRemoved = Strings.removeDupeCharsFromString2(nonDupesString);
        Assert.assertEquals(dupesNeedNotRemoved.length(), nonDupesString.length());

        // Call method and assert size has changed
        String dupesNeedRemoved = Strings.removeDupeCharsFromString2(dupesString);
        Assert.assertEquals(dupesNeedRemoved.length(), 5);
    }

    /**
     * Test method correctly determines if two strings are anagrams or not
     */
    @Test
    public void testAreStringsAnagrams() {
        final String anagramStr1 = "mississippi";
        final String anagramStr2 = "pipsissisim";
        final String nonAnagramStr3 = "missississi";
        Assert.assertTrue(Strings.areStringsAnagrams(anagramStr1, anagramStr2));
        Assert.assertFalse(Strings.areStringsAnagrams(anagramStr1, nonAnagramStr3));
        Assert.assertFalse(Strings.areStringsAnagrams(anagramStr1, nonDupesString));
    }

    /**
     * Test method correctly replaces all spaces in a string with '%20'
     */
    @Test
    public void testReplaceSpacesInString() {
        final String stringWithSpaces = "hi there homeSlice!";
        final String stringWithoutSpaces = "hi%20there%20homeSlice!";

        Assert.assertEquals(Strings.replaceSpacesInString(stringWithoutSpaces), stringWithoutSpaces);
        Assert.assertEquals(Strings.replaceSpacesInString(stringWithSpaces), stringWithoutSpaces);
    }
}
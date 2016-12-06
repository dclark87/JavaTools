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
        String dupesNeedNotRemoved =
                Strings.removeDupeCharsFromString(nonDupesString);
        Assert.assertEquals(dupesNeedNotRemoved.length(),
                nonDupesString.length());

        // Call method and assert size has changed
        String dupesNeedRemoved =
                Strings.removeDupeCharsFromString(dupesString);
        Assert.assertEquals(5, dupesNeedRemoved.length());
    }

    /**
     * Test method removes duplicate characters with bit-mask method
     */
    @Test
    public void testRemoveDupeCharsFromString2() {
        // Call method and assert size hasn't changed
        String dupesNeedNotRemoved =
                Strings.removeDupeCharsFromString2(nonDupesString);
        Assert.assertEquals(nonDupesString.length(),
                dupesNeedNotRemoved.length());

        // Call method and assert size has changed
        String dupesNeedRemoved =
                Strings.removeDupeCharsFromString2(dupesString);
        Assert.assertEquals(5, dupesNeedRemoved.length());
    }

    /**
     * Test method correctly determines if two strings are anagrams or not
     */
    @Test
    public void testAreStringsAnagrams() {
        final String anagramStr1 = "mississippi";
        final String anagramStr2 = "pipsissisim";
        final String nonAnagramStr3 = "missississi";
        Assert.assertTrue(Strings.areStringsAnagrams(anagramStr1,
                anagramStr2));
        Assert.assertFalse(Strings.areStringsAnagrams(anagramStr1,
                nonAnagramStr3));
        Assert.assertFalse(Strings.areStringsAnagrams(anagramStr1,
                nonDupesString));
    }

    /**
     * Test method correctly replaces all spaces in a string with '%20'
     */
    @Test
    public void testReplaceSpacesInString() {
        final String stringWithSpaces = "hi there homeSlice!";
        final String stringWithoutSpaces = "hi%20there%20homeSlice!";

        Assert.assertEquals(stringWithoutSpaces,
                Strings.replaceSpacesInString(stringWithoutSpaces));
        Assert.assertEquals(stringWithoutSpaces,
                Strings.replaceSpacesInString(stringWithSpaces));
    }

    /**
     * Test method reverses words order
     */
    @Test
    public void testReverseWordsInString() {
        final String testStr1 = "what is up?";
        final String testStr2 = "howdy ho neighbor! great day homer!";

        Assert.assertEquals("up? is " + "what",
                Strings.reverseWordsInString(testStr1));
        Assert.assertEquals("homer! day great neighbor! ho howdy",
                Strings.reverseWordsInString(testStr2));
    }

    /**
     * Test that we can reverse a string successfully
     */
    @Test
    public void testReverseString() {
        final String testStr1 = "racecar";
        final String testStr2 = "abcdefg";

        Assert.assertEquals(testStr1, Strings.reverseString(testStr1));
        Assert.assertEquals("gfedcba", Strings.reverseString(testStr2));
    }

    @Test
    public void testFindLargestPalindrome() {
        final String testStr1 = "a";
        final String testStr2 = "aba";
        final String testStr3 = "bbaa";
        final String testStr4 = "accbracecarccabbab";

        Assert.assertEquals(testStr1, Strings.findLargestPalindrome(testStr1));
        Assert.assertEquals(testStr2, Strings.findLargestPalindrome(testStr2));
        Assert.assertEquals("bb", Strings.findLargestPalindrome(testStr3));
        Assert.assertEquals("racecar", Strings.findLargestPalindrome(testStr4));
    }
}
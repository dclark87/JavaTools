package io.github.dclark87.javatools.arraysstrings;

import java.util.HashMap;
import java.util.Map;

/**
 * Class with string methods
 */
public class Strings {

    /**
     * Method to test if a string has all unique characters using a HashMap
     *
     * @param string string to test for uniqueness
     * @return boolean
     */
    public static boolean hasAllUniqueCharsHashMap(String string) {
        // Init a new hash map
        Map<Character, Integer> charCountMap = new HashMap<Character, Integer>();

        // Iterate through the characters of string
        for (int i = 0; i < string.length(); i++) {
            char charInString = string.charAt(i);
            if (charCountMap.containsKey(charInString)) {
                return false;
            } else {
                charCountMap.put(charInString, 1);
            }
        }
        return true;
    }

    /**
     * Method to test if a string has all unique characters using a HashMap
     *
     * @param string string to test for uniqueness
     * @return boolean
     */
    public static boolean hasAllUniqueCharsBitMask(String string) {

        // If the string has greater than unique ASCII chars, return false
        if (string.length() > 128) {
            return false;
        }

        // Init bit mask
        int bitMaskChecker = 0;

        // Iterate through the characters of string
        for (int i = 0; i < string.length(); i++) {

            // Convert character to integer
            int val = Character.getNumericValue(string.charAt(i));
            int charBitMask = 1 << val;

            // If 1's match up in bit mask - it's not unique
            if ((bitMaskChecker & charBitMask) > 0) return false;
            // Otherwise, update bit mask
            bitMaskChecker |= charBitMask;
        }
        return true;
    }

    /**
     * Remove all duplicate characters of a string using sub-strings
     *
     * @param string string to make unique chars of
     */
    public static String removeDupeCharsFromString(String string) {
        StringBuilder noDupes = new StringBuilder();
        for (int i = 0; i < string.length(); ++i) {
            String subString = string.substring(i, i + 1);
            if (noDupes.indexOf(subString) == -1) {
                noDupes.append(subString);
            }
        }
        return noDupes.toString();
    }

    /**
     * Remove all duplicate characters of a string using bit-masks
     *
     * @param string string to make unique chars of
     * @return
     */
    public static String removeDupeCharsFromString2(String string) {
        // Init bit mask and string builder
        int bitMask = 0;
        StringBuilder noDupes = new StringBuilder();

        // Iterate through each character of input
        for (int i = 0; i < string.length(); ++i) {
            char stringChar = string.charAt(i);
            int charMask = 1 << (int) stringChar;
            // If character wasn't found at location in bitmask
            if ((bitMask & charMask) == 0) {
                // Add char to bitmask and string builder
                bitMask |= charMask;
                noDupes.append(stringChar);
            }
        }
        return noDupes.toString();
    }
}
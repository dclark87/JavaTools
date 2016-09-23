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
}
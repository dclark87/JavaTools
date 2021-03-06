package io.github.dclark87.javatools.arraysstrings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

/**
 * Class with String methods
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
        HashMap<Character, Boolean> charCountMap = new HashMap<Character, Boolean>();

        // Iterate through the characters of string
        for (int i = 0; i < string.length(); i++) {
            char charInString = string.charAt(i);
            if (charCountMap.containsKey(charInString)) {
                return false;
            } else {
                charCountMap.put(charInString, true);
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

    /**
     * Method to decide if two strings are anagrams or not
     *
     * @param str1 first string
     * @param str2 second string
     * @return true if the strings are anagrams, false otherwise
     */
    public static boolean areStringsAnagrams(String str1, String str2) {

        // Trivial edge case
        if (str1.length() != str2.length()) return false;

        HashMap<Character, Integer> str1Map = new HashMap<Character, Integer>();

        // Iterate through first string and build a hash map
        for (Character c1 : str1.toCharArray()) {
            if (str1Map.containsKey(c1)) {
                str1Map.put(c1, str1Map.get(c1)+1);
            }
            else {
                str1Map.put(c1, 1);
            }
        }

        // Iterate through second string and decrement from found entries to be 0
        for (Character c2 : str2.toCharArray()) {
            if (!str1Map.containsKey(c2)) return false;
            str1Map.put(c2, str1Map.get(c2)-1);
        }

        // Test all entries are 0
        for (Integer cnt : str1Map.values()) {
            if (cnt != 0) return false;
        }

        // Made it through all the tests, must be anagrams
        return true;
    }

    /**
     * Method to replace all spaces in a string with '20%'
     *
     * @param str string with spaces to replace
     * @return string with replaced spaces
     */
    public static String replaceSpacesInString(String str) {
        if (!str.contains(" ")) return str;

        StringBuilder strBuilder = new StringBuilder();

        int spaceInteger = (int) ' ';
        for (char c : str.toCharArray()) {
            if ((int) c == spaceInteger) {
                strBuilder.append("%20");
            }
            else {
                strBuilder.append(c);
            }
        }

        return strBuilder.toString();
    }

    /**
     * Reverse the words in a string
     *
     * @param str string to reverse words of
     * @return the word-reversed string
     */
    public static String reverseWordsInString(String str) {
        // Trivial case
        if (!str.contains(" ")) return str;

        // Push words onto stack
        Stack<String> wordStack = new Stack<String>();
        int j = 0;
        for (int i = 0; i < str.length(); ++i) {
            // If we found a space, push word onto stack
            if (str.charAt(i) == ' ') {
                String word = str.substring(j, i);
                wordStack.push(word);
                j = i+1;
            }
            // If we're at end of string, push last word onto stack
            else if (i == str.length()-1) {
                String word = str.substring(j, i+1);
                wordStack.push(word);
            }
        }

        // Pop words off of stack
        StringBuilder backWords = new StringBuilder();
        while (wordStack.size() > 1) {
            backWords.append(wordStack.pop());
            backWords.append(' ');
        }
        backWords.append(wordStack.pop());

        return backWords.toString();
    }

    /**
     * Reverse a string
     * @param str string to reverse the characters of
     * @return the reversed string
     */
    public static String reverseString(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = str.length() - 1; i > -1; --i) {
            stringBuilder.append(str.charAt(i));
        }
        return stringBuilder.toString();
    }

    /**
     * Find the largest palindrome of a string
     *
     * @param str
     * @return
     */
    public static String findLargestPalindrome(String str) {
        String testStr = str.substring(0);
        ArrayList<String> palindromes = new ArrayList<String>();
        int i = 0;

        // While counter is less than the string length
        while (i < str.length()) {
            String revStr = reverseString(testStr);
            // If the test string is a palindrome, store and reset test to be
            // start at next character of input to end
            if (revStr.equals(testStr) || testStr.length() < 2) {
                palindromes.add(testStr);
                ++i;
                testStr = str.substring(i, str.length());
            }
            // Not a palindrome, see if the testStr[:-1] is a palindrome
            else {
                testStr = testStr.substring(0, testStr.length()-1);
            }
        }

        // Get largest element
        String largest = palindromes.get(0);
        for (i=1; i < palindromes.size(); ++i) {
            if (largest.length() < palindromes.get(i).length()) {
                largest = palindromes.get(i);
            }
        }
        return largest;
    }
}
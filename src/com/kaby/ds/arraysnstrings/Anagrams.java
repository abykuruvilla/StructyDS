package com.kaby.ds.arraysnstrings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Anagrams {


    /**
     * Write a function, anagrams, that takes in two strings as arguments.
     * The function should return a boolean indicating whether or not the strings are anagrams.
     * Anagrams are strings that contain the same characters, but in any order.
     * @param args
     */
    public static void main(String[] args) {

        System.out.println("restful and fluster are anagrams! : Expected = true; Actual = " + isAnagram("restful", "fluster"));
        System.out.println("restful and fluster are anagrams! : Expected = true; Actual = " + isAnagramSorting("restful", "fluster"));
        System.out.println("cats and tocs are not anagrams! : Expected = false; Actual = " + isAnagram("cats", "tocs"));
        System.out.println("cats and tocs are not anagrams! : Expected = false; Actual = " + isAnagramSorting("cats", "tocs"));

    }

    private static boolean isAnagram(String string1, String string2) {

        // if the strings are different sizes return false
        if(string1.length() != string2.length()) {
            return false;
        }

        // Store the character count of each character in each string in two maps
        Map<Character, Integer> charCountStr1 = new HashMap<>();
        Map<Character, Integer> charCountStr2 = new HashMap<>();

        for(int i = 0; i < string1.length(); i++) {
            if(charCountStr1.containsKey(string1.charAt(i))) {
                int count = charCountStr1.get(string1.charAt(i));
                charCountStr1.put(string1.charAt(i), count++);
            } else {
                charCountStr1.put(string1.charAt(i), 1);
            }
        }

        for(int j = 0; j < string2.length(); j++) {
            if(charCountStr2.containsKey(string2.charAt(j))) {
                int count = charCountStr2.get(string2.charAt(j));
                charCountStr2.put(string2.charAt(j), count++);
            } else {
                charCountStr2.put(string2.charAt(j), 1);
            }
        }

        // If the hashmaps are equal return true
        if(charCountStr1.equals(charCountStr2)) {
            return true;
        }

        return false;
    }

    public static boolean isAnagramSorting(String str1, String str2) {
        // Sort the characters of both strings and check to see if they are equal
        char[] char1 = str1.toCharArray();
        char[] char2 = str2.toCharArray();
        Arrays.sort(char1);
        Arrays.sort(char2);
        String sortedString1 = new String(char1);
        String sortedString2 = new String(char2);

        if(sortedString1.equals(sortedString2)) {
            return true;
        }

        return false;

    }
}

package com.kaby.ds.recursion;

import com.kaby.ds.helper.ResultPair;

public class ReverseStringRecursive {

    /**
     * Write a function, reverse_string, that takes in a string as an argument.
     * The function should return the string with its characters in reverse order. You must do this recursively.
     *
     * @param args
     */
    public static void main(String[] args) {

        String result0 = reverseString("hello");       // -> "olleh"
        ResultPair<String, String> resultPair0 = new ResultPair<>("Reverse of string is ", "olleh", result0);
        resultPair0.assertMatch();
        
        String result1 = reverseString("stopwatch");   // -> "hctawpots"
        ResultPair<String, String> resultPair1 = new ResultPair<>("Reverse of string is ", "hctawpots", result1);
        resultPair1.assertMatch();
        
        String result2 = reverseString("");            // -> ""
        ResultPair<String, String> resultPair2 = new ResultPair<>("Reverse of string is ", "", result2);
        resultPair2.assertMatch();

    }

    private static String reverseString(String str) {

        // Base case: if the string is empty, then we return an empty string
        if(str.isEmpty()) {
            return "";
        }

        // Recursive case: if the string has more than one character,
        // then we add the last character to the rest of the string and call the function recursively
        return reverseString(str.substring(1)) + str.charAt(0);
    }
}

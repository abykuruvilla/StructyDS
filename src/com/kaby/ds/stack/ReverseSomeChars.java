package com.kaby.ds.stack;

import com.kaby.ds.helper.ResultPair;

import java.util.List;
import java.util.Stack;

public class ReverseSomeChars {


    /**
     * Write a function, reverse_some_chars, that takes in string and an list of characters.
     * The function should return the string with the order of the given characters in reverse.
     * @param args
     */
    public static void main(String[] args) {

        // == test0 ==
        String result0 = reverseSomeChars("computer", List.of('a', 'e', 'i', 'o', 'u')); // -> 'cemputor'
        ResultPair<String, String> resultPair0 = new ResultPair<>("Reversing chars of computer", "cemputor", result0);
        resultPair0.assertMatch();

        // == test1 ==
        String result1 = reverseSomeChars("skateboard", List.of('a', 'e', 'i', 'o', 'u'));  // -> 'skatobeard'
        ResultPair<String, String> resultPair1 = new ResultPair<>("Reversing chars of skateboard", "skatobeard", result1);
        resultPair1.assertMatch();

        // == test2 ==
        String result2 = reverseSomeChars("airplane", List.of('m', 'n', 'r'));  // -> 'ainplare'
        ResultPair<String, String> resultPair2 = new ResultPair<>("Reversing chars of airplane", "ainplare", result2);
        resultPair2.assertMatch();

    }

    /**
     * Reverses the positions of specified characters in the input string.
     *
     * @param input The original string.
     * @param charsToReverse A list of characters whose positions should be reversed.
     * @return A new string with specified characters reversed in position.
     */
    public static String reverseSomeChars(String input, List<Character> charsToReverse) {

        // Convert the input string to an array of characters
        char[] sArray = input.toCharArray();

        // Stack to save the characters to be reversed
        Stack<Character> stack = new Stack<>();

        // First pass: Push characters to be reversed onto the Stack
        for (char c : sArray) {
            if (charsToReverse.contains(c)) {
                stack.push(c);
            }
        }

        // Second pass: Reverse matching characters in the input string with popped characters from the Stack
        for (int i = 0; i < sArray.length; i++) {
            if (charsToReverse.contains(sArray[i])) {
                sArray[i] = stack.pop();
            }
        }

        return new String(sArray);
    }

}

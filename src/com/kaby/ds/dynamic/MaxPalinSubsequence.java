package com.kaby.ds.dynamic;

import com.kaby.ds.helper.ResultPair;

import java.util.HashMap;

public class MaxPalinSubsequence {

    /**
     * Write a function, maxPalinSubsequence, that takes in a string as an argument.
     * The function should return the length of the longest subsequence of the string that is
     * also a palindrome.
     *
     * A subsequence of a string can be created by deleting any characters of the string,
     * while maintaining the relative order of characters.
     * @param args
     */
    public static void main(String[] args) {

        // == test_00: ==

        int result0 = maxPalinSubsequence("luwxult"); // -> 5
        ResultPair<Integer, Integer> resultPair0 = new ResultPair<>("Max Palindromic Subsequence ", 5, result0);
        resultPair0.printResultPair();

        // == test_01: ==

        int result1 = maxPalinSubsequence("xyzaxxzy"); // -> 6
        ResultPair<Integer, Integer> resultPair1 = new ResultPair<>("Max Palindromic Subsequence ", 6, result1);
        resultPair1.printResultPair();

        // == test_02: ==

        int result2 = maxPalinSubsequence("lol"); // -> 3
        ResultPair<Integer, Integer> resultPair2 = new ResultPair<>("Max Palindromic Subsequence ", 3, result2);
        resultPair2.printResultPair();

        // == test_03: ==

        int result3 = maxPalinSubsequence("boabcdefop"); // -> 3
        ResultPair<Integer, Integer> resultPair3 = new ResultPair<>("Max Palindromic Subsequence ", 3, result3);
        resultPair3.printResultPair();

        // == test_04: ==

        int result4 = maxPalinSubsequence("z"); // -> 1
        ResultPair<Integer, Integer> resultPair4 = new ResultPair<>("Max Palindromic Subsequence ", 1, result4);
        resultPair4.printResultPair();

        // == test_05: ==

        int result5 = maxPalinSubsequence("chartreusepugvicefree"); // -> 7
        ResultPair<Integer, Integer> resultPair5 = new ResultPair<>("Max Palindromic Subsequence ", 7, result5);
        resultPair5.printResultPair();

        // == test_06: ==

        int result6 = maxPalinSubsequence("qwueoiuahsdjnweuueueunasdnmnqweuzqwerty"); // -> 15
        ResultPair<Integer, Integer> resultPair6 = new ResultPair<>("Max Palindromic Subsequence ", 15, result6);
        resultPair6.printResultPair();

        // == test_07: ==

        int result7 = maxPalinSubsequence("enamelpinportlandtildecoldpressedironyflannelsemioticsedisonbulbfashionaxe"); // -> 31
        ResultPair<Integer, Integer> resultPair7 = new ResultPair<>("Max Palindromic Subsequence ", 31, result7);
        resultPair7.printResultPair();

    }

    // To reduce complexity(copying strings) related to doing a substring it is better to pass around substring start and end indexes
    private static int maxPalinSubsequence(String str) {
//        return maxPalinSubsequenceBF(str, 0, str.length() - 1);
        return maxPalinSubsequenceMemoized(str, 0, str.length() - 1, new HashMap<String, Integer>());
    }

    private static int maxPalinSubsequenceMemoized(String str, int startId, int endId, HashMap<String, Integer> memo) {
        // The key to the memo is a combination of the start and end index
        String key = startId + "," + endId;

        // check the memo first
        if(memo.containsKey(key)) {
            return memo.get(key);
        }

        // if start and index are same, we are probably dealing with 1 character
        // the start and end here represent a substring starting and start and ending at end index
        if(startId == endId) {
            // Any single character is already a palindrome of length 1
            return 1;
        }

        // scenario where the start and end pointers cross and start is after end index
        if(startId > endId) {
            // This represents an empty string, whose palindromic length can only be 0
            return 0;
        }

        // If the char at start and end indexes are same we are beginning to match strings and we should
        // be able to eliminate them as matched
        if(str.charAt(startId) == str.charAt(endId)) {
            // Chars have matched, so move the pointers inward
            // Since the 2 chars matched we return a length of 2 + length of subsequence
            int length =  2 + maxPalinSubsequenceMemoized(str, startId + 1, endId - 1, memo);
            memo.put(key, length);
        } else {
            // The start and end characters did not match
            // For left side of tree we omit first char
            // For right side of tree we omit last char
            int leftPalinMax = maxPalinSubsequenceMemoized(str, startId + 1, endId, memo);
            int rightPalinMax = maxPalinSubsequenceMemoized(str, startId, endId - 1, memo);

            // We want to return the max length between the left and right tree results
            int length =  Math.max(leftPalinMax, rightPalinMax);
            memo.put(key, length);
        }

        return memo.get(key);
    }

    private static int maxPalinSubsequenceBF(String str, int startId, int endId) {
        // if start and index are same, we are probably dealing with 1 character
        // the start and end here represent a substring starting and start and ending at end index
        if(startId == endId) {
            // Any single character is already a palindrome of length 1
            return 1;
        }

        // scenario where the start and end pointers cross and start is after end index
        if(startId > endId) {
            // This represents an empty string, whose palindromic length can only be 0
            return 0;
        }

        // If the char at start and end indexes are same we are beginning to match strings and we should
        // be able to eliminate them as matched
        if(str.charAt(startId) == str.charAt(endId)) {
            // Chars have matched, so move the pointers inward
            // Since the 2 chars matched we return a length of 2 + length of subsequence
            return 2 + maxPalinSubsequenceBF(str, startId + 1, endId - 1);
        } else {
            // The start and end characters did not match
            // For left side of tree we omit first char
            // For right side of tree we omit last char
            int leftPalinMax = maxPalinSubsequenceBF(str, startId + 1, endId);
            int rightPalinMax = maxPalinSubsequenceBF(str, startId, endId - 1);

            // We want to return the max length between the left and right tree results
            return Math.max(leftPalinMax, rightPalinMax);
        }
    }

}

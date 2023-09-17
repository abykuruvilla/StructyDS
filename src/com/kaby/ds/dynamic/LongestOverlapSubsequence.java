package com.kaby.ds.dynamic;

import com.kaby.ds.helper.ResultPair;

import java.util.HashMap;

public class LongestOverlapSubsequence {

    /**
     * Write a function, overlapSubsequence, that takes in two strings as arguments. The function should return
     * the length of the longest overlapping subsequence.
     *
     * A subsequence of a string can be created by deleting any characters of the string, while maintaining the
     * relative order of characters.
     * @param args
     */
    public static void main(String[] args) {

        // == test_00: ==

        int result0 = overlapSubsequence("dogs", "daogt"); // -> 3
        ResultPair<Integer, Integer> resultPair0 = new ResultPair<>("Longest overlapping subsequence is of length ", 3, result0);
        resultPair0.printResultPair();

        // == test_01: ==

        int result1 = overlapSubsequence("xcyats", "criaotsi"); // -> 4
        ResultPair<Integer, Integer> resultPair1 = new ResultPair<>("Longest overlapping subsequence is of length ", 4, result1);
        resultPair1.printResultPair();

        // == test_02: ==

        int result2 = overlapSubsequence("xfeqortsver", "feeeuavoeqr"); // -> 5
        ResultPair<Integer, Integer> resultPair2 = new ResultPair<>("Longest overlapping subsequence is of length ", 5, result2);
        resultPair2.printResultPair();

        // == test_03: ==

        int result3 = overlapSubsequence("kinfolklivemustache", "bespokekinfolksnackwave"); // -> 11
        ResultPair<Integer, Integer> resultPair3 = new ResultPair<>("Longest overlapping subsequence is of length ", 11, result3);
        resultPair3.printResultPair();

        // == test_04: ==

        int result4 = overlapSubsequence("mumblecorebeardleggingsauthenticunicorn", "succulentspughumblemeditationlocavore"); // -> 15
        ResultPair<Integer, Integer> resultPair4 = new ResultPair<>("Longest overlapping subsequence is of length ", 15, result4);
        resultPair4.printResultPair();
        
    }

    private static int overlapSubsequence(String str1, String str2) {
//        return overlapSubsequenceBF(str1, str2, 0, 0);
        return overlapSubsequenceMemoized(str1, str2, 0, 0, new HashMap<String, Integer>());

    }

    // MEMOIZED
    private static int overlapSubsequenceMemoized(String str1, String str2, int startIdS1, int startIdS2, HashMap<String, Integer> memo) {

        // The key to the memo are a combination of startIdS1 and startIdS2 as those are the only two values that really change
        String key = startIdS1 + "," + startIdS2;

        // Check memo first
        if(memo.containsKey(key)) {
            return memo.get(key);
        }

        // Check to see if we have an empty string
        if(startIdS1 == str1.length() || startIdS2 == str2.length()) {
            // There is no overlapping subsequence if one of your strings is empty
            return 0;
        }

        // If the first char at startIdS1 = startIdS2 we have found a match, so we can reduce the
        // strings by 1 char, and solve for remaining subsequence for the two strings
        if(str1.charAt(startIdS1) == str2.charAt(startIdS2)) {
            // Call recursively on subsequence of strings omitting the first char
            // Since we have 1 char matched the length returned is 1 + length of new subsequence of string1 and string2
            int length =  1 + overlapSubsequenceMemoized(str1, str2, startIdS1 + 1, startIdS2 +1, memo);
            memo.put(key, length);
        } else {
            // Chars have not matched, so we have two options, remove first char from string1
            // or remove first char from string 2 and then look for matches
            int leftOverlapLength = overlapSubsequenceMemoized(str1, str2, startIdS1 + 1, startIdS2, memo);
            int rightOverlapLength = overlapSubsequenceMemoized(str1, str2, startIdS1, startIdS2 + 1, memo);

            // We choose the max length of the left and right subtree
            int length =  Math.max(leftOverlapLength, rightOverlapLength);
            memo.put(key, length);
        }

        return memo.get(key);
    }

    private static int overlapSubsequenceBF(String str1, String str2, int startIdS1, int startIdS2) {
        // Check to see if we have an empty string
        if(startIdS1 == str1.length() || startIdS2 == str2.length()) {
            // There is no overlapping subsequence if one of your strings is empty
            return 0;
        }

        // If the first char at startIdS1 = startIdS2 we have found a match, so we can reduce the
        // strings by 1 char, and solve for remaining subsequence for the two strings
        if(str1.charAt(startIdS1) == str2.charAt(startIdS2)) {
            // Call recursively on subsequence of strings omitting the first char
            // Since we have 1 char matched the length returned is 1 + length of new subsequence of string1 and string2
            return 1 + overlapSubsequenceBF(str1, str2, startIdS1 + 1, startIdS2 +1);
        } else {
            // Chars have not matched, so we have two options, remove first char from string1
            // or remove first char from string 2 and then look for matches
            int leftOverlapLength = overlapSubsequenceBF(str1, str2, startIdS1 + 1, startIdS2);
            int rightOverlapLength = overlapSubsequenceBF(str1, str2, startIdS1, startIdS2 + 1);

            // We choose the max length of the left and right subtree
            return Math.max(leftOverlapLength, rightOverlapLength);
        }

    }
}

package com.kaby.ds.dynamic;

import com.kaby.ds.helper.ResultPair;

import java.util.HashMap;

public class CanConcat {

    /**
     * Write a function, canConcat, that takes in a string and an array of words as arguments.
     * The function should return boolean indicating whether or not it is possible to
     * concatenate words of the array together to form the string.
     *
     * You may reuse words of the array as many times as needed.
     * @param args
     */
    public static void main(String[] args) {

        // == test_00: ==

        Boolean result0 = canConcat("oneisnone", new String[] {"one", "none", "is"}); // -> true
        ResultPair<Boolean, Boolean> resultPair0 = new ResultPair<>("Can concatenate? ", Boolean.TRUE, result0);
        resultPair0.printResultPair();

        // == test_01: ==

        Boolean result1 = canConcat("oneisnone", new String[] {"on", "e", "is"}); // -> false
        ResultPair<Boolean, Boolean> resultPair1 = new ResultPair<>("Can concatenate? ", Boolean.FALSE, result1);
        resultPair1.printResultPair();

        // == test_02: ==

        Boolean result2 = canConcat("oneisnone", new String[] {"on", "e", "is", "n"}); // -> true
        ResultPair<Boolean, Boolean> resultPair2 = new ResultPair<>("Can concatenate? ", Boolean.TRUE, result2);
        resultPair2.printResultPair();

        // == test_03: ==

        Boolean result3 = canConcat("foodisgood", new String[] {"is", "g", "ood", "f"}); // -> true
        ResultPair<Boolean, Boolean> resultPair3 = new ResultPair<>("Can concatenate? ", Boolean.TRUE, result3);
        resultPair3.printResultPair();

        // == test_04: ==

        Boolean result4 = canConcat("santahat", new String[] {"santah", "hat"}); // -> false
        ResultPair<Boolean, Boolean> resultPair4 = new ResultPair<>("Can concatenate? ", Boolean.FALSE, result4);
        resultPair4.printResultPair();

        // == test_05: ==

        Boolean result5 = canConcat("santahat", new String[] {"santah", "san", "hat", "tahat"}); // -> true
        ResultPair<Boolean, Boolean> resultPair5 = new ResultPair<>("Can concatenate? ", Boolean.TRUE, result5);
        resultPair5.printResultPair();

        // == test_06: ==

        Boolean result6 = canConcat("rrrrrrrrrrrrrrrrrrrrrrrrrrx", new String[] {"r", "rr", "rrr", "rrrr", "rrrrr", "rrrrrr"}); // -> false
        ResultPair<Boolean, Boolean> resultPair6 = new ResultPair<>("Can concatenate? ", Boolean.FALSE, result6);
        resultPair6.printResultPair();

        // == test_07: ==

        Boolean result7 = canConcat("fooisgood", new String[] {"foo", "is", "g", "ood", "f"}); // -> true
        ResultPair<Boolean, Boolean> resultPair7 = new ResultPair<>("Can concatenate? ", Boolean.TRUE, result7);
        resultPair7.printResultPair();

    }

    private static Boolean canConcat(String str, String[] words) {
//        return canConcatBF(str, words);
        // The key to memo is just the suffix string, as that is only thing that changes
        return canConcatMemo(str, words, new HashMap<String, Boolean>());

    }

    // Using Memoization
    private static Boolean canConcatMemo(String str, String[] words, HashMap<String, Boolean> memo) {

        // Check the memo first
        if(memo.containsKey(str)) {
            return memo.get(str);
        }

        // If the string is empty return true
        if(str.isEmpty()) {
            return Boolean.TRUE;
        }

        // Iterate over the possible words and check if any of the words are a prefix of the string
        for(String word : words) {
            if(str.startsWith(word)) {
                // Let's slice off the prefix part from the string
                // This shrinks the string by removing the prefix word
                String suffix = str.substring(word.length());

                // Pass recursively the suffix part to see if we can concat, if yes return TRUE
                if(canConcatMemo(suffix, words, memo) == Boolean.TRUE) {
                    memo.put(suffix, Boolean.TRUE);
                    return Boolean.TRUE;
                }
            }
        }

        // We could not concat for any of the word combinations
        memo.put(str, Boolean.FALSE);
        return Boolean.FALSE;
    }

    private static Boolean canConcatBF(String str, String[] words) {

        // If the string is empty return true
        if(str.isEmpty()) {
            return Boolean.TRUE;
        }

        // Iterate over the possible words and check if any of the words are a prefix of the string
        for(String word : words) {
            if(str.startsWith(word)) {
                // Let's slice off the prefix part from the string
                // This shrinks the string by removing the prefix word
                String suffix = str.substring(word.length());

                // Pass recursively the suffix part to see if we can concat, if yes return TRUE
                if(canConcatBF(suffix, words) == Boolean.TRUE) {
                    return Boolean.TRUE;
                }
            }
        }

        // We could not concat for any of the word combinations
        return Boolean.FALSE;
    }
}

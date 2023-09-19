package com.kaby.ds.dynamic;

import com.kaby.ds.helper.ResultPair;

import java.util.HashMap;

public class QuickestConcat {

    /**
     * Write a function, quickestConcat, that takes in a string and an array of words as
     * arguments. The function should return the minimum number of words needed to build
     * the string by concatenating words of the array.
     *
     * You may use words of the array as many times as needed.
     * @param args
     */
    public static void main(String[] args) {

        // == test_00: ==

        int result0 = quickestConcat("caution", new String[] {"ca", "ion", "caut", "ut"}); // -> 2
        ResultPair<Integer, Integer> resultPair0 = new ResultPair<>("Min number of words required for quick concat", 2, result0);
        resultPair0.printResultPair();

        // == test_01: ==

        int result1 = quickestConcat("caution", new String[] {"ion", "caut", "caution"}); // -> 1
        ResultPair<Integer, Integer> resultPair1 = new ResultPair<>("Min number of words required for quick concat", 1, result1);
        resultPair1.printResultPair();

        // == test_02: ==

        int result2 = quickestConcat("respondorreact", new String[] {"re", "or", "spond", "act", "respond"}); // -> 4
        ResultPair<Integer, Integer> resultPair2 = new ResultPair<>("Min number of words required for quick concat", 4, result2);
        resultPair2.printResultPair();

        // == test_03: ==

        int result3 = quickestConcat("simchacindy", new String[] {"sim", "simcha", "acindy", "ch"}); // -> 3
        ResultPair<Integer, Integer> resultPair3 = new ResultPair<>("Min number of words required for quick concat", 3, result3);
        resultPair3.printResultPair();

        // == test_04: ==

        int result4 = quickestConcat("simchacindy", new String[] {"sim", "simcha", "acindy"}); // -> -1
        ResultPair<Integer, Integer> resultPair4 = new ResultPair<>("Min number of words required for quick concat", -1, result4);
        resultPair4.printResultPair();

        // == test_05: ==

        int result5 = quickestConcat("uuuuuu", new String[] {"u", "uu", "uuu", "uuuu"}); // -> 2
        ResultPair<Integer, Integer> resultPair5 = new ResultPair<>("Min number of words required for quick concat", 2, result5);
        resultPair5.printResultPair();

        // == test_06: ==

        int result6 = quickestConcat("rongbetty", new String[] {"wrong", "bet"}); // -> -1
        ResultPair<Integer, Integer> resultPair6 = new ResultPair<>("Min number of words required for quick concat", -1, result6);
        resultPair6.printResultPair();

        // == test_07: ==

        int result7 = quickestConcat("uuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu", new String[] {"u", "uu", "uuu", "uuuu", "uuuuu"}); // -> 7
        ResultPair<Integer, Integer> resultPair7 = new ResultPair<>("Min number of words required for quick concat", 7, result7);
        resultPair7.printResultPair();

    }

    private static int quickestConcat(String str, String[] words) {

//        int result =  quickestConcatBF(str, words);
        int result =  quickestConcatMemoized(str, words, new HashMap<>());

        // The below method will return the integer MAX value if we cannot concatenate, in that case return -1
        if(result == Integer.MAX_VALUE) {
            return -1;
        } else {
            return result;
        }

    }

    private static int quickestConcatMemoized(String str, String[] words, HashMap<String, Integer> memo) {

        // Check memo first
        if(memo.containsKey(str)) {
            return memo.get(str);
        }

        // If the string is empty this is a base case where there are 0 ways to concat
        if(str.isEmpty()) {
            return 0;
        }

        // Start with a very HIGH minNumOfWords as default, since we are looking for MIN value
        int minNumOfWords = Integer.MAX_VALUE;

        for(String word : words) {
            // If in the words list any of the words prefix the input string, reduce the string by the word length
            if(str.startsWith(word)) {
                String suffix = str.substring(word.length());

                // This suffix can be passed recursively
                // The +1 here is the word we used to derive the suffix
                int attempt = 1 + quickestConcatMemoized(suffix, words, memo);

                // Look for the new minimum for each attempt
                // Note: for some test cases (3 and 4) we are getting a very large negative value for some attempts, hence adding additional condition to send -1
                minNumOfWords = attempt < -1 ? minNumOfWords : Math.min(attempt, minNumOfWords);

            }
        }

        // add to memo
        memo.put(str, minNumOfWords);

        return minNumOfWords;
    }

    private static int quickestConcatBF(String str, String[] words) {

        // If the string is empty this is a base case where there are 0 ways to concat
        if(str.isEmpty()) {
            return 0;
        }

        // Start with a very HIGH minNumOfWords as default, since we are looking for MIN value
        int minNumOfWords = Integer.MAX_VALUE;

        for(String word : words) {
            // If in the words list any of the words prefix the input string, reduce the string by the word length
            if(str.startsWith(word)) {
                String suffix = str.substring(word.length());

                // This suffix can be passed recursively
                // The +1 here is the word we used to derive the suffix
                int attempt = 1 + quickestConcatBF(suffix, words);

                // Look for the new minimum for each attempt
                // Note: for some test cases (3 and 4) we are getting a very large negative value for some attempts, hence adding additional condition to send -1
                minNumOfWords = attempt < -1 ? minNumOfWords : Math.min(attempt, minNumOfWords);
            }
        }

        return minNumOfWords;
    }
}

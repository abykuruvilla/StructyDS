package com.kaby.ds.mixed;

import com.kaby.ds.helper.ResultPair;


// STRINGS
public class DetectDictonary {

    /**
     * Write a function, detectDictionary, that takes in a dictionary of words and an alphabet string.
     * The function should return a boolean indicating whether or not all words of the dictionary are
     * lexically-ordered according to the alphabet.
     * <p>
     * You can assume that all characters are lowercase a-z.
     * <p>
     * You can assume that the alphabet contains all 26 letters.
     *
     * @param args
     */
    public static void main(String[] args) {

        // == test_00: ==

        var dictionary1 = new String[]{"zoo", "tick", "tack", "door"};
        var alphabet1 = "ghzstijbacdopnfklmeqrxyuvw";
        boolean result0 = detectDictionary(dictionary1, alphabet1); // -> true
        ResultPair<Boolean, Boolean> resultPair0 = new ResultPair<>("Is dictionary in lexical order? ", true, result0);
        resultPair0.assertMatch();

        // == test_01: ==

        var dictionary2 = new String[]{"zoo", "tack", "tick", "door"};
        var alphabet2 = "ghzstijbacdopnfklmeqrxyuvw";
        boolean result1 = detectDictionary(dictionary2, alphabet2); // -> false
        ResultPair<Boolean, Boolean> resultPair1 = new ResultPair<>("Is dictionary in lexical order? ", false, result1);
        resultPair1.assertMatch();

        // == test_02: ==

        var dictionary3 = new String[]{"zoos", "zoo", "tick", "tack", "door"};
        var alphabet3 = "ghzstijbacdopnfklmeqrxyuvw";
        boolean result2 = detectDictionary(dictionary3, alphabet3); // -> false
        ResultPair<Boolean, Boolean> resultPair2 = new ResultPair<>("Is dictionary in lexical order? ", false, result2);
        resultPair2.assertMatch();

        // == test_03: ==

        var dictionary4 = new String[]{"miles", "milestone", "proper", "process", "goal"};
        var alphabet4 = "mnoijpqrshkltabcdefguvwzxy";
        boolean result3 = detectDictionary(dictionary4, alphabet4); // -> true
        ResultPair<Boolean, Boolean> resultPair3 = new ResultPair<>("Is dictionary in lexical order? ", true, result3);
        resultPair3.assertMatch();

        // == test_04: ==

        var dictionary5 = new String[]{"miles", "milestone", "pint", "proper", "process", "goal"};
        var alphabet5 = "mnoijpqrshkltabcdefguvwzxy";
        boolean result4 = detectDictionary(dictionary5, alphabet5); // -> true
        ResultPair<Boolean, Boolean> resultPair4 = new ResultPair<>("Is dictionary in lexical order? ", true, result4);
        resultPair4.assertMatch();

        // == test_05: ==

        var dictionary6 = new String[]{"miles", "milestone", "pint", "proper", "process", "goal", "apple"};
        var alphabet6 = "mnoijpqrshkltabcdefguvwzxy";
        boolean result5 = detectDictionary(dictionary6, alphabet6); // -> false
        ResultPair<Boolean, Boolean> resultPair5 = new ResultPair<>("Is dictionary in lexical order? ", false, result5);
        resultPair5.assertMatch();


    }

    private static boolean detectDictionary(String[] dictionary, String alphabet) {
        // We check for lexical ordering of two words at a time, if any of the ordering of words is false, we return false
        // If after going through all words ordering is not false, we default return a true.
        for(int i = 0; i < dictionary.length - 1; i++) {
            boolean result = lexicalOrder(dictionary[i], dictionary[i + 1], alphabet);
            if(!result) {
                return false;
            }
        }

        return true;
    }

    private static boolean lexicalOrder(String word1, String word2, String alphabetSequence) {
        // Check the max length between word1 and word2
        int maxLength = Math.max(word1.length(), word2.length());

        for(int i = 0; i < maxLength; i++) {

            // return the position of the character at position i or the min value of int, this is to accommodate for shorter words
            var value1 = i < word1.length() ? alphabetSequence.indexOf(word1.charAt(i)) : Integer.MIN_VALUE;
            var value2 = i < word2.length() ? alphabetSequence.indexOf(word2.charAt(i)) : Integer.MIN_VALUE;

            // If character in word1 is lesser in the lexical order return true
            // If character in word1 is greater in the lexical order return false
            // If character in word1 is equal in the lexical order we loop check next character
            if(value1 < value2) {
                return true;
            } else if(value1 > value2) {
                return false;
            }
        }

        // Return true if both words were same
        return true;
    }
}

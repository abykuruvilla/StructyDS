package com.kaby.ds.mixed;

import com.kaby.ds.helper.ResultPair;

public class LexicalOrder {

    /**
     * Write a function, lexicalOrder, that takes in 2 words and an alphabet string as an argument.
     * The function should return true if the first word should appear before the second word if lexically-ordered
     * according to the given alphabet order. If the second word should appear first, then return false.
     *
     * Note that the alphabet string may be any arbitrary string.
     *
     * Intuitively, Lexical Order is like "dictionary" order:
     *
     * You can assume that all characters are lowercase a-z.
     *
     * You can assume that the alphabet contains all 26 letters.
     * @param args
     */
    public static void main(String[] args) {

        var alphabet1 = "abcdefghijklmnopqrstuvwxyz";
        var alphabet2 = "ghzstijbacdopnfklmeqrxyuvw";


        // == test_00: ==

        boolean result0 = lexicalOrder("apple", "dock", alphabet1); // -> true
        ResultPair<Boolean, Boolean> resultPair0 = new ResultPair<>("Given strings are in lexical order? ", true, result0);
        resultPair0.printResultPair();

        // == test_01: ==

        boolean result1 = lexicalOrder("apple", "ample", alphabet1); // -> false
        ResultPair<Boolean, Boolean> resultPair1 = new ResultPair<>("Given strings are in lexical order? ", false, result1);
        resultPair1.printResultPair();

        // == test_02: ==

        boolean result2 = lexicalOrder("app", "application", alphabet1); // -> true
        ResultPair<Boolean, Boolean> resultPair2 = new ResultPair<>("Given strings are in lexical order? ", true, result2);
        resultPair2.printResultPair();

        // == test_03: ==

        boolean result3 = lexicalOrder("backs", "backdoor", alphabet1); // -> false
        ResultPair<Boolean, Boolean> resultPair3 = new ResultPair<>("Given strings are in lexical order? ", false, result3);
        resultPair3.printResultPair();

        // == test_04: ==

        boolean result4 = lexicalOrder("zoo", "dinner", alphabet2); // -> true
        ResultPair<Boolean, Boolean> resultPair4 = new ResultPair<>("Given strings are in lexical order? ", true, result4);
        resultPair4.printResultPair();

        // == test_05: ==

        boolean result5 = lexicalOrder("leaper", "leap", alphabet2); // -> false
        ResultPair<Boolean, Boolean> resultPair5 = new ResultPair<>("Given strings are in lexical order? ", false, result5);
        resultPair5.printResultPair();

        // == test_06: ==

        boolean result6 = lexicalOrder("backs", "backdoor", alphabet2); // -> true
        ResultPair<Boolean, Boolean> resultPair6 = new ResultPair<>("Given strings are in lexical order? ", true, result6);
        resultPair6.printResultPair();

        // == test_07: ==

        boolean result7 = lexicalOrder("semper", "semper", alphabet2); // -> true
        ResultPair<Boolean, Boolean> resultPair7 = new ResultPair<>("Given strings are in lexical order? ", true, result7);
        resultPair7.printResultPair();


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

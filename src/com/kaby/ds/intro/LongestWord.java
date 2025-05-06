package com.kaby.ds.intro;


import com.kaby.ds.helper.ResultPair;

/**
 * Write a function, longestWord, that takes in a sentence string as an argument.
 * The function should return the longest word in the sentence.
 * If there is a tie, return the word that occurs later in the sentence.
 * <p>
 * You can assume that the sentence is non-empty.
 */
public class LongestWord {

    /**
     * Write a function, longestWord, that takes in a sentence string as an argument.
     * The function should return the longest word in the sentence.
     * If there is a tie, return the word that occurs later in the sentence.
     * <p>
     * You can assume that the sentence is non-empty.
     */
    public static void main(String[] args) {

        // == test0 ==
        String result0 = longestWord("what a wonderful world"); // -> "wonderful"
        ResultPair<String, String> resultPair0 = new ResultPair<>("The longest word is ", "wonderful", result0);
        resultPair0.assertMatch();

        // == test1 ==
        String result1 = longestWord("have a nice day"); // -> "nice"
        ResultPair<String, String> resultPair1 = new ResultPair<>("The longest word is ", "nice", result1);
        resultPair1.assertMatch();

        // == test2 ==
        String result2 = longestWord("the quick brown fox jumped over the lazy dog"); // -> "jumped"
        ResultPair<String, String> resultPair2 = new ResultPair<>("The longest word is ", "jumped", result2);
        resultPair2.assertMatch();

        // == test3 ==
        String result3 = longestWord("who did eat the ham"); // -> "ham"
        ResultPair<String, String> resultPair3 = new ResultPair<>("The longest word is ", "ham", result3);
        resultPair3.assertMatch();

        // == test4 ==
        String result4 = longestWord("potato"); // -> "potato"
        ResultPair<String, String> resultPair4 = new ResultPair<>("The longest word is ", "potato", result4);
        resultPair4.assertMatch();

    }

    public static String longestWord(String sentence) {

        // split the sentence into words
        String[] words = sentence.split(" ");
        // track longest running word
        String longestWord = "";

        for (String word : words) {
            // If two words are of equal size we need to return the next word
            if (word.length() >= longestWord.length()) {
                longestWord = word;
            }
        }

        return longestWord;
    }
}

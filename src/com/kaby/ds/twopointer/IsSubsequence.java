package com.kaby.ds.twopointer;

import com.kaby.ds.helper.ResultPair;

public class IsSubsequence {

    /**
     * Write a function, is_subsequence, that takes in string_1 and string_2.
     * The function should return a boolean indicating whether or not string1 is a subsequence of string2.
     *
     * A subsequence is a string that can be formed by deleting 0 or more characters from another string.
     * @param args
     */
    public static void main(String[] args) {

        // == test0 ==
        boolean result0 =  isSubsequence("bde", "abcdef");      // true
        ResultPair<Boolean, Boolean> resultPair0 = new ResultPair<>("Is bde subsequence of abcdef : ", true, result0);
        resultPair0.assertMatch();

        // == test1 ==
        boolean result1 =  isSubsequence("bda", "abcdef");       // false
        ResultPair<Boolean, Boolean> resultPair1 = new ResultPair<>("Is bda subsequence of abcdef : ", false, result1);
        resultPair1.assertMatch();

        // == test2 ==
        boolean result2 =  isSubsequence("ser", "super");        // true
        ResultPair<Boolean, Boolean> resultPair2 = new ResultPair<>("Is ser subsequence of super : ", true, result2);
        resultPair2.assertMatch();

        // == test3 ==
        boolean result3 =  isSubsequence("serr", "super");       // false
        ResultPair<Boolean, Boolean> resultPair3 = new ResultPair<>("Is serr subsequence of super : ", false, result3);
        resultPair3.assertMatch();

        // == test4 ==
        boolean result4 = isSubsequence("ama", "camera");       // true
        ResultPair<Boolean, Boolean> resultPair4 = new ResultPair<>("Is ama subsequence of camera : ", true, result4);
        resultPair4.assertMatch();

        // == test5 ==
        boolean result5 = isSubsequence("unfun", "unfortunate"); // true
        ResultPair<Boolean, Boolean> resultPair5 = new ResultPair<>("Is unfun subsequence of unfortunate : ", true, result5);
        resultPair5.assertMatch();

        // == test6 ==
        boolean result6 = isSubsequence("riverbed", "river");   // false
        ResultPair<Boolean, Boolean> resultPair6 = new ResultPair<>("Is riverbed subsequence of river : ", false, result6);
        resultPair6.assertMatch();

        // == test7 ==
        boolean result7 = isSubsequence("river", "riverbed");   // true
        ResultPair<Boolean, Boolean> resultPair7 = new ResultPair<>("Is river subsequence of riverbed : ", true, result7);
        resultPair7.assertMatch();

    }

    /**
     * Check if string1 is a subsequence of string2
     * @param string1 - potential subsequence
     * @param string2 - the string to be checked against
     * @return
     */
    public static boolean isSubsequence(String string1, String string2) {

        int i = 0; // pointer to string1
        int j = 0; // pointer to string 2

        // loop through both strings
        while(i < string1.length() && j < string2.length()) {
            if(string1.charAt(i) == string2.charAt(j)) {
                i++; // increment pointer to string1 only if characters match
            }
            j++; // always move the pointer for string2
        }

        // if we reached the end of string1 all strings matched in order
        return i == string1.length();

    }

}

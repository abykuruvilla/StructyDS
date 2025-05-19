package com.kaby.ds.twopointer;

import com.kaby.ds.helper.ResultPair;

public class IsPalindrome {

    /**
     * Write a function, is_palindrome, that takes in a string and returns a boolean indicating
     * whether or not the string is the same forwards and backwards.
     *
     * @param args
     */
    public static void main(String[] args) {

        boolean result0 = isPalindrome("racecar");
        ResultPair<Boolean, Boolean> resultPair0 = new ResultPair<>("Is palindrome racecar : ", true, result0);
        resultPair0.assertMatch();
        boolean result1 = isPalindrome("hello");
        ResultPair<Boolean, Boolean> resultPair1 = new ResultPair<>("Is palindrome hello : ", false, result1);
        resultPair1.assertMatch();
        boolean result2 = isPalindrome("level");
        ResultPair<Boolean, Boolean> resultPair2 = new ResultPair<>("Is palindrome level : ", true, result2);
        resultPair2.assertMatch();
        boolean result3 = isPalindrome("a");
        ResultPair<Boolean, Boolean> resultPair3 = new ResultPair<>("Is palindrome a : ", true, result3);
        resultPair3.assertMatch();
        boolean result4 = isPalindrome("");
        ResultPair<Boolean, Boolean> resultPair4 = new ResultPair<>("Is palindrome \"\" : ", true, result4);
        resultPair4.assertMatch();

    }

    public static boolean isPalindrome(String str) {
        // Check to see if the string is empty
        if(str.isEmpty()) {
            return true;
        }

        // Use two pointers to check if the string is a palindrome
        int left = 0;
        int right = str.length() - 1;

        while(left < right) {
            if(str.charAt(left) != str.charAt(right)) {
                return false;
            } else {
                left++;
                right--;
            }
        }

        return true;

    }
}

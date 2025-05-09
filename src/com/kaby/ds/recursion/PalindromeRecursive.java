package com.kaby.ds.recursion;

import com.kaby.ds.helper.ResultPair;

public class PalindromeRecursive {

    /**
     * Write a function, palindrome, that takes in a string and returns a boolean
     * indicating whether or not the string is the same forwards and backwards.
     *
     * You must solve this recursively.
     * @param args
     */
    public static void main(String[] args) {

        boolean result0 = palindrome("pop"); // -> True
        ResultPair<Boolean, Boolean> resultPair0 = new ResultPair<>("Is pop a palindrome? ", true, result0);
        resultPair0.assertMatch();

        boolean result1 = palindrome("abcbca"); // -> False
        ResultPair<Boolean, Boolean> resultPair1 = new ResultPair<>("Is abcbca a palindrome? ", false, result1);
        resultPair1.assertMatch();

        boolean result2 = palindrome("a"); // -> True
        ResultPair<Boolean, Boolean> resultPair2 = new ResultPair<>("Is a, a palindrome? ", true, result2);
        resultPair2.assertMatch();

        boolean result3 = palindrome("noon"); // -> True
        ResultPair<Boolean, Boolean> resultPair3 = new ResultPair<>("Is noon a palindrome? ", true, result3);
        resultPair3.assertMatch();

    }

    private static boolean palindrome(String str) {

        // Base case: if the string is empty, then we return true
        if(str.isEmpty()) {
            return true;
        }
        // Base case: if the string has only one character, then we return true
        if(str.length() == 1) {
            return true;
        }

        // Recursive case: if the string has more than one character,
        // then we check if the first character is equal to the last character
        // and if they are equal, then we call the function recursively on the rest of the string
        return str.charAt(0) == str.charAt(str.length()-1) && palindrome(str.substring(1, str.length()-1));

    }
}

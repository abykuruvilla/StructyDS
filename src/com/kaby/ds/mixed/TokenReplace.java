package com.kaby.ds.mixed;

import com.kaby.ds.helper.ResultPair;

import java.util.Map;

// STRINGS
// 2 POINTER
public class TokenReplace {

    /**
     * Write a function, tokenReplace, that takes in an object of tokens and a string. The function
     * should return a new string where tokens are replaced.
     * <p>
     * Tokens are enclosed in a pair of "$". You can assume that the input string is properly
     * formatted. Tokens should be replaced from left to right in the string (see // == test_05).
     *
     * @param args
     */
    public static void main(String[] args) {

        // == test_00: ==

        var tokens0 = Map.of(
                "$LOCATION$", "park",
                "$ANIMAL$", "dog"
        );
        String result0 = tokenReplace("Walk the $ANIMAL$ in the $LOCATION$!", tokens0); // -> 'Walk the dog in the park!'
        ResultPair<String, String> resultPair0 = new ResultPair<>("String after token replace ", "Walk the dog in the park!", result0);
        resultPair0.assertMatch();

        // == test_01: ==

        var tokens1 = Map.of(
                "$ADJECTIVE$", "quick",
                "$VERB$", "hopped",
                "$DIRECTION$", "North"
        );
        String result1 = tokenReplace("the $ADJECTIVE$ fox $VERB$ $ADJECTIVE$ly $DIRECTION$ward", tokens1); // -> 'the quick fox hopped quickly Northward'
        ResultPair<String, String> resultPair1 = new ResultPair<>("String after token replace ", "the quick fox hopped quickly Northward", result1);
        resultPair1.assertMatch();

        // == test_02: ==

        var tokens2 = Map.of(
                "$greeting$", "hey programmer"
        );
        String result2 = tokenReplace("his greeting is always $greeting$.", tokens2); // -> 'his greeting is always hey programmer.'
        ResultPair<String, String> resultPair2 = new ResultPair<>("String after token replace ", "his greeting is always hey programmer.", result2);
        resultPair2.assertMatch();

        // == test_03: ==

        var tokens3 = Map.of(
                "$A$", "lions",
                "$B$", "tigers",
                "$C$", "bears"
        );
        String result3 = tokenReplace("$A$$B$$C$, oh my.", tokens3); // -> 'lionstigersbears, oh my.'
        ResultPair<String, String> resultPair3 = new ResultPair<>("String after token replace ", "lionstigersbears, oh my.", result3);
        resultPair3.assertMatch();

        // == test_04: ==

        var tokens4 = Map.of(
                "$A$", "lions",
                "$B$", "tigers",
                "$C$", "bears"
        );
        String result4 = tokenReplace("$B$", tokens4); // -> 'tigers'
        ResultPair<String, String> resultPair4 = new ResultPair<>("String after token replace ", "tigers", result4);
        resultPair4.assertMatch();

        // == test_05: ==

        var tokens5 = Map.of(
                "$second$", "beta",
                "$first$", "alpha",
                "$third$", "gamma"
        );
        String result5 = tokenReplace("$first$second$third$", tokens5); // -> 'alphasecondgamma'
        ResultPair<String, String> resultPair5 = new ResultPair<>("String after token replace ", "alphasecondgamma", result5);
        resultPair5.assertMatch();


    }

    private static String tokenReplace(String str, Map<String, String> tokens) {
        // two pointers
        int i = 0;
        int j = 1;

        StringBuilder result = new StringBuilder();

        while(i < str.length()) {
            // if i does not start with $
            if(str.charAt(i) != '$') {
                result.append(str.charAt(i));
                i = i + 1;
                j = i + 1;
            } else if(str.charAt(j) != '$') {
                // i has hit a $ sign, indicating start of a token
                // so increment j till we hit $ sign at end of token
                j = j + 1;
            } else {
                // both i and j point to a dollar
                String key = str.substring(i, j + 1);
                result.append(tokens.get(key));
                // let's start going thru string again
                i = j + 1;
                j = i + 1;
            }
        }

        return result.toString();
    }
}

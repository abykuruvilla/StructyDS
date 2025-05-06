package com.kaby.ds.mixed;

import com.kaby.ds.helper.ResultPair;

import java.util.Map;

// STRING
// GRAPH DFS
public class TokenTransform {

    /**
     * Write a function, tokenTransform, that takes in an object of tokens and a string.
     * In the object, the replacement values for a token may reference other tokens.
     * The function should return a new string where tokens are replaced with their fully
     * evaluated string values.
     * <p>
     * Tokens are enclosed in a pair of "$".
     * <p>
     * You may assume that there are no circular token dependencies.
     *
     * @param args
     */
    public static void main(String[] args) {

        // == test_00: ==

        var tokens0 = Map.of(
                "$LOCATION$", "$ANIMAL$ park",
                "$ANIMAL$", "dog"
        );

        String result0 = tokenTransform("Walk the $ANIMAL$ in the $LOCATION$!", tokens0); // -> 'Walk the dog in the dog park!'
        ResultPair<String, String> resultPair0 = new ResultPair<>("Token transform result ", "Walk the dog in the dog park!", result0);
        resultPair0.assertMatch();

        // == test_01: ==

        var tokens1 = Map.of(
                "$ADJECTIVE_1$", "quick",
                "$ADJECTIVE_2$", "eager",
                "$ADVERBS$", "$ADJECTIVE_1$ly and $ADJECTIVE_2$ly",
                "$VERB$", "hopped $DIRECTION$",
                "$DIRECTION$", "North"
        );
        String result1 = tokenTransform("the $ADJECTIVE_1$ fox $ADVERBS$ $VERB$ward", tokens1); // -> 'the quick fox quickly and eagerly hopped Northward'
        ResultPair<String, String> resultPair1 = new ResultPair<>("Token transform result ", "the quick fox quickly and eagerly hopped Northward", result1);
        resultPair1.assertMatch();

        // == test_02: ==

        var tokens2 = Map.of(
                "$B$", "epicly $C$",
                "$A$", "pretty $B$ problem $D$",
                "$D$", "we have",
                "$C$", "clever"
        );
        String result2 = tokenTransform("What a $A$ here!", tokens2); // -> 'What a pretty epicly clever problem we have here!'
        ResultPair<String, String> resultPair2 = new ResultPair<>("Token transform result ", "What a pretty epicly clever problem we have here!", result2);
        resultPair2.assertMatch();

        // == test_03: ==

        var tokens3 = Map.of(
                "$1$", "a$2$",
                "$2$", "b$3$",
                "$3$", "c$4$",
                "$4$", "d$5$",
                "$5$", "e$6$",
                "$6$", "f!"
        );
        String result3 = tokenTransform("$1$ $1$ $1$ $1$ $1$ $1$ $4$ $4$", tokens3); // -> 'abcdef! abcdef! abcdef! abcdef! abcdef! abcdef! def! def!'
        ResultPair<String, String> resultPair3 = new ResultPair<>("Token transform result ", "abcdef! abcdef! abcdef! abcdef! abcdef! abcdef! def! def!", result3);
        resultPair3.assertMatch();

        // == test_04: ==

        var tokens4 = Map.of(
                "$0$", "$1$$1$$1$$1$$1$$1$$1$$1$$1$$1$$1$$1$",
                "$1$", "$2$$2$$2$$2$$2$$2$$2$$2$$2$",
                "$2$", "$3$$3$$3$$3$$3$$3$$3$",
                "$3$", "$4$$4$$4$$4$$4$$4$",
                "$4$", "$5$$5$$5$$5$$5$",
                "$5$", "$6$$6$$6$$6$",
                "$6$", "$7$$7$$7$",
                "$7$", "$8$$8$",
                "$8$", ""
        );
        String result4 = tokenTransform("z$0$z$0$z$0$z$0$z$0$z$0$z", tokens4); // -> 'zzzzzzz'
        ResultPair<String, String> resultPair4 = new ResultPair<>("Token transform result ", "zzzzzzz", result4);
        resultPair4.assertMatch();

    }

    private static String tokenTransform(String str, Map<String, String> tokens) {
        // Two pointers, j always after i
        int i = 0;
        int j = 1;

        StringBuilder result = new StringBuilder();

        while(i < str.length()) {
            if(str.charAt(i) != '$') {
                // keep moving through the string while we have not encountered a starting $
                result.append(str.charAt(i));
                i = i + 1;
                j = i + 1;
            } else if(str.charAt(j) != '$') {
                // i is at a $, looking for the ending $ of the token
                j = j + 1;
            } else {
                // we have encountered a complete token
                String key = str.substring(i, j + 1);
                // get the string value from the token map, this could be another embedded token
                String value = tokens.get(key);
                // if it's an embedded token, evaluate the value recursively
                String evaluatedValue = tokenTransform(value, tokens);
                result.append(evaluatedValue);
                // continue reading/evaluating the string
                i = j + 1;
                j = i + 1;
            }
        }

        return result.toString();
    }
}

package com.kaby.ds.recursion;

import com.kaby.ds.helper.ResultPair;

import java.util.List;

public class SumOfLengths {

    /**
     * Write a function sumOfLengths that takes in a list of strings and returns the total length of the strings.
     *
     * You must solve this recursively.
     * @param args
     */
    public static void main(String[] args) {

        // == test0 ==
        int result0 = sumOfLengths(List.of("goat", "cat", "purple")); // -> 13
        ResultPair<Integer, Integer> resultPair0 = new ResultPair<>("Sum of lengths of strings is ", 13, result0);
        resultPair0.assertMatch();

        // == test1 ==
        int result1 = sumOfLengths(List.of("", " ", "  ", "   ", "    ", "     ")); // -> 15
        ResultPair<Integer, Integer> resultPair1 = new ResultPair<>("Sum of lengths of strings is ", 15, result1);
        resultPair1.assertMatch();

        // == test2 ==
        int result2 = sumOfLengths(List.of()); // -> 0
        ResultPair<Integer, Integer> resultPair2 = new ResultPair<>("Sum of lengths of strings is ", 0, result2);
        resultPair2.assertMatch();

    }

    public static int sumOfLengths(List<String> strings) {

        // Base case: if the list is empty, then the sum of lengths is 0
        if(strings.isEmpty()) {
            return 0;
        }

        // Recursive case: if the list has more than one element,
        // then we add the length of the first element to the rest of the list
        return strings.get(0).length() + sumOfLengths(strings.subList(1, strings.size()));
    }
}

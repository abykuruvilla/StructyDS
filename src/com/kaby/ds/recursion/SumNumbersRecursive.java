package com.kaby.ds.recursion;

import com.kaby.ds.helper.ResultPair;

import java.util.List;

public class SumNumbersRecursive {

    /**
     * Write a method sumNumbersRecursive that takes in a list of numbers and returns the sum of all the numbers in the list.
     * All elements will be integers. Solve this recursively.
     * @param args
     */
    public static void main(String[] args) {

        // == test0 ==
        int result0 = sumNumbersRecursive(List.of(5, 2, 9, 10)); // -> 26
        ResultPair<Integer, Integer> resultPair0 = new ResultPair<>("Sum of numbers in list is ", 26, result0);
        resultPair0.assertMatch();

        // == test1 ==
        int result1 = sumNumbersRecursive(List.of(1, -1, 1, -1, 1, -1, 1)); // -> 1
        ResultPair<Integer, Integer> resultPair1 = new ResultPair<>("Sum of numbers in list is ", 1, result1);
        resultPair1.assertMatch();

        // == test2 ==
        int result2 = sumNumbersRecursive(List.of()); // -> 0
        ResultPair<Integer, Integer> resultPair2 = new ResultPair<>("Sum of numbers in list is ", 0, result2);
        resultPair2.assertMatch();

        // == test3 ==
        int result3 = sumNumbersRecursive(List.of(-10, -9, -8, -7, -6, -5, -4, -3, -2, -1)); // -> -55
        ResultPair<Integer, Integer> resultPair3 = new ResultPair<>("Sum of numbers in list is ", -55, result3);
        resultPair3.assertMatch();

    }

    public static int sumNumbersRecursive(List<Integer> numbers) {

        // base case 1: we have an empty list, so we return 0
        if(numbers.isEmpty()) {
            return 0;
        }
        // base case 2: we have a list with only one element, so we return the element
        if(numbers.size() == 1) {
            return numbers.get(0);
        }

        // recursive case: we have more than one element, so we add the first element to the rest of the list
        return numbers.get(0) + sumNumbersRecursive(numbers.subList(1, numbers.size()));

    }
}

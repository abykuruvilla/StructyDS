package com.kaby.ds.recursion;

import com.kaby.ds.helper.ResultPair;

public class Factorial {

    /**
     * Write a function, factorial, that takes in a number n and returns the factorial of that number.
     * The factorial of n is the product of all the positive numbers less than or equal to n.
     * You must solve this recursively.
     *
     * For example, the factorial of 6 is:
     *
     * 6 * 5 * 4 * 3 * 2 * 1 = 720
     * You can assume that n is a non-negative integer. Note that the factorial of 0 is defined to be 1
     * @param args
     */
    public static void main(String[] args) {

        int result0 = factorial(3); // -> 6
        ResultPair<Integer, Integer> resultPair0 = new ResultPair<>("Factorial of 3 ", 6, result0);
        resultPair0.assertMatch();

        int result1 = factorial(6); // -> 720
        ResultPair<Integer, Integer> resultPair1 = new ResultPair<>("Factorial of 6 ", 720, result1);
        resultPair1.assertMatch();

    }

    private static int factorial(int i) {

        // Base case: if i is 0, then the factorial is 1
        if(i == 0) {
            return 1;
        }

        // Recursive case: if i is greater than 0, then we multiply the result of i-1 with i
        return i * factorial(i-1);
    }
}

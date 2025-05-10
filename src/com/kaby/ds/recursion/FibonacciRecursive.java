package com.kaby.ds.recursion;

import com.kaby.ds.helper.ResultPair;

public class FibonacciRecursive {

    /**
     * Write a function, fibonacci, that takes in a number argument, n, and returns the n-th number of the Fibonacci sequence.
     * The 0-th number of the sequence is 0.
     * The 1-st number of the sequence is 1.
     * To generate further numbers of the sequence, calculate the sum of previous two numbers.
     * You must solve this recursively.
     * @param args
     */
    public static void main(String[] args) {

        // == test0 ==
        int result0 = fibonacci(5); // -> 5
        ResultPair<Integer, Integer> resultPair0 = new ResultPair<>("Fib of 5 is ", 5, result0);
        resultPair0.assertMatch();

        // == test1 ==
        int result1 = fibonacci(10); // -> 55
        ResultPair<Integer, Integer> resultPair1 = new ResultPair<>("Fib of 10 is ", 55, result1);
        resultPair1.assertMatch();

    }

    private static int fibonacci(int i) {

        // Base case: if i is 0, then the fibonacci is 0
        if(i == 0) {
            return 0;
        }

        // Base case: if i is 1, then the fibonacci is 1
        if(i == 1) {
            return 1;
        }

        // Recursive case: if i is greater than 1, then we add the previous two numbers to get the next number
        return fibonacci(i-1) + fibonacci(i-2);
    }
}

package com.kaby.ds.dynamic;

import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;

public class Fibonacci {

    /**
     * Write a function fib that takes in a number argument,
     * n, and returns the n-th number of the Fibonacci sequence.
     * @param args
     */
    public static void main(String[] args) {

        Instant start = Instant.now();
        System.out.println("Fib of 2 is 1, Actual => " + fib(2)); // -> 1
        System.out.println("Fib of 5 is 5, Actual => " + fib(5)); // -> 5
        System.out.println("Fib of 35 is 9227456, Actual => " + fib(35)); // -> 9227465
        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();
        System.out.println("Elapsed time = " + timeElapsed + "\n\n");

        Instant start2 = Instant.now();
        System.out.println("OPTIMIZED : Fib of 2 is 1, Actual => " + fibOptimized(2, new HashMap<Integer, Integer>())); // -> 1
        System.out.println("OPTIMIZED : Fib of 5 is 5, Actual => " + fibOptimized(5, new HashMap<Integer, Integer>())); // -> 5
        System.out.println("OPTIMIZED : Fib of 35 is 9227456, Actual => " + fibOptimized(35, new HashMap<Integer, Integer>())); // -> 9227465
        Instant finish2 = Instant.now();
        long timeElapsed2 = Duration.between(start2, finish2).toMillis();
        System.out.println("Elapsed time = " + timeElapsed2 + "\n\n");
    }

    // Using memoization to improve the brute force approach
    // Time - O(n), Space O(n)
    private static Integer fibOptimized(int n, HashMap<Integer, Integer> memo) {
        // fib of 0 is 0 and fib of 1 is 1
        if(n == 0 || n == 1) {
            return n;
        }

        // if the map contains a calculated fib return that
        if(memo.containsKey(n)) {
            return memo.get(n);
        }

        // The fib(n) = fib(n-1) + fib(n-2)
        // since we call this recursively, we store intermediate results in the map,
        // so that we do not have to recompute
        memo.put(n , fibOptimized(n - 1, memo) + fibOptimized(n - 2, memo));

        return memo.get(n);
    }

    // Brute force - recursion; Time O(2^n) Space O(n)
    private static Integer fib(int n) {
        // fibonacci of 0 is 0
        if(n == 0) {
            return 0;
        }
        // fibonacci of 1 is 1
        if(n == 1) {
            return 1;
        }

        // recursively call the method
        return fib(n - 1) + fib(n - 2);
    }
}

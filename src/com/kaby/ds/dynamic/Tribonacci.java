package com.kaby.ds.dynamic;

import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;

public class Tribonacci {

    /**
     * Write a function tribonacci that takes in a number argument, n, and returns
     * the n-th number of the Tribonaccionacci sequence.
     *
     * The 0-th and 1-st numbers of the sequence are both 0.
     *
     * The 2-nd number of the sequence is 1.
     *
     * To generate further numbers of the sequence, calculate the sum of previous three numbers.
     * @param args
     */
    public static void main(String[] args) {

        Instant start = Instant.now();
        System.out.println("Tribonacci of 2 is 1, Actual => " + tribonacci(2)); // -> 1
        System.out.println("Tribonacci of 5 is 4, Actual => " + tribonacci(5)); // -> 4
        System.out.println("Tribonacci of 37 is 1132436852, Actual => " + tribonacci(37)); // -> 1132436852
        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();
        System.out.println("Elapsed time = " + timeElapsed + "\n\n");

        Instant start2 = Instant.now();
        System.out.println("OPTIMIZED : Tribonacci of 2 is 1, Actual => " + tribonacciOptimized(2, new HashMap<Integer, Integer>())); // -> 1
        System.out.println("OPTIMIZED : Tribonacci of 5 is 5, Actual => " + tribonacciOptimized(5, new HashMap<Integer, Integer>())); // -> 4
        System.out.println("OPTIMIZED : Tribonacci of 37 is 1132436852, Actual => " + tribonacciOptimized(37, new HashMap<Integer, Integer>())); // -> 1132436852
        Instant finish2 = Instant.now();
        long timeElapsed2 = Duration.between(start2, finish2).toMillis();
        System.out.println("Elapsed time = " + timeElapsed2 + "\n\n");
    }

    // Using Memoization
    // Time O(n) Space O(n)
    private static Integer tribonacciOptimized(int n, HashMap<Integer, Integer> memo) {
        // Tribonacci of position 0 and 1 is 0
        if(n == 0 || n == 1) {
            return 0;
        }
        // Tribonacci of position 2 is 1
        if(n == 2) {
            return 1;
        }

        if(memo.containsKey(n)) {
            return memo.get(n);
        } else {
            memo.put(n, tribonacciOptimized(n - 1, memo) + tribonacciOptimized(n - 2, memo) + tribonacciOptimized(n - 3, memo));
        }

        return memo.get(n);
    }

    // Using Recursion Time O(3^n) Space O(n)
    private static Integer tribonacci(int n) {
        // Tribonacci of position 0 and 1 is 0
        if(n == 0 || n == 1) {
            return 0;
        }
        // Tribonacci of position 2 is 1
        if(n == 2) {
            return 1;
        }
        // Tribonacci recursive calls
        // Tribonacci of a position n is trib(n-1) + trib(n-2) + trib(n -3)
        return tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);
    }

}

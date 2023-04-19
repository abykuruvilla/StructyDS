package com.kaby.ds.dynamic;

import com.kaby.ds.helper.ResultPair;

import java.util.HashMap;
import java.util.Map;

public class MinSumOfSquares {

    /**
     * Write a function, summingSquares, that takes a target number as an argument.
     * The function should return the minimum number of perfect squares that sum to the target.
     * A perfect square is a number of the form (i*i) where i >= 1.
     *
     * For example: 1, 4, 9, 16 are perfect squares, but 8 is not perfect square.
     * 
     * Given 12:
     * summingSquares(12) -> 3
     * The minimum squares required for 12 is three, by doing 4 + 4 + 4.
     * Another way to make 12 is 9 + 1 + 1 + 1, but that requires four perfect squares.
     *
     *  @param args
     */
    public static void main(String[] args) {

        Integer minSumOfSquares = summingSquares(12); // -> 3
        ResultPair<Integer, Integer> resultPair1 = new ResultPair<>("The min sum of squares to target 12 is ", 3, minSumOfSquares);
        resultPair1.printResultPair();

        Integer minSumOfSquares2 = summingSquaresOptimized(87, new HashMap<>()); // -> 4
        ResultPair<Integer, Integer> resultPair2 = new ResultPair<>("The min sum of squares to target 87 is ", 4, minSumOfSquares2);
        resultPair2.printResultPair();

    }

    // Brute force recursion
    private static Integer summingSquares(int n) {

        // Base case
        if(n == 0) {
            return 0;
        }

        // Since we want the minimum squares, lets take the maximum value initially
        int minSquares = Integer.MAX_VALUE;

        // Perfect squares are 1, 4, 9, 16 etc.
        for(int i = 1; i <= Math.sqrt(n); i++) {
            // One of the squares is
            int square = i * i;

            // Always add 1 to account for the square we just computed above
            int numSquares = 1 + summingSquares(n - square);

            // Store the min
            minSquares = Math.min(minSquares, numSquares);
        }

        return minSquares;
    }


    // Optimized using memoization
    private static Integer summingSquaresOptimized(int n, Map<Integer, Integer> memo) {

        // If the memo contains the precomputed value return it
        if(memo.containsKey(n)) {
            return memo.get(n);
        }

        // Base case
        if(n == 0) {
            return 0;
        }

        // Since we want the minimum squares, lets take the maximum value initially
        int minSquares = Integer.MAX_VALUE;

        // Perfect squares are 1, 4, 9, 16 etc.
        for(int i = 1; i <= Math.sqrt(n); i++) {
            // One of the squares is
            int square = i * i;

            // Always add 1 to account for the square we just computed above
            int numSquares = 1 + summingSquaresOptimized(n - square, memo);

            // Store the min
            minSquares = Math.min(minSquares, numSquares);
        }

        // Store the minimum value to the memo
        memo.put(n, minSquares);

        return memo.get(n);
    }
}

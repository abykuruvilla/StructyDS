package com.kaby.ds.dynamic;

import java.util.HashMap;

public class SumPossible {

    /**
     * Write a function sumPossible that takes in an amount and an array of positive numbers.
     * The function should return a boolean indicating whether or not it is possible to create
     * the amount by summing numbers of the array. You may reuse numbers of the array as many
     * times as necessary.
     * @param args
     */
    public static void main(String[] args) {
        boolean result1 = sumPossible(8, new int[]{5, 12, 4}); // -> true, 4 + 4
        boolean result2 = sumPossible(15, new int[]{6, 2, 10, 19}); // -> false
        boolean result3 = sumPossible(12, new int[]{}); // -> false
//        boolean result4 = sumPossible(271, new int[]{10, 8, 265, 24}); // -> false // TOO SLOW
        boolean result5 = sumPossible(13, new int[]{3, 5}); // -> true

        System.out.println("AMOUNT = 8,  NUMBERS = [5, 12, 4]         ; Expected => true,  Actual => " + result1);
        System.out.println("AMOUNT = 15, NUMBERS = [6, 2, 10, 19]    ; Expected => false, Actual => " + result2);
        System.out.println("AMOUNT = 12, NUMBERS = []                ; Expected => false, Actual => " + result3);
//        System.out.println("AMOUNT = 271, NUMBERS = [10, 8, 265, 24] ; Expected => false, Actual => " + result4);
        System.out.println("AMOUNT = 13, NUMBERS = [3, 5]            ; Expected => true,  Actual => " + result5);

        boolean resultOpt1 = sumPossibleOptimized(8, new int[]{5, 12, 4}, new HashMap<Integer, Boolean>()); // -> true, 4 + 4
        boolean resultOpt2 = sumPossibleOptimized(15, new int[]{6, 2, 10, 19}, new HashMap<Integer, Boolean>()); // -> false
        boolean resultOpt3 = sumPossibleOptimized(12, new int[]{}, new HashMap<Integer, Boolean>()); // -> false
        boolean resultOpt4 = sumPossibleOptimized(271, new int[]{10, 8, 265, 24}, new HashMap<Integer, Boolean>()); // -> false
        boolean resultOpt5 = sumPossibleOptimized(13, new int[]{3, 5}, new HashMap<Integer, Boolean>()); // -> true

        System.out.println();
        System.out.println("(Optimized) AMOUNT = 8,   NUMBERS = [5, 12, 4]         ; Expected => true,  Actual => " + resultOpt1);
        System.out.println("(Optimized) AMOUNT = 15,  NUMBERS = [6, 2, 10, 19]     ; Expected => false, Actual => " + resultOpt2);
        System.out.println("(Optimized) AMOUNT = 12,  NUMBERS = []                 ; Expected => false, Actual => " + resultOpt3);
        System.out.println("(Optimized) AMOUNT = 271, NUMBERS = [10, 8, 265, 24]   ; Expected => false, Actual => " + resultOpt4);
        System.out.println("(Optimized) AMOUNT = 13,  NUMBERS = [3, 5]             ; Expected => true,  Actual => " + resultOpt5);
    }

    // USING memoization
    private static boolean sumPossibleOptimized(int amount, int[] numbers, HashMap<Integer, Boolean> memo) {

        // Base Cases
        if(amount < 0) {
            return false;
        }
        // Base Case
        if(amount == 0) {
            return true;
        }

        // Check if the memo has the result
        if(memo.containsKey(amount)) {
            return memo.get(amount);
        }

        for(int i = 0; i < numbers.length; i++) {
            if(sumPossibleOptimized(amount - numbers[i], numbers, memo)) {
                // Save any paths that lead to a true
                memo.put(amount, true);
                return true;
            }
        }

        // Also save any paths that returned a false
        memo.put(amount, false);
        return false;
    }

    // Plain recursive - VERY SLOW
    private static boolean sumPossible(int amount, int[] numbers) {
        // During recursion guard against the case where the amount becomes negative
        // Treat this as a base case
        if(amount < 0) {
            return false;
        }

        // Base Case
        if(amount == 0) {
            return true;
        }

        // Subtract the individual values of the numbers from the amount
        for(int i = 0; i < numbers.length; i++) {
            // If any of these returns true just bubble up the true to the root of the tree
            if(sumPossible(amount - numbers[i], numbers)) {
                return true;
            }
        }

        // If the above loop did not return a true then we cannot sum up
        return false;
    }
}

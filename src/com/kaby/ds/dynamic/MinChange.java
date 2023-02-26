package com.kaby.ds.dynamic;

import java.util.HashMap;

public class MinChange {

    /**
     * Write a function minChange that takes in an amount and an array of coins.
     * The function should return the minimum number of coins required to create the amount.
     * You may use each coin as many times as necessary.
     *
     * If it is not possible to create the amount, then return -1.
     * @param args
     */
    public static void main(String[] args) {

        double result1 = minChange(8, new int[]{1, 5, 4, 12}); // -> 2, (4 + 4)
        System.out.println("AMOUNT = 8,  COINS = [1, 5, 4, 12]         ; Expected => 2,  Actual => " + result1);
        double result2 = minChange(13, new int[]{1, 9, 5, 14, 30}); // -> 5
        System.out.println("AMOUNT = 13, COINS = [1, 9, 5, 14, 30]     ; Expected => 5,  Actual => " + result2);


        System.out.println("==================");
        int resultOpt1 = minChangeOptimized(8, new int[]{1, 5, 4, 12}, new HashMap<Integer, Integer>()); // -> 2, (4 + 4)
        int resultOpt2 = minChangeOptimized(13, new int[]{1, 9, 5, 14, 30}, new HashMap<Integer, Integer>()); // -> 5
        int resultOpt3 = minChangeOptimized(23, new int[]{2, 5, 7}, new HashMap<Integer, Integer>()); // -> 4
        int resultOpt4 = minChangeOptimized(200, new int[]{1, 5, 10, 25}, new HashMap<Integer, Integer>()); // -> 8 
        int resultOpt5 = minChangeOptimized(2017, new int[]{4, 2, 10}, new HashMap<Integer, Integer>()); // -> -1

        System.out.println();
        System.out.println("OPTIMIZED : AMOUNT = 8,  COINS = [1, 5, 4, 12]         ; Expected => 2,  Actual => " + resultOpt1);
        System.out.println("OPTIMIZED : AMOUNT = 13, COINS = [1, 9, 5, 14, 30]     ; Expected => 5,  Actual => " + resultOpt2);
        System.out.println("OPTIMIZED : AMOUNT = 23, COINS = [2, 5, 7]             ; Expected => 4,  Actual => " + resultOpt3);
        System.out.println("OPTIMIZED : AMOUNT = 200, COINS = [1, 5, 10, 25]       ; Expected => 8,  Actual => " + resultOpt4);
        System.out.println("OPTIMIZED : AMOUNT = 2017, COINS = [4, 2, 10]          ; Expected =>-1,  Actual => " + resultOpt5);
        
    }

    private static int minChangeOptimizedHelper(int amount, int[] coins, HashMap<Integer, Integer> memo) {

        if(memo.containsKey(amount)) {
            return memo.get(amount);
        }

        if(amount == 0) {
            return 0;
        }

        if(amount < 0) {
            return Integer.MAX_VALUE - 2;
        }

        int minCoins = Integer.MAX_VALUE - 2;
        for(int coin : coins) {
            minCoins = Math.min(minCoins, 1 + minChangeOptimizedHelper(amount - coin, coins, memo));
        }

        memo.put(amount, minCoins);
        return memo.get(amount);
    }

    private static int minChangeOptimized(int amount, int[] coins, HashMap<Integer, Integer> memo) {
        int answer = minChangeOptimizedHelper(amount, coins, memo);

        if(answer == Integer.MAX_VALUE - 2) {
            return -1;
        } else {
            return answer;
        }

    }

    private static double minChange(int amount, int[] coins) {
        return minChangeHelper(amount, coins);
    }

    private static double minChangeHelper(int amount, int[] coins) {
        // Base case
        if(amount == 0) {
            return 0;
        }
        // If the number goes below 0 during recursion, return INFINITY, so that we will never choose this value when we do the min
        if(amount < 0) {
            return Double.POSITIVE_INFINITY;
        }

        double minCoins = Double.POSITIVE_INFINITY;
        // Loop through the coins and run recursively
        for (int coin : coins) {
            minCoins = Math.min(minCoins, 1 + minChange(amount - coin, coins));
        }

        return minCoins;
    }
}

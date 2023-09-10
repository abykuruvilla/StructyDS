package com.kaby.ds.dynamic;

import com.kaby.ds.helper.ResultPair;

import java.util.HashMap;

public class CountingChange {

    /**
     * Write a function, countingChange, that takes in an amount and an array of coins.
     * The function should return the number of different ways it is possible to make change for the given amount using the coins.
     *
     * You may reuse a coin as many times as necessary.
     *
     * For example,
     *
     * countingChange(4, new int[] {1,2,3}) -> 4
     *
     * There are four different ways to make an amount of 4:
     * 1. 1 + 1 + 1 + 1
     * 2. 1 + 1 + 2
     * 3. 1 + 3
     * 4. 2 + 2
     * @param args
     */
    public static void main(String[] args) {

        // == test_00: ==

        long numOfWays0 = countingChange(4, new int[] {1, 2, 3}); // -> 4
        ResultPair<Long, Long> resultPair0 = new ResultPair<>("Num of ways to count change is ",4L ,numOfWays0);
        resultPair0.printResultPair();

        // == test_01: ==

        long numOfWays1 = countingChange(8, new int[] {1, 2, 3}); // -> 10
        ResultPair<Long, Long> resultPair1 = new ResultPair<>("Num of ways to count change is ",10L ,numOfWays1);
        resultPair1.printResultPair();

        // == test_02: ==

        long numOfWays2 = countingChange(24, new int[] {5, 7, 3}); // -> 5
        ResultPair<Long, Long> resultPair2 = new ResultPair<>("Num of ways to count change is ",5L ,numOfWays2);
        resultPair2.printResultPair();

        // == test_03: ==

        long numOfWays3 = countingChange(13, new int[] {2, 6, 12, 10}); // -> 0
        ResultPair<Long, Long> resultPair3 = new ResultPair<>("Num of ways to count change is ",0L ,numOfWays3);
        resultPair3.printResultPair();

        // == test_04:

        long numOfWays4 = countingChange(512, new int[] {1, 5, 10, 25}); // -> 20119
        ResultPair<Long, Long> resultPair4 = new ResultPair<>("Num of ways to count change is ",20119L ,numOfWays4);
        resultPair4.printResultPair();

        // == test_05: ==

        long numOfWays5 = countingChange(1000, new int[] {1, 5, 10, 25}); // -> 142511
        ResultPair<Long, Long> resultPair5 = new ResultPair<>("Num of ways to count change is ",142511L ,numOfWays5);
        resultPair5.printResultPair();

        // == test_06: ==

        long numOfWays6 = countingChange(240, new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9}); // -> 1525987916
        ResultPair<Long, Long> resultPair6 = new ResultPair<>("Num of ways to count change is ",1525987916L ,numOfWays6);
        resultPair6.printResultPair();

    }

    /**
     * The strategy for this one is to how many quantities of each coin type can I use to get to the amount, starting from 0x.
     * We ignore going down any number of times, where for the coin type we cannot reduce any further.
     * At the end for the number of sub problems where we end up with 0 is the num of total ways we can do a count.
     *
     * @param amount
     * @param coins
     * @return
     */

    private static long countingChange(int amount, int[] coins) {
//        return countChangeBruteForce(amount, coins, 0);

        // Note: take the items that change in the memo -> here it is amount and index
        return countChangeMemoized(amount, coins, 0, new HashMap<String, Long>());
    }

    private static long countChangeMemoized(int amount, int[] coins, int index, HashMap<String, Long> memo) {

        // Key for memo
        String key = amount + "," + index;

        // Return value from memo if available
        if(memo.containsKey(key)) {
            return memo.get(key);
        }

        // If the amount is 0, there is exactly 1 way to achieve that
        if(amount == 0) {
            return 1L;
        }

        // If index equal to length of coins return 0
        if(index == coins.length) {
            return 0;
        }

        // The coin value at the index passed
        int coinVal = coins[index];

        // Resulting total number of ways
        long totalWays = 0L;

        // Note: we start by taking no instances of the coin
        for(int quant = 0; (quant * coinVal) <= amount; quant++) {
            // Remainder after taking x times of a coin value
            int remainder = amount - (quant * coinVal);

            // Recursively call on the remainder, with updated index
            totalWays += countChangeMemoized(remainder, coins, index + 1, memo);
        }

        // Store in memo
        memo.put(key, totalWays);

        return totalWays;
    }

    private static long countChangeBruteForce(int amount, int[] coins, int index) {

        // If the amount is 0, there is exactly 1 way to achieve that
        if(amount == 0) {
            return 1L;
        }

        // If index equal to length of coins return 0
        if(index == coins.length) {
            return 0;
        }

        // The coin value at the index passed
        int coinVal = coins[index];

        // Resulting total number of ways
        long totalWays = 0L;

        // Note: we start by taking no instances of the coin
        for(int quant = 0; (quant * coinVal) <= amount; quant++) {
            // Remainder after taking x times of a coin value
            int remainder = amount - (quant * coinVal);

            // Recursively call on the remainder, with updated index
            totalWays += countChangeBruteForce(remainder, coins, index + 1);
        }

        return totalWays;
    }
}

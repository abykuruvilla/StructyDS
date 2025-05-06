package com.kaby.ds.mixed;

import com.kaby.ds.helper.ResultPair;

import java.util.HashMap;
import java.util.Map;

// DYNAMIC PROGRAMMING
public class BreakingBoundaries {

    /**
     * Write a function, breakingBoundaries, that takes in 5 arguments: a number of rows (m), a number of columns (n),
     * a number of moves (k), a starting row (r), and a starting column (c). Say you were situated in a grid with
     * dimensions m * n. If you had to start at position (r,c), in how many different ways could you move out of bounds
     * if you could take at most k moves. A single move is moving one space up, down, left, or right. During a path you
     * may revisit a position.
     * <p>
     * For example:
     * <p>
     * Given m, n, k, r, c:
     * <p>
     * 3, 4, 2, 0, 0
     * <p>
     * This input asks us to count the numbers of ways
     * to move out of bounds in a 3 by 4 grid, starting at
     * position (0, 0) if we could take at most 2 moves.
     * <p>
     * The answer is 4 because of these 4 distinct ways:
     * 1. left
     * 2. up
     * 3. right, up
     * 4. down, left
     * <p>
     * The function should return a number representing how many ways you can move out of bounds.
     *
     * @param args
     */
    public static void main(String[] args) {

        // == test_00: ==

        int numWays1 = breakingBoundaries(3, 4, 2, 0, 0); // -> 4
        ResultPair<Integer, Integer> resultPair1 = new ResultPair<>("Number of ways to move out of bounds is : ", 4, numWays1);
        resultPair1.assertMatch();

        // == test_01: ==

        int numWays2 = breakingBoundaries(2, 2, 2, 1, 1); // -> 6
        ResultPair<Integer, Integer> resultPair2 = new ResultPair<>("Number of ways to move out of bounds is : ", 6, numWays2);
        resultPair2.assertMatch();

        // == test_03: ==

        int numWays3 = breakingBoundaries(4, 4, 5, 2, 1); // -> 160
        ResultPair<Integer, Integer> resultPair3 = new ResultPair<>("Number of ways to move out of bounds is : ", 160, numWays3);
        resultPair3.assertMatch();

        // == test_06: ==

        int numWays4 = breakingBoundariesOptimized(6, 6, 15, 3, 4); // -> 40787896
        ResultPair<Integer, Integer> resultPair4 = new ResultPair<>("Number of ways to move out of bounds is : ", 40787896, numWays4);
        resultPair4.assertMatch();

        // == test_07: ==

        int numWays5 = breakingBoundariesOptimized(6, 8, 16, 2, 1); // -> 137495089
        ResultPair<Integer, Integer> resultPair5 = new ResultPair<>("Number of ways to move out of bounds is : ", 137495089, numWays5);
        resultPair5.assertMatch();

    }

    // == BRUTE FORCE SOLUTION ==
    // O(4^k) - Exponential - Time since 4 ways to move and each we can move k times

    private static int breakingBoundaries(int m, int n, int k, int r, int c) {
        // m x n is size of grid, k is num of moves possible, r and c are row column we start with

        // BASE CASE - given position is out of bounds, means we can no longer explore further and there is exactly one way to get here
        if (r < 0 || r >= m || c < 0 || c >= n) {
            return 1;
        }
        // ANOTHER BASE CASE - we have exhausted our moves k
        if (k == 0) {
            return 0;
        }

        // We want to count total ways we can move out of bounds
        int totalCount = 0;

        // The 4 possible moves are UP, DOWN, LEFT RIGHT
        // UP
        totalCount += breakingBoundaries(m, n, k - 1, r - 1, c);
        // DOWN
        totalCount += breakingBoundaries(m, n, k - 1, r + 1, c);
        // LEFT
        totalCount += breakingBoundaries(m, n, k - 1, r, c - 1);
        // RIGHT
        totalCount += breakingBoundaries(m, n, k - 1, r, c + 1);

        return totalCount;
    }


    // == OPTIMIZED SOLUTION USING MEMOIZATION ==
    // O(mnk) - Time

    private static int breakingBoundariesOptimized(int m, int n, int k, int r, int c) {
        Map<String, Integer> memo = new HashMap<>();
        return breakingBoundariesMemoHelper(m, n, k, r, c, memo);
    }

    private static int breakingBoundariesMemoHelper(int m, int n, int k, int r, int c, Map<String, Integer> memo) {
        // m x n is size of grid, k is num of moves possible, r and c are row column we start with

        // Using k, r and c which change every recursive call
        String key = k + "," + r + "," + c;
        // Check in memo first
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        // BASE CASE - given position is out of bounds, means we can no longer explore further and there is exactly one way to get here
        if (r < 0 || r >= m || c < 0 || c >= n) {
            return 1;
        }
        // ANOTHER BASE CASE - we have exhausted our moves k
        if (k == 0) {
            return 0;
        }

        // We want to count total ways we can move out of bounds
        int totalCount = 0;

        // The 4 possible moves are UP, DOWN, LEFT RIGHT
        // UP
        totalCount += breakingBoundariesMemoHelper(m, n, k - 1, r - 1, c, memo);
        // DOWN
        totalCount += breakingBoundariesMemoHelper(m, n, k - 1, r + 1, c, memo);
        // LEFT
        totalCount += breakingBoundariesMemoHelper(m, n, k - 1, r, c - 1, memo);
        // RIGHT
        totalCount += breakingBoundariesMemoHelper(m, n, k - 1, r, c + 1, memo);

        // Store the totalCount for key
        memo.put(key, totalCount);

        return memo.get(key);
    }
}

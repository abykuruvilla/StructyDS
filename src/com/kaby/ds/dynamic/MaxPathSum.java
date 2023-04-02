package com.kaby.ds.dynamic;

import com.kaby.ds.helper.ResultPair;

import java.util.HashMap;

public class MaxPathSum {

    /**
     * Write a function, maxPathSum, that takes in a grid as an argument. The function should return the maximum sum
     * possible by traveling a path from the top-left corner to the bottom-right corner. You may only travel through the
     * grid by moving down or right.
     * <p>
     * You can assume that all numbers are non-negative.
     *
     * @param args
     */
    public static void main(String[] args) {

//        const grid = [
//          [1, 3, 12],
//          [5, 1, 1],
//          [3, 6, 1],
//        ];
//        maxPathSum(grid); // -> 18

        Integer[][] grid1 = new Integer[][]{
                {1, 3, 12},
                {5, 1, 1},
                {3, 6, 1},
        };

        Integer actual1 = maxPathSum(grid1); // -> 18
        ResultPair<Integer, Integer> resultPair1 = new ResultPair<>("The max path sum for grid1 is ", 18, actual1);
        resultPair1.printResultPair();

        Integer[][] grid2 = new Integer[][]{
                {1, 1, 3, 1, 1, 1, 1, 4, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 2, 1, 1, 6, 1, 1, 5, 1, 1, 0, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 5, 1, 1, 1, 1, 0, 1, 1, 1, 1},
                {2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {2, 1, 1, 1, 1, 8, 1, 1, 1, 1, 1, 1, 1},
                {2, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 9, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 8, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        };
        Integer actual2 = maxPathSum(grid2); // -> 56
        ResultPair<Integer, Integer> resultPair2 = new ResultPair<>("The max path sum for grid2 is ", 56, actual2);
        resultPair2.printResultPair();


    }

    private static Integer maxPathSum(Integer[][] grid) {

        return maxPathSum(grid, 0, 0, new HashMap<String, Integer>());

    }

    private static Integer maxPathSum(Integer[][] grid, int row, int col, HashMap<String, Integer> memo) {

        // Doing some memoization
        String pos = row + "," + col;
        // If we already computed the value return from the memo
        if (memo.containsKey(pos)) {
            return memo.get(pos);
        }

        // I can only move right or down in the grid, hence
        // See if we are within bounds of the grid
        if (row == grid.length || col == grid[0].length) {
            // Since we will be doing max value largest later,
            // let's return the least possible value
            return Integer.MIN_VALUE;
        }

        // Another base case is to check if I have reached the bottom right corner
        if (row == grid.length - 1 && col == grid[0].length - 1) {
            return grid[row][col];
        }

        // recursively call the bottom value and the right value
        int maxPathSumGoingDown = maxPathSum(grid, row + 1, col, memo);
        int maxPathSumGoingRight = maxPathSum(grid, row, col + 1, memo);

        // We add the max of either going down or going right to the root
        memo.put(pos, grid[row][col] + Math.max(maxPathSumGoingDown, maxPathSumGoingRight));

        return memo.get(pos);
    }
}

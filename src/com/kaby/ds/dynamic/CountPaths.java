package com.kaby.ds.dynamic;

import java.util.HashMap;

public class CountPaths {

    /**
     * Write a function, countPaths, that takes in a grid as an argument.
     * In the grid, 'X' represents walls and 'O' represents open spaces.
     * You may only move down or to the right and cannot pass through walls.
     * The function should return the number of ways possible to travel from the
     * top-left corner of the grid to the bottom-right corner.
     *
     * @param args
     */
    public static void main(String[] args) {

        String[][] grid1 = new String[][]{
                {"O", "O"},
                {"O", "O"},
        };
        String[][] grid2 = new String[][]{
                {"O", "O", "X"},
                {"O", "O", "O"},
                {"O", "O", "O"},
        };
        String[][] grid3 = new String[][]{
                {"O", "O", "O"},
                {"O", "X", "X"},
                {"O", "O", "O"},
        };
        String[][] grid4 = new String[][]{
                {"O", "O", "X", "O", "O", "O"},
                {"O", "O", "O", "O", "O", "X"},
                {"X", "O", "O", "O", "O", "O"},
                {"X", "X", "X", "O", "O", "O"},
                {"O", "O", "O", "O", "O", "O"},
        };
        String[][] grid5 = new String[][]{
                {"O", "O", "X", "O", "O", "O"},
                {"O", "O", "X", "O", "O", "O"},
                {"X", "O", "X", "O", "O", "O"},
                {"X", "X", "X", "O", "O", "O"},
                {"O", "O", "O", "O", "O", "O"},
        };

        int result1 = countPaths(grid1); // -> 2
        int result2 = countPaths(grid2); // -> 5
        int result3 = countPaths(grid3); // -> 1
        int result4 = countPaths(grid4); // -> 42
        int result5 = countPaths(grid5); // -> 0

        System.out.println("RESULT 1 ; EXPECTED => 2,  ACTUAL => " + result1);
        System.out.println("RESULT 2 ; EXPECTED => 5,  ACTUAL => " + result2);
        System.out.println("RESULT 3 ; EXPECTED => 1,  ACTUAL => " + result3);
        System.out.println("RESULT 4 ; EXPECTED => 42, ACTUAL => " + result4);
        System.out.println("RESULT 5 ; EXPECTED => 0,  ACTUAL => " + result5);


//        =========================================

        // BIG GRID
        String[][] grid6 = new String[][]{
                {"O", "O", "X", "X", "O", "O", "O", "X", "O", "O", "O", "O", "O", "O", "O"},
                {"O", "O", "X", "X", "O", "O", "O", "X", "O", "O", "O", "O", "O", "O", "O"},
                {"O", "O", "O", "X", "O", "O", "O", "X", "O", "O", "O", "O", "O", "O", "O"},
                {"X", "O", "O", "O", "O", "O", "O", "X", "O", "O", "O", "O", "O", "O", "O"},
                {"X", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O"},
                {"O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "X", "X", "O"},
                {"O", "O", "O", "O", "O", "O", "O", "X", "O", "O", "O", "O", "O", "X", "O"},
                {"O", "O", "O", "O", "O", "O", "O", "O", "X", "O", "O", "O", "O", "O", "O"},
                {"X", "X", "X", "O", "O", "O", "O", "O", "O", "X", "O", "O", "O", "O", "O"},
                {"O", "O", "O", "O", "X", "X", "O", "O", "O", "O", "X", "O", "O", "O", "O"},
                {"O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O"},
                {"O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O"},
                {"O", "O", "O", "O", "X", "X", "O", "O", "O", "O", "O", "O", "O", "O", "O"},
                {"O", "O", "O", "O", "O", "O", "O", "O", "X", "O", "O", "O", "O", "O", "O"},
                {"O", "O", "O", "O", "O", "O", "O", "O", "X", "O", "O", "O", "O", "O", "O"},
        };

        int result6 = countPathsOptimized(grid6); // -> 3190434

        System.out.println("\nOPTIMIZED : RESULT 6 ; EXPECTED => 3190434,  ACTUAL => " + result6);


    }

    private static int countPathsOptimized(String[][] grid) {
        System.out.println("==================");
        System.out.println("Array Size = " + grid.length + "," + grid[0].length);

        // We start at position 0,0
        return countPathsOptimizedHelper(grid, 0, 0, new HashMap<String, Integer>());
    }

    private static int countPathsOptimizedHelper(String[][] grid, int row, int col, HashMap<String, Integer> memo) {
        // Key to memo hashmap
        String position = row + "," + col;

        // Check the HashMap to see if we have already computed
        if(memo.containsKey(position)) {
            return memo.get(position);
        }

        // Base Case: Out of bounds protection
        // Also we cannot go through walls marked with 'X'
        if (row == grid.length || col == grid[0].length || grid[row][col] == "X") {
            return 0;
        }

        // Base Case: We have reached the bottom right corner
        // There is only one way to go from the bottom right corner to the bottom right corner
        if (row == grid.length - 1 && col == grid[0].length - 1) {
            return 1;
        }

        // There are only two ways to move
        // DOWN: get the count moving downwards
        int downCount = countPathsOptimizedHelper(grid, row + 1, col, memo);
        // RIGHT: get the count moving right
        int rightCount = countPathsOptimizedHelper(grid, row, col + 1, memo);

        // We need to bubble up the value hence add
        // Store the computed position in the Map
        memo.put(position, downCount + rightCount);

        return memo.get(position);

    }

    private static int countPaths(String[][] grid) {

        System.out.println("==================");
        System.out.println("Array Size = " + grid.length + "," + grid[0].length);

        // We start at position 0,0
        return countPathsHelper(grid, 0, 0);
    }

    private static int countPathsHelper(String[][] grid, int row, int col) {
        // Base Case: Out of bounds protection
        // Also we cannot go through walls marked with 'X'
        if (row == grid.length || col == grid[0].length || grid[row][col] == "X") {
            return 0;
        }

        // Base Case: We have reached the bottom right corner
        // There is only one way to go from the bottom right corner to the bottom right corner
        if (row == grid.length - 1 && col == grid[0].length - 1) {
            return 1;
        }

        // There are only two ways to move
        // DOWN: get the count moving downwards
        int downCount = countPathsHelper(grid, row + 1, col);
        // RIGHT: get the count moving right
        int rightCount = countPathsHelper(grid, row, col + 1);

        // We need to bubble up the value hence add
        return downCount + rightCount;

    }
}

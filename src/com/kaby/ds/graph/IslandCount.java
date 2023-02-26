package com.kaby.ds.graph;


import com.kaby.ds.helper.ResultPair;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Write a function, islandCount, that takes in a grid containing Ws and Ls.
 * W represents water and L represents land. The function should return the number of islands on the grid.
 * An island is a vertically or horizontally connected region of land.
 */
public class IslandCount {

    public static void main(String[] args) {

//        const grid = [
//          ['W', 'L', 'W', 'W', 'W'],
//          ['W', 'L', 'W', 'W', 'W'],
//          ['W', 'W', 'W', 'L', 'W'],
//          ['W', 'W', 'L', 'L', 'W'],
//          ['L', 'W', 'W', 'L', 'L'],
//          ['L', 'L', 'W', 'W', 'W'],
//        ];
//
//        islandCount(grid); // -> 3

        String[][] grid = new String[][]{
                {"W", "L", "W", "W", "W"},
                {"W", "L", "W", "W", "W"},
                {"W", "W", "W", "L", "W"},
                {"W", "W", "L", "L", "W"},
                {"L", "W", "W", "L", "L"},
                {"L", "L", "W", "W", "W"},
        };

        System.out.println("Input grid is : \n" + Arrays.deepToString(grid).replace("], ", "],\n"));

        Integer islandCount1 = islandCount(grid);
        ResultPair<Integer, Integer> resultPair1 = new ResultPair<>("The island count is ", 3, islandCount1);
        resultPair1.printResultPair();

    }

    private static Integer islandCount(String[][] grid) {

        // track the visited nodes
        Set<String> visited = new HashSet<>();

        // track the count of the islands
        int count = 0;

        // iterate over each element of the grid until you encounter LAND,
        // and perform DFS until you exhaust every node in the component
        for(int row = 0; row < grid.length; row++) {
            for(int col = 0; col < grid[0].length; col++) {
                if(explore(grid, row, col, visited) == true) {
                    // we have explored one full component, hence update the count
                    count += 1;
                }
            }
        }

        return count;
    }

    private static boolean explore(String[][] grid, int row, int col, Set<String> visited) {
        // check if the row and column passed in are in bounds
        boolean rowInBounds = row >= 0 && row < grid.length;
        boolean colInBounds = col >= 0 && col < grid[0].length;

        // if we are operating out of bounds of the grid return false
        if(!rowInBounds || !colInBounds) {
            return false;
        }

        // if we encounter WATER return false
        if(grid[row][col] == "W") {
            return false;
        }

        // row+col position
        String pos = row + ","  + col;

        // ok so this is not a position with WATER, so it has to be LAND
        // check if this position is already visited
        if (visited.contains(pos)) {
            return false;
        }

        // ok so this is a new position we have not visited, so let's mark it visited
        visited.add(pos);

        // for each position's  (R, C) neighbor in the grid  let's run DFS
        //     _____________________________
        //     |         | R-1, C |         |
        //     -----------------------------|
        //     | R, C-1  |  R, C  | R, C+1  |
        //     -----------------------------
        //     |         | R+1, C |         |
        //     -----------------------------
        explore(grid, row - 1, col, visited);
        explore(grid, row + 1, col, visited);
        explore(grid, row, col - 1, visited);
        explore(grid, row, col + 1, visited);

        // we have finished exploring the component, hence return true to go back to
        // searching the grid iteratively for th next starting LAND node
        return true;
    }
}

package com.kaby.ds.graph;

import com.kaby.ds.helper.ResultPair;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Write a function, minimumIsland, that takes in a grid containing Ws and Ls.
 * W represents water and L represents land. The function should return the size of the smallest island.
 * An island is a vertically or horizontally connected region of land.
 *
 * You may assume that the grid contains at least one island.
 */
public class MinimumIsland {

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
//        minimumIsland(grid); // -> 2

        String[][] grid = new String[][]{
                {"W", "L", "W", "W", "W"},
                {"W", "L", "W", "W", "W"},
                {"W", "W", "W", "L", "W"},
                {"W", "W", "L", "L", "W"},
                {"L", "W", "W", "L", "L"},
                {"L", "L", "W", "W", "W"},
        };

        System.out.println("Input grid is : \n" + Arrays.deepToString(grid).replace("], ", "],\n"));

        Integer islandCount1 = minimumIsland(grid);
        ResultPair<Integer, Integer> resultPair1 = new ResultPair<>("The minimum island count is ", 2, islandCount1);
        resultPair1.printResultPair();

    }

    private static Integer minimumIsland(String[][] grid) {

        // to track the visited nodes
        Set<String> visited = new HashSet<>();

        // to track the size of the minimum island, initialize with something very high
        Integer minIsland = Integer.MAX_VALUE;

        // iterate over each element of the grid until you see LAND
        // if you encounter LAND perform DFS on all its neighbors until the component is fully explored
        for(int row = 0; row < grid.length; row++) {
            for(int col = 0; col < grid[0].length; col++) {
                // this is the size of the component explored
                int size = exploreSize(grid, row, col, visited);
                // get the smallest known component
                // NOTE: we are looking for component sizes greater than 0
                if(size > 0) {
                    minIsland = Math.min(size, minIsland);
                }
            }
        }

        return minIsland;
    }

    private static Integer exploreSize(String[][] grid, int row, int col, Set<String> visited) {

        // check if the row and column indexes are within bounds
        boolean rowInbounds = row >= 0 && row < grid.length;
        boolean colInbounds = col >= 0 && col < grid[0].length;

        // if the row and column are not withing bounds return 0
        if(!rowInbounds || !colInbounds) {
            return 0;
        }

        // if we have encountered water
        if(grid[row][col] == "W") {
            return 0;
        }

        // current position
        String pos = row + "," + col;

        // if we have already encountered this position
        if(visited.contains(pos)) {
            return 0;
        }

        // we have encountered a new land position
        visited.add(pos);

        // initialize to 1 to take into account current node
        Integer componentSize = 1;

        // for each position's  (R, C) neighbor in the grid  let's run DFS
        //     _____________________________
        //     |         | R-1, C |         |
        //     -----------------------------|
        //     | R, C-1  |  R, C  | R, C+1  |
        //     -----------------------------
        //     |         | R+1, C |         |
        //     -----------------------------
        componentSize += exploreSize(grid, row - 1, col, visited);
        componentSize += exploreSize(grid, row + 1, col, visited);
        componentSize += exploreSize(grid, row, col - 1, visited);
        componentSize += exploreSize(grid, row, col + 1, visited);

        return componentSize;

    }
}

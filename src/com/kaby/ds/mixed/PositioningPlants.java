package com.kaby.ds.mixed;

import com.kaby.ds.helper.ResultPair;

import java.util.HashMap;
import java.util.Map;

// DYNAMIC PROGRAMMING
public class PositioningPlants {

    /**
     * You've been hired to plant flowers in a garden with n different positions. There are m different flower types.
     * The prices of flowers types vary depending on which position they are planted. Your bosses are picky,
     * they tell you to never plant two of the same flower type right next to each other. What is the minimum cost we
     * need to plant a flower in each position of the garden?
     * <p>
     * Write a function, positioningPlants, that takes in a 2D array with dimensions n * m. Each row of the array
     * represents the costs of the flower types at that position. This means that costs[i][j] represents the cost of
     * planting flower type j at position i.
     * <p>
     * For example:
     * Given these costs,
     * <p>
     * costs = [
     * [4, 3, 7],
     * [6, 1, 9],
     * [2, 5, 3]
     * ]
     * <p>
     * The costs of plants at position 1 are $6, $1, and $9.
     * The cost of planting flower type 0 at position 1 is $6.
     * The cost of planting flower type 2 at position 1 is $9.
     * <p>
     * The function should return the minimum cost of planting flowers without placing the same flower type in adjacent positions.
     *
     * @param args
     */
    public static void main(String[] args) {

        // == test_00: ==

        int minCost1 = positioningPlants(new int[][]{
                {4, 3, 7},
                {6, 1, 9},
                {2, 5, 3}
        }); // -> 7, by doing 4 + 1 + 2.
        int minCost4;
        ResultPair<Integer, Integer> resultPair1 = new ResultPair<>("The minimum cost of planting flowers is ", 7, minCost1);
        resultPair1.printResultPair();

        // == test_01: ==

        int minCost2 = positioningPlants(new int[][]{
                {12, 14, 5},
                {6, 3, 2}
        }); // -> 8
        ResultPair<Integer, Integer> resultPair2 = new ResultPair<>("The minimum cost of planting flowers is ", 8, minCost2);
        resultPair2.printResultPair();

        // == test_02: ==

        int minCost3 = positioningPlants(new int[][]{
                {12, 14, 5},
                {6, 3, 2},
                {4, 2, 7},
                {4, 8, 4},
                {1, 13, 5},
                {8, 6, 7},
        }); // -> 23
        ResultPair<Integer, Integer> resultPair3 = new ResultPair<>("The minimum cost of planting flowers is ", 23, minCost3);
        resultPair3.printResultPair();

        // == test_05: ==

        minCost4 = positioningPlantsOptimized(new int[][]{
                {12, 14, 50, 12, 13},
                {6, 3, 20, 3, 16},
                {24, 12, 7, 2, 74},
                {4, 80, 45, 3, 100},
                {104, 13, 5, 14, 3},
                {38, 19, 7, 6, 24},
                {1, 20, 1, 2, 31},
                {13, 12, 5, 13, 9},
                {60, 32, 20, 3, 2},
                {24, 12, 7, 2, 42},
                {4, 80, 44, 1, 23},
                {104, 13, 5, 14, 28},
                {38, 19, 76, 6, 12},
                {12, 23, 12, 20, 13},
                {1, 3, 1, 1, 50},
                {1, 2, 12, 5, 36},
                {6, 2, 3, 12, 20},
                {4, 6, 4, 11, 15},
        });
        ResultPair<Integer, Integer> resultPair4 = new ResultPair<>("The minimim cost of planting flowers is ", 75, minCost4);
        resultPair4.printResultPair();

    }

    // == BRUTE FORCE SOLUTION ==
    // O(m^n) Time
    private static int positioningPlants(int[][] costs) {
        // Call it with a starting position
        int pos = 0;
        // Initially the last plant chosen is null
        Integer lastPlant = null;
        return positioningPlantsHelper(costs, pos, lastPlant);
    }

    private static int positioningPlantsHelper(int[][] costs, int pos, Integer lastPlant) {
        // If we have reached the last position, the cost is 0
        if(pos == costs.length) {
            return 0;
        }

        // We are trying to determine a min cost, hence a good start value is the highest possible value
        int minCost = Integer.MAX_VALUE;

        // Iterate over each row, or the cost of planting each type
        // cost ->
        // {4, 3, 7},      ^
        // {6, 1, 9},      |
        // {2, 5, 3}   plant types
        for(Integer plant = 0; plant < costs[pos].length; plant++) {
            // We cannot have the same plant repeated in adjacent positions
            if(plant != lastPlant) {
                // My current plant becomes the last plant
                int candidateCost = costs[pos][plant] + positioningPlantsHelper(costs, pos + 1, plant);
                // We are finding minCost
                minCost = Math.min(minCost, candidateCost);
            }
        }

        return minCost;

    }

    // == OPTIMIZED MEMOIZED SOLUTION ==
    // O(nm) Time and Space
    private static int positioningPlantsOptimized(int[][] costs) {
        // Call it with a starting position
        int pos = 0;
        // Initially the last plant chosen is null
        Integer lastPlant = null;
        // Memo - Adding the changing elements as key
        // Key will be pos and lastPlant
        Map<String, Integer> memo = new HashMap<>();

        return positioningPlantsMemoHelper(costs, pos, lastPlant, memo);
    }

    private static int positioningPlantsMemoHelper(int[][] costs, int pos, Integer lastPlant, Map<String, Integer> memo) {

        String key = pos + "," + lastPlant;

        // Check the memo first
        if(memo.containsKey(key)) {
            return memo.get(key);
        }

        // If we have reached the last position, the cost is 0
        if(pos == costs.length) {
            return 0;
        }

        // We are trying to determine a min cost, hence a good start value is the highest possible value
        int minCost = Integer.MAX_VALUE;

        // Iterate over each row, or the cost of planting each type
        // cost ->
        // {4, 3, 7},      ^
        // {6, 1, 9},      |
        // {2, 5, 3}   plant types
        for(Integer plant = 0; plant < costs[pos].length; plant++) {
            // We cannot have the same plant repeated in adjacent positions
            if(plant != lastPlant) {
                // My current plant becomes the last plant
                int candidateCost = costs[pos][plant] + positioningPlantsMemoHelper(costs, pos + 1, plant, memo);
                // We are finding minCost
                minCost = Math.min(minCost, candidateCost);
            }
        }

        // Store the minCost for key
        memo.put(key, minCost);

        return memo.get(key);

    }

}

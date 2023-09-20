package com.kaby.ds.dynamic;

import com.kaby.ds.helper.ResultPair;

import java.util.HashMap;

public class KnightlyNumber {

    /**
     * A knight is on a chess board. Can you figure out the total number of ways the knight can move to a target
     * position in exactly m moves? On a single move, the knight can move in an "L" shape; two spaces in any direction,
     * then one space in a perpendicular direction. This means that on a single move, a knight has eight possible
     * positions it can move to.
     *
     * Write a function, knightlyNumber, that takes in 6 arguments:
     *
     * n, m, kr, kc, pr, pc
     *
     *     n = the length of the chess board
     *     m = the number of moves that must be used
     *     kr = the starting row of the knight
     *     kc = the starting column of the knight
     *     pr = the target row
     *     pc = the target column
     *
     * The function should return the number of different ways the knight can move to the target (pawn) in exactly m moves.
     * The knight can revisit positions of the board if needed. The knight cannot move out-of-bounds of the board.
     * You can assume that rows and columns are 0-indexed. This means that if n = 8, there are 8 rows and 8 columns numbered 0 to 7.
     *
     * @param args
     */
    public static void main(String[] args) {

        // == test_00: ==

        int result0 = knightlyNumber(8, 2, 4, 4, 5, 5); // -> 2
        ResultPair<Integer, Integer> resultPair0 = new ResultPair<>("Number of ways the knight can reach the target in m moves is", 2, result0);
        resultPair0.printResultPair();

        // == test_01: ==

        int result1 = knightlyNumber(8, 2, 7, 1, 7, 1); // -> 3
        ResultPair<Integer, Integer> resultPair1 = new ResultPair<>("Number of ways the knight can reach the target in m moves is", 3, result1);
        resultPair1.printResultPair();

        // == test_02: ==

        int result2 = knightlyNumber(8, 2, 5, 4, 5, 4); // -> 8
        ResultPair<Integer, Integer> resultPair2 = new ResultPair<>("Number of ways the knight can reach the target in m moves is", 8, result2);
        resultPair2.printResultPair();

        // == test_03: ==

        int result3 = knightlyNumber(8, 3, 5, 2, 4, 4); // -> 21
        ResultPair<Integer, Integer> resultPair3 = new ResultPair<>("Number of ways the knight can reach the target in m moves is", 21, result3);
        resultPair3.printResultPair();

        // == test_04: ==

        int result4 = knightlyNumber(20, 6, 18, 7, 10, 15); // -> 60
        ResultPair<Integer, Integer> resultPair4 = new ResultPair<>("Number of ways the knight can reach the target in m moves is", 60, result4);
        resultPair4.printResultPair();

        // == test_05: ==

        int result5 = knightlyNumber(20, 12, 8, 3, 9, 14); // -> 98410127
        ResultPair<Integer, Integer> resultPair5 = new ResultPair<>("Number of ways the knight can reach the target in m moves is", 98410127, result5);
        resultPair5.printResultPair();

        // == test_06: ==

        int result6 = knightlyNumber(8, 2, 0, 0, 1, 1); // -> 0
        ResultPair<Integer, Integer> resultPair6 = new ResultPair<>("Number of ways the knight can reach the target in m moves is", 0, result6);
        resultPair6.printResultPair();


    }

    private static int knightlyNumber(int n, int m, int kr, int kc, int pr, int pc) {

//        return knightlyNumberBF(n, m, kr, kc, pr, pc);
        return knightlyNumberMemoized(n, m, kr, kc, pr, pc, new HashMap<String, Integer>());

    }

    private static int knightlyNumberMemoized(int n, int m, int kr, int kc, int pr, int pc, HashMap<String, Integer> memo) {

        // The values that change are m, kr and kc, the combination of those becomes the key of the memo
        String key = m + "," + kr + "," + kc;

        // Check memo first
        if(memo.containsKey(key)) {
            return memo.get(key);
        }

        // Make sure our knight is in bounds, if out of bounds this is an illegal path
        if(kr < 0 || kr >= n || kc < 0 || kc >= n) {
            return 0;
        }

        // if no more moves are left
        if(m == 0) {
            // if the knight position equal to the target pawn position, we have found one way to reach target
            if(kr == pr && kc == pc) {
                return 1;
            } else {
                // we could not find a way to reach our target at the end of the moves
                return 0;
            }
        }

        // all possible neighbor positions the knight can move to - there should be 8 ways
        int[][] neighborPositions = new int[][] {
                {kr - 2, kc - 1},
                {kr - 2, kc + 1},
                {kr + 2, kc - 1},
                {kr + 2, kc + 1},
                {kr - 1, kc - 2},
                {kr - 1, kc + 2},
                {kr + 1, kc - 2},
                {kr + 1, kc + 2}
        };

        // Total count of ways to reach target
        int count = 0;

        // Recursively we try to reach pawn target from each neighbor position
        for(int[] neighborPos : neighborPositions) {
            int neighborRow = neighborPos[0];
            int neighborCol = neighborPos[1];

            // Note: number of moves reduces by 1
            // This should return a count of ways starting at neighbor position to reach pawn target
            count += knightlyNumberMemoized(n, m - 1, neighborRow, neighborCol, pr, pc, memo);
        }

        // Store count to memo
        memo.put(key, count);

        return count;
    }

    private static int knightlyNumberBF(int n, int m, int kr, int kc, int pr, int pc) {

        // Make sure our knight is in bounds, if out of bounds this is an illegal path
        if(kr < 0 || kr >= n || kc < 0 || kc >= n) {
            return 0;
        }

        // if no more moves are left
        if(m == 0) {
            // if the knight position equal to the target pawn position, we have found one way to reach target
            if(kr == pr && kc == pc) {
                return 1;
            } else {
                // we could not find a way to reach our target at the end of the moves
                return 0;
            }
        }

        // all possible neighbor positions the knight can move to - there should be 8 ways
        int[][] neighborPositions = new int[][] {
                {kr - 2, kc - 1},
                {kr - 2, kc + 1},
                {kr + 2, kc - 1},
                {kr + 2, kc + 1},
                {kr - 1, kc - 2},
                {kr - 1, kc + 2},
                {kr + 1, kc - 2},
                {kr + 1, kc + 2}
        };

        // Total count of ways to reach target
        int count = 0;

        // Recursively we try to reach pawn target from each neighbor position
        for(int[] neighborPos : neighborPositions) {
            int neighborRow = neighborPos[0];
            int neighborCol = neighborPos[1];

            // Note: number of moves reduces by 1
            // This should return a count of ways starting at neighbor position to reach pawn target
            count += knightlyNumber(n, m - 1, neighborRow, neighborCol, pr, pc);
        }

        return count;
    }
}

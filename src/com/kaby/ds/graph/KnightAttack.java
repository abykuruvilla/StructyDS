package com.kaby.ds.graph;

import com.kaby.ds.helper.ResultPair;
import com.kaby.ds.helper.Triplet;

import java.util.*;

public class KnightAttack {

    /**
     * A knight and a pawn are on a chess board. Can you figure out the minimum number of moves required for the knight
     * to travel to the same position of the pawn? On a single move, the knight can move in an "L" shape; two spaces in
     * any direction, then one space in a perpendicular direction. This means that on a single move, a knight has eight
     * possible positions it can move to.
     * <p>
     * Write a function, knightAttack, that takes in 5 arguments:
     * <p>
     * n, kr, kc, pr, pc
     * <p>
     * n = the length of the chess board
     * kr = the starting row of the knight
     * kc = the starting column of the knight
     * pr = the row of the pawn
     * pc = the column of the pawn
     * <p>
     * The function should return a number representing the minimum number of moves required for the knight to land
     * on top of the pawn. The knight cannot move out-of-bounds of the board. You can assume that rows and columns are
     * 0-indexed. This means that if n = 8, there are 8 rows and 8 columns numbered 0 to 7. If it is not possible for
     * the knight to attack the pawn, then return null.
     *
     * @param args
     */
    public static void main(String[] args) {

        // == test_00: ==

        Integer result0 = knightAttack(8, 1, 1, 2, 2); // -> 2
        ResultPair<Integer, Integer> resultPair0 = new ResultPair<>("Knight Attack - Min number of moves for knight to hit pawn ", 2, result0);
        resultPair0.assertMatch();

        // == test_01: ==

        Integer result1 = knightAttack(8, 1, 1, 2, 3); // -> 1
        ResultPair<Integer, Integer> resultPair1 = new ResultPair<>("Knight Attack - Min number of moves for knight to hit pawn ", 1, result1);
        resultPair1.assertMatch();

        // == test_02: ==

        Integer result2 = knightAttack(8, 0, 3, 4, 2); // -> 3
        ResultPair<Integer, Integer> resultPair2 = new ResultPair<>("Knight Attack - Min number of moves for knight to hit pawn ", 3, result2);
        resultPair2.assertMatch();

        // == test_03: ==

        Integer result3 = knightAttack(8, 0, 3, 5, 2); // -> 4
        ResultPair<Integer, Integer> resultPair3 = new ResultPair<>("Knight Attack - Min number of moves for knight to hit pawn ", 4, result3);
        resultPair3.assertMatch();

        // == test_04: ==

        Integer result4 = knightAttack(24, 4, 7, 19, 20); // -> 10
        ResultPair<Integer, Integer> resultPair4 = new ResultPair<>("Knight Attack - Min number of moves for knight to hit pawn ", 10, result4);
        resultPair4.assertMatch();

        // == test_05: ==

        Integer result5 = knightAttack(100, 21, 10, 0, 0); // -> 11
        ResultPair<Integer, Integer> resultPair5 = new ResultPair<>("Knight Attack - Min number of moves for knight to hit pawn ", 11, result5);
        resultPair5.assertMatch();

        // == test_06: ==

        Integer result6 = knightAttack(3, 0, 0, 1, 2); // -> 1
        ResultPair<Integer, Integer> resultPair6 = new ResultPair<>("Knight Attack - Min number of moves for knight to hit pawn ", 1, result6);
        resultPair6.assertMatch();

        // == test_07: ==

        Integer result7 = knightAttack(3, 0, 0, 1, 1); // -> null
        ResultPair<Integer, Integer> resultPair7 = new ResultPair<>("Knight Attack - Min number of moves for knight to hit pawn ", null, result7);
        resultPair7.assertMatch();

    }

    private static Integer knightAttack(int n, int kr, int kc, int pr, int pc) {

        // Keep track of visited positions
        Set<String> visited = new HashSet<>();

        // The best way to implement this is through BFS, which requires a queue
        // The queue tracks the position on the board and how many moves we have made for the knight
        Queue<Triplet> queue = new LinkedList<>();
        // Initial moves of the knight is 0
        queue.offer(Triplet.of(kr, kc, 0));

        // Iterate over the queue till it is empty
        while (!queue.isEmpty()) {
            // Remove front of queue, and unpack triplet
            Triplet<Integer, Integer, Integer> current = queue.poll();
            int r = current.first;
            int c = current.second;
            int step = current.third;

            // Check if current position equals pawn position, if yes return steps
            if (r == pr && c == pc) {
                return step;
            }

            // We have not reached pawn, so check neighbors the knight can move to from current position
            List<List<Integer>> neighbors = getKnightMoves(n, r, c);

            // Iterate over each of the neighbors
            for (List<Integer> neighbor : neighbors) {
                int neighborRow = neighbor.get(0);
                int neighborCol = neighbor.get(1);

                String neighborKey = neighborRow + "," + neighborCol;

                // If we have not already visited the position add it to the queue with an updated step count
                if (!visited.contains(neighborKey)) {
                    visited.add(neighborKey);
                    queue.offer(Triplet.of(neighborRow, neighborCol, step + 1));
                }
            }
        }

        // The knight was not able to attack the pawn, return null
        return null;

    }

    // Helper function to get possible knight moves from current position
    private static List<List<Integer>> getKnightMoves(int n, int r, int c) {
        var positions = List.of(
                List.of(r + 2, c + 1),
                List.of(r - 2, c + 1),
                List.of(r + 2, c - 1),
                List.of(r - 2, c - 1),
                List.of(r + 1, c + 2),
                List.of(r - 1, c + 2),
                List.of(r + 1, c - 2),
                List.of(r - 1, c - 2)
        );

        // check if positions are in bounds
        List<List<Integer>> inboundPositions = new ArrayList<>();

        for (List<Integer> position : positions) {
            int newRow = position.get(0);
            int newCol = position.get(1);

            // Check if position is in bounds
            if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n) {
                inboundPositions.add(new ArrayList<>(Arrays.asList(newRow, newCol)));
            }
        }

        return inboundPositions;

    }
}

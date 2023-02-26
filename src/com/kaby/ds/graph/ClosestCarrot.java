package com.kaby.ds.graph;

import com.kaby.ds.graph.models.GridPosition;
import com.kaby.ds.helper.Pair;
import com.kaby.ds.helper.ResultPair;

import java.util.*;

/**
 * Write a function, closestCarrot, that takes in a grid, a starting row, and a starting column.
 * In the grid, 'X's are walls, 'O's are open spaces, and 'C's are carrots.
 * The function should return a number representing the length of the shortest path from the
 * starting position to a carrot. You may move up, down, left, or right, but cannot pass through walls (X).
 * If there is no possible path to a carrot, then return -1.
 */
public class ClosestCarrot {

    public static void main(String[] args) {
//        const grid = [
//          ['O', 'O', 'O', 'O', 'O'],
//          ['O', 'X', 'O', 'O', 'O'],
//          ['O', 'X', 'X', 'O', 'O'],
//          ['O', 'X', 'C', 'O', 'O'],
//          ['O', 'X', 'X', 'O', 'O'],
//          ['C', 'O', 'O', 'O', 'O'],
//        ];
//
//        closestCarrot(grid, 1, 2); // -> 4

        String[][] grid = new String[][]{
                {"O", "O", "O", "O", "O"},
                {"O", "X", "O", "O", "O"},
                {"O", "X", "X", "O", "O"},
                {"O", "X", "C", "O", "O"},
                {"O", "X", "X", "O", "O"},
                {"C", "O", "O", "O", "O"},
        };

        System.out.println("Input grid is : \n" + Arrays.deepToString(grid).replace("], ", "],\n"));

        Integer closestCarrotDist = closestCarrot(grid, 1, 2);
        ResultPair<Integer, Integer> resultPair1 = new ResultPair<>("The closest carrot  is at a distance of ", 4, closestCarrotDist);
        resultPair1.printResultPair();

    }

    private static Integer closestCarrot(String[][] grid, int rowId, int colId) {

        // Let us do BFS to find the closest carrot
        // There might be multiple carrots on the grid.
        // When we encounter a carrot using BFS it is at the shortest distance from
        // the start as we are exploring all the neighbors of the node
        Queue<Pair<GridPosition, Integer>> queue = new LinkedList<>();

        // Let's keep track of the visited nodes
        Set<GridPosition> visited = new HashSet<>();
        // Let's add the starting node to the Set of visited positions
        visited.add(new GridPosition(rowId, colId));

        // Assuming that the start position is not a wall
        // The starting node is at a distance of ZERO from itself
        queue.offer(new Pair<>(new GridPosition(rowId, colId), 0));

        while(!queue.isEmpty()) {
            // Get the node off of the beginning of the queue
            Pair<GridPosition, Integer> currentNode = queue.poll();

            // If the current node is the carrot return the distance from the start node
            if(grid[currentNode.getValA().getRowId()][currentNode.getValA().getColId()].equals("C")) {
                return currentNode.getValB();
            }

            // The current node is not a carrot, so let's explore the neighbors of the current node
            // that just left the queue.
            for(GridPosition neighbor : getListOfNeighbors(currentNode.getValA().getRowId(), currentNode.getValA().getColId())) {
                // If the neighbor nodes are within bounds and the position does not represent a wall,
                // let's add to the queue for exploration, if not visited already.
                // The distance from the startNode is 1 more than the current Node
                if(neighborWithinBounds(neighbor, grid.length, grid[0].length) && !neighborIsAWall(grid, neighbor) && !visited.contains(neighbor)) {
                    queue.offer(new Pair<>(neighbor, currentNode.getValB() + 1));
                    visited.add(neighbor);
                }

            }
        }

        System.out.println("Visited = " + visited);

        // Looks like we did not find a carrot, so return -1
        return -1;
    }

    private static boolean neighborWithinBounds(GridPosition neighbor, int numOfRows, int numOfCols) {
        boolean rowInBounds = neighbor.getRowId() >= 0 && neighbor.getRowId() < numOfRows;
        boolean colInBounds = neighbor.getColId() >= 0 && neighbor.getColId() < numOfCols;

        return rowInBounds && colInBounds;
    }

    private static boolean neighborIsAWall(String[][] grid, GridPosition neighbor) {
        return grid[neighbor.getRowId()][neighbor.getColId()].equals("X");
    }

    private static List<GridPosition> getListOfNeighbors(int rowId, int colId) {
        List<GridPosition> neighborPositions = new ArrayList<>();

        // R-1, C
        neighborPositions.add(new GridPosition(rowId - 1, colId));
        // R+1, C
        neighborPositions.add(new GridPosition(rowId + 1, colId));
        // R, C-1
        neighborPositions.add(new GridPosition(rowId, colId - 1));
        // R, C+1
        neighborPositions.add(new GridPosition(rowId, colId + 1));

        return neighborPositions;
    }

}

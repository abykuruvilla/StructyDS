package com.kaby.ds.graph;

import com.kaby.ds.graph.models.GridPosition;
import com.kaby.ds.helper.Pair;
import com.kaby.ds.helper.ResultPair;

import java.util.*;

public class BestBridge {

    // SIMILAR TO CLOSEST CARROT

    /**
     * Write a function, bestBridge, that takes in a grid as an argument.
     * The grid contains water (W) and land (L). There are exactly two islands in the grid.
     * An island is a vertically or horizontally connected region of land. Return the minimum length
     * bridge needed to connect the two islands. A bridge does not need to form a straight line.
     *
     * @param args
     */
    public static void main(String[] args) {

//        const grid = [
//             0    1    2    3    4
//         0 ["W", "W", "W", "L", "L"],
//         1 ["L", "L", "W", "W", "L"],
//         2 ["L", "L", "L", "W", "L"],
//         3 ["W", "L", "W", "W", "W"],
//         4 ["W", "W", "W", "W", "W"],
//         5 ["W", "W", "W", "W", "W"],
//        ];
//        bestBridge(grid); // -> 1   

        String[][] grid = new String[][]{
                {"W", "W", "W", "L", "L"},
                {"L", "L", "W", "W", "L"},
                {"L", "L", "L", "W", "L"},
                {"W", "L", "W", "W", "W"},
                {"W", "W", "W", "W", "W"},
                {"W", "W", "W", "W", "W"},
        };

        int bestBridgeDistance1 = bestBridge(grid); // -> 1
        ResultPair<Integer, Integer> resultPair1 = new ResultPair<>("The shortest/best bridge distance between the two islands is : ", 1, bestBridgeDistance1);
        resultPair1.assertMatch();

    }

    private static int bestBridge(String[][] grid) {

        // The nodes in the grid representing the main island
        Set<GridPosition> mainIsland = new HashSet<>();

        // Visited nodes
        Set<GridPosition> visited = new HashSet<>();

        // Let us first try to first find one of the islands
        // NOTE: The 'break' DOES NOT get you out of the outer for loop, had to use a named block for that
        // Without this it just continues even after the first main island is encountered
        outerloop:
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                // This will give a possible island that we are building up with each iteration
                Set<GridPosition> possibleIsland = traverseIsland(grid, row, col, visited);

                // If we already have a possible island found let us stop our search
                if (possibleIsland.size() > 0) {
                    // DANGER NOTE: if you equate possible island to mainIsland, when you add nodes to visited that
                    // will get added to mainIsland since they are the same object
                    mainIsland.addAll(possibleIsland);
                    break outerloop;
                }
            }
        }
        System.out.println("MAIN ISLAND = " + mainIsland);

        // Now let us use BFS to find the shortest distance to the next island
        // The queue will store the row+col position and the distance from the main island
        Queue<Pair<GridPosition, Integer>> queue = new LinkedList<>();

        // We will do BFS for the nodes of the main island
        for (GridPosition position : mainIsland) {
            // Initialize each of the nodes in the main island at a distance of 0 from itself
            queue.offer(new Pair<>(position, 0));
        }

        while (!queue.isEmpty()) {
            // Remove the element from front of queue
            Pair<GridPosition, Integer> currentPositionAndDist = queue.poll();

            // We want to make sure that this currentPOsition belongs to the next island
            // If we have encountered LAND on the next island return the distance
            GridPosition currentPos = currentPositionAndDist.getValA();

            // If the position is LAND and is not part of the main island this has to be in the second island,
            // so let's return the distance
            if ("L".equals(grid[currentPos.getRowId()][currentPos.getColId()]) && !mainIsland.contains(currentPositionAndDist.getValA())) {
                // We will be off by 1 for the distance as we start from 0, so reduce the distance by 1
                return currentPositionAndDist.getValB() - 1;
            }

            // Let us look at the 4 neighbors of this node and add them to the queue
            for (GridPosition neighbor : getListOfNeighbors(currentPos)) {
                // add the node to the queue if it is in bounds and has not been visited
                if (isInbounds(grid, neighbor.getRowId(), neighbor.getColId()) && !visited.contains(neighbor)) {
                    // Add the neighbor node with the incremented distance from current node position
                    queue.offer(new Pair<GridPosition, Integer>(neighbor, currentPositionAndDist.getValB() + 1));
                    // Also mark the node visited
                    visited.add(neighbor);
                }
            }
        }


        // We could not find anything, we should not be arriving here since they promised 2 islands
        return -1;
    }


    private static List<GridPosition> getListOfNeighbors(GridPosition currentPos) {
        List<GridPosition> neighborNodes = new ArrayList<>();
        neighborNodes.add(new GridPosition(currentPos.getRowId() + 1, currentPos.getColId()));
        neighborNodes.add(new GridPosition(currentPos.getRowId() - 1, currentPos.getColId()));
        neighborNodes.add(new GridPosition(currentPos.getRowId(), currentPos.getColId() + 1));
        neighborNodes.add(new GridPosition(currentPos.getRowId(), currentPos.getColId() - 1));

        return neighborNodes;
    }

    // A DFS like recursive traversal
    private static Set<GridPosition> traverseIsland(String[][] grid, int row, int col, Set<GridPosition> visited) {
        // If we are out of bounds for the grid or if we have hit a WATER node return visited
        if (!isInbounds(grid, row, col) || "W".equals(grid[row][col])) {
            return visited;
        }

        // Current position
        GridPosition pos = new GridPosition(row, col);

        // If we have already visited this node, return visited
        if (visited.contains(pos)) {
            return visited;
        }

        // This is a new LAND node position
        visited.add(pos);

        // Let's look at the 4 neighbors to the current node recursively
        traverseIsland(grid, row - 1, col, visited);
        traverseIsland(grid, row + 1, col, visited);
        traverseIsland(grid, row, col - 1, visited);
        traverseIsland(grid, row, col + 1, visited);

        return visited;
    }

    private static boolean isInbounds(String[][] grid, int row, int col) {
        boolean rowWithinBounds = row >= 0 && row < grid.length;
        boolean colWithinBounds = col >= 0 && col < grid[0].length;

        return rowWithinBounds && colWithinBounds;
    }
}

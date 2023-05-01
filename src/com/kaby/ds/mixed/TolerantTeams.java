package com.kaby.ds.mixed;

import com.kaby.ds.graph.util.GraphUtil;
import com.kaby.ds.helper.ResultPair;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import static com.kaby.ds.graph.util.GraphUtil.buildGraphFromEdgeList;

// GRAPH
// This is a variation of the Can Color problem with Island Hopping
// We are checking whether the Graph is Bipartite - can be divided into two teams
public class TolerantTeams {

    /**
     * Write a function, tolerantTeams, that takes in an array of rivalries as an argument.
     * A rivalry is a pair of people who should not be placed on the same team.
     * The function should return a boolean indicating whether or not it is possible to separate people into two teams,
     * without rivals being on the same team. The two teams formed do not have to be the same size.
     *
     * @param args
     */
    public static void main(String[] args) {

        // == test_00: ==

        String[][] grid1 = new String[][]{
                {"philip", "seb"},
                {"raj", "nader"}
        };

        Boolean actualResult1 = tolerantTeams(grid1); // -> true
        ResultPair<Boolean, Boolean> resultPair1 = new ResultPair<>("Is this a tolerant team ", Boolean.TRUE, actualResult1);
        resultPair1.printResultPair();

        // == test_01: ==

        String[][] grid2 = new String[][]{
                {"philip", "seb"},
                {"raj", "nader"},
                {"raj", "philip"},
                {"seb", "raj"},
        };

        Boolean actualResult2 = tolerantTeams(grid2); // -> false
        ResultPair<Boolean, Boolean> resultPair2 = new ResultPair<>("Is this a tolerant team ", Boolean.FALSE, actualResult2);
        resultPair2.printResultPair();

    }

    private static Boolean tolerantTeams(String[][] grid) {

        // Let us convert the edge list to an adjacency list
        Map<String, LinkedList<String>> graph = GraphUtil.buildGraphFromEdgeList(grid);

        // Map to track which person has been colored
        Map<String, Boolean> coloring = new HashMap<>();

        for(String node : graph.keySet()) {
            if(!coloring.containsKey(node) && isBipartite(graph, node, coloring, Boolean.FALSE) == Boolean.FALSE) {
                return Boolean.FALSE;
            }
        }

        return Boolean.TRUE;
    }

    private static boolean isBipartite(Map<String, LinkedList<String>> graph, String node, Map<String, Boolean> coloring, Boolean currentColoring) {

        // If the node is in coloring, check if the currentColor matches that in the map
        if(coloring.containsKey(node)) {
            return currentColoring == coloring.get(node);
        }

        // The node is not in coloring, so we are visiting it for the first time
        coloring.put(node, currentColoring);

        // Iterate over all the neighbor nodes of this node in the adjacency list
        for(String neighbor : graph.get(node)) {
            // if we cannot color the subgraph return false
            if(isBipartite(graph, neighbor, coloring, !currentColoring) == Boolean.FALSE) {
                return Boolean.FALSE;
            }
        }

        return Boolean.TRUE;
    }
}

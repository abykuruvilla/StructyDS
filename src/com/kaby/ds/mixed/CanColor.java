package com.kaby.ds.mixed;

import com.kaby.ds.helper.ResultPair;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

// GRAPH
public class CanColor {

    /**
     * Write a function, canColor, that takes in an object representing the adjacency list of an undirected graph.
     * The function should return a boolean indicating whether or not it is possible to color nodes of the graph using
     * two colors in such a way that adjacent nodes are always different colors.
     *
     * For example, given this graph:
     *
     * x-y-z
     *
     * It is possible to color the nodes by using red for x and z,
     * then use blue for y. So the answer is true.
     *
     * For example, given this graph:
     *
     *     q
     *    / \
     *   s - r
     *
     * It is not possible to color the nodes without making two
     * adjacent nodes the same color. So the answer is false.
     * @param args
     */
    public static void main(String[] args) {

        // == test_00: ==

        // The undirected graph as an adjacency list
        Map<String , LinkedList<String>> graph1 = new HashMap<>();
        graph1.put("x", new LinkedList<>(Arrays.asList("y")));
        graph1.put("y", new LinkedList<>(Arrays.asList("x", "z")));
        graph1.put("z", new LinkedList<>(Arrays.asList("y")));

        Boolean actualResult1 = canColor(graph1); // -> true
        ResultPair<Boolean, Boolean> resultPair1 = new ResultPair<>("Can the graph, " + graph1.toString() + " be colored ? ", Boolean.TRUE, actualResult1);
        resultPair1.printResultPair();

        // == test_01: ==

        // The undirected graph as an adjacency list
        Map<String , LinkedList<String>> graph2 = new HashMap<>();
        graph2.put("q", new LinkedList<>(Arrays.asList("r", "s")));
        graph2.put("r", new LinkedList<>(Arrays.asList("q", "s")));
        graph2.put("s", new LinkedList<>(Arrays.asList("r", "q")));

        Boolean actualResult2 = canColor(graph2); // -> false
        ResultPair<Boolean, Boolean> resultPair2 = new ResultPair<>("Can the graph, " + graph2.toString() + " be colored ? ", Boolean.FALSE, actualResult2);
        resultPair2.printResultPair();

    }

    // We are going to do a style of depth first traversal
    private static Boolean canColor(Map<String, LinkedList<String>> graph) {

        // This map will hold the node and the coloring
        // We will use a boolean since there are only two colors; true and false represent each color
        // NOTE: if any node is present in this map, we have visited that node
        Map<String, Boolean> coloring = new HashMap<>();

        // For each node in graph, color any subgraphs
        // This will also take care of any islands
        for(String node : graph.keySet()) {
            // Initially we will call with the current color as false and then flip it every time
            // If we have not colored the subgraph for the node, validate the subgraph for the node
            if(!coloring.containsKey(node) && validate(graph, node, coloring, Boolean.FALSE) == Boolean.FALSE) {
                return Boolean.FALSE;
            }
        }

        // We were able to color the graph
        return Boolean.TRUE;
    }

    // Validate each node of the subgraph can be colored alternately
    private static Boolean validate(Map<String, LinkedList<String>> graph, String node, Map<String, Boolean> coloring, Boolean currentColor) {

        // If the node is in the coloring map check if the color matches current color
        if(coloring.containsKey(node)) {
            return coloring.get(node) == currentColor;
        }

        // If the node is not found in the map we are visiting it the first time
        coloring.put(node, currentColor);

        // Iterate over all the neighbor nodes of this node from the adjacency list
        for(String neighbor : graph.get(node)) {
            // If we cannot color the subgraph, return false
            if(validate(graph, neighbor, coloring, !currentColor) == Boolean.FALSE) {
                return Boolean.FALSE;
            }
        }

        // We were able to color the subgraph
        return Boolean.TRUE;
    }
}

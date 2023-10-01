package com.kaby.ds.graph;

import com.kaby.ds.helper.ResultPair;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

// GRAPH
// WHITE GRAY BLACK ALGORITHM
public class HasCycle {

    /**
     * Write a function, hasCycle, that takes in an object representing the adjacency list of a directed graph.
     * The function should return a boolean indicating whether or not the graph contains a cycle.
     *
     * @param args
     */
    public static void main(String[] args) {

        // == test_00: ==

        boolean result0 = hasCycle(Map.of(
                "a", List.of("b"),
                "b", List.of("c"),
                "c", List.of("a")
        )); // -> true

        ResultPair<Boolean, Boolean> resultPair0 = new ResultPair<>("Graph has cycle?", Boolean.TRUE, result0);
        resultPair0.printResultPair();

        // == test_01: ==

        boolean result1 = hasCycle(Map.of(
                "a", List.of("b", "c"),
                "b", List.of("c"),
                "c", List.of("d"),
                "d", List.of()
        )); // -> false
        ResultPair<Boolean, Boolean> resultPair1 = new ResultPair<>("Graph has cycle?", Boolean.FALSE, result1);
        resultPair1.printResultPair();

        // == test_02: ==

        boolean result2 = hasCycle(Map.of(
                "a", List.of("b", "c"),
                "b", List.of(),
                "c", List.of(),
                "e", List.of("f"),
                "f", List.of("e")
        )); // -> true
        ResultPair<Boolean, Boolean> resultPair2 = new ResultPair<>("Graph has cycle?", Boolean.TRUE, result2);
        resultPair2.printResultPair();

        // == test_03: ==

        boolean result3 = hasCycle(Map.of(
                "q", List.of("r", "s"),
                "r", List.of("t", "u"),
                "s", List.of(),
                "t", List.of(),
                "u", List.of(),
                "v", List.of("w"),
                "w", List.of(),
                "x", List.of("w")
        )); // -> false
        ResultPair<Boolean, Boolean> resultPair3 = new ResultPair<>("Graph has cycle?", Boolean.FALSE, result3);
        resultPair3.printResultPair();

        // == test_04: ==

        boolean result4 = hasCycle(Map.of(
                "a", List.of("b"),
                "b", List.of("c"),
                "c", List.of("a"),
                "g", List.of()
        )); // -> true
        ResultPair<Boolean, Boolean> resultPair4 = new ResultPair<>("Graph has cycle?", Boolean.TRUE, result4);
        resultPair4.printResultPair();

        // == test_05: ==

        boolean result5 = hasCycle(Map.of(
                "a", List.of("b"),
                "b", List.of("c"),
                "c", List.of("d"),
                "d", List.of("b")
        )); // -> true
        ResultPair<Boolean, Boolean> resultPair5 = new ResultPair<>("Graph has cycle?", Boolean.TRUE, result5);
        resultPair5.printResultPair();

    }

    // === WHITE GRAY BLACK ALGORITHM ===
    // white node -> unexplored
    // gray node -> visiting
    // black node -> visited
    // Initially all nodes are white. We start traversing(DFS) using the directions from a node. While doing so we mark the
    // node gray. Once we have nowhere to traverse from a certain node we mark it black. If while traversing we hit/visit a node
    // which is already marked gray, we are in a cycle as we have visited this earlier. If we have completed visiting every node
    // and this has not happened, we do not have a cycle.
    private static boolean hasCycle(Map<String, List<String>> graph) {

        // GRAY Nodes
        Set<String> visiting = new HashSet<>();
        // BLACK Nodes
        Set<String> visited = new HashSet<>();

        for(String node : graph.keySet()) {
            if(cycleDetectDFS(graph, node, visiting, visited)) {
                return Boolean.TRUE;
            }
        }

        // No cycle detected for any of the nodes
        return Boolean.FALSE;
    }

    private static boolean cycleDetectDFS(Map<String, List<String>> graph, String node, Set<String> visiting, Set<String> visited) {

        // If we are visiting a black/visited node
        if(visited.contains(node)) {
            return Boolean.FALSE;
        }

        // If we are visiting a gray/visiting node we have detected a cycle
        if(visiting.contains(node)) {
            return Boolean.TRUE;
        }

        // Node was not visited, so let's mark it visiting
        visiting.add(node);

        // Traverse through each of the neighbors of the node
        for(String neighbor : graph.get(node)) {
            // If traversing from the neighbor detects a cycle return true
            if(cycleDetectDFS(graph, neighbor, visiting, visited)) {
                return Boolean.TRUE;
            }
        }

        // We have finished traversing the node and its neighbors, mark it visited
        visiting.remove(node);
        visited.add(node);

        // No cycle detected
        return Boolean.FALSE;
    }


}

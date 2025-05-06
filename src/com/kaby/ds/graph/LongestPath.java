package com.kaby.ds.graph;

import com.kaby.ds.helper.ResultPair;

import java.util.*;

public class LongestPath {

    /**
     * Write a function, longestPath, that takes in an adjacency list for a directed acyclic graph.
     * The function should return the length of the longest path within the graph.
     * A path may start and end at any two nodes. The length of a path is considered the number of edges
     * in the path, not the number of nodes.
     *
     * @param args
     */
    public static void main(String[] args) {

//        const graph = {
//                a: ['c', 'b'],
//                b: ['c'],
//                c: []
//        };

        //Adjacency List to store the input graph
        Map<String, LinkedList<String>> graph = new HashMap<>();
        graph.put("a", new LinkedList<>(Arrays.asList("c", "b")));
        graph.put("b", new LinkedList<>(Arrays.asList("c")));
        graph.put("c", new LinkedList<>(Arrays.asList()));

        System.out.println("Input Graph: " + graph);

        Integer longestPath = longestPath(graph); // -> 2
        ResultPair<Integer, Integer> resultPair1 = new ResultPair<>("The longest edge path length is ", 2, longestPath);
        resultPair1.assertMatch();

//        =========================================

//        const graph = {
//                a: ['c', 'b'],
//                b: ['c'],
//                c: [],
//                q: ['r'],
//                r: ['s', 'u', 't'],
//                s: ['t'],
//                t: ['u'],
//                u: []
//        };

        //Adjacency List to store the input graph
        Map<String, LinkedList<String>> graph2 = new HashMap<>();
        graph2.put("a", new LinkedList<>(Arrays.asList("c", "b")));
        graph2.put("b", new LinkedList<>(Arrays.asList("c")));
        graph2.put("c", new LinkedList<>(Arrays.asList()));
        graph2.put("q", new LinkedList<>(Arrays.asList("r")));
        graph2.put("r", new LinkedList<>(Arrays.asList("s", "u", "t")));
        graph2.put("s", new LinkedList<>(Arrays.asList("t")));
        graph2.put("t", new LinkedList<>(Arrays.asList("u")));
        graph2.put("u", new LinkedList<>(Arrays.asList()));

        System.out.println("Input Graph: " + graph2);

        Integer longestPath2 = longestPath(graph2); // -> 4
        ResultPair<Integer, Integer> resultPair2 = new ResultPair<>("The longest edge path length is ", 4, longestPath2);
        resultPair2.assertMatch();
    }

    private static Integer longestPath(Map<String, LinkedList<String>> graph) {
        // NOTE: the input graph is a directed acyclic graph and has no cycles

        // Map to track distance from a terminal node
        Map<String, Integer> distance = new HashMap<>();

        // We first need to determine terminal nodes for different connected components
        // The terminal node in a component is any node which is not connected to any other nodes
        for(String node : graph.keySet()) {
            if(graph.get(node).isEmpty()) {
                // since this a terminal node, distance from itself is ZERO
                distance.put(node, 0);
            }
        }

        // We will be doing a Recursive DFS search for this problem to determine longest path
        // Since there could be separate components to the graph which are not connected,
        // lets iterate over all the nodes
        for(String node : graph.keySet()) {
            traverseDistance(graph, node, distance);
        }

        System.out.println("Distances Map => " + distance);
        // The recursive calls on all nodes should have populated the distance Map above, return the biggest length
        return Collections.max(distance.values());
    }

    // This method should give the max distance from a given node by traversing recursively
    private static int traverseDistance(Map<String, LinkedList<String>> graph, String node, Map<String, Integer> distance) {
        // BASE CASE:
        // If the node is contained in the distance map we have already visited this node and hence return the distance stored
        if(distance.containsKey(node)) {
            return distance.get(node);
        }

        // track the maxLength starting at the node, initialize to 0
        int maxLength = 0;

        // Ok, so we did not find the node in the distance map, so let's check out the neighbors
        for(String neighbor : graph.get(node)) {
            // making an attempt to get the maxLength for neighbor node
            int attempt = traverseDistance(graph, neighbor, distance);
            if(attempt > maxLength) {
                maxLength = attempt;
            }
        }

        // the +1 is for the distance from the node to the highest neighbor length found
        distance.put(node, maxLength + 1);

        // return the max distance of the node
        return distance.get(node);
    }
}

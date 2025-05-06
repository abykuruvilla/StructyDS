package com.kaby.ds.mixed;

import com.kaby.ds.helper.ResultPair;

import java.util.*;

// GRAPH
// KAHNS ALGORITHM
public class TopologicalOrder {

    /**
     * Write a function, topologicalOrder, that takes in an object representing the adjacency list for a
     * directed-acyclic graph. The function should return an array containing the topological-order
     * (https://en.wikipedia.org/wiki/Topological_sorting) of the graph.
     * <p>
     * The topological ordering of a graph is a sequence where "parent nodes" appear before their "children" within the sequence.
     *
     * @param args
     */
    public static void main(String[] args) {

        // == test_00: ==

        List<String> result0 = topologicalOrder(Map.of(
                "a", List.of("f"),
                "b", List.of("d"),
                "c", List.of("a", "f"),
                "d", List.of("e"),
                "e", List.of(),
                "f", List.of("b", "e")
        )); // -> ["c", "a", "f", "b", "d", "e"]
        ResultPair<List<String>, List<String>> resultPair0 = new ResultPair<>("The topological order is ", List.of("c", "a", "f", "b", "d", "e"), result0);
        resultPair0.assertMatch();

        // == test_01: ==

        List<String> result1 = topologicalOrder(Map.of(
                "h", List.of("l", "m"),
                "i", List.of("k"),
                "j", List.of("k", "i"),
                "k", List.of("h", "m"),
                "l", List.of("m"),
                "m", List.of()
        )); // -> ["j", "i", "k", "h", "l", "m"]
        ResultPair<List<String>, List<String>> resultPair1 = new ResultPair<>("The topological order is ", List.of("j", "i", "k", "h", "l", "m"), result1);
        resultPair1.assertMatch();

        // == test_02: ==

        List<String> result2 = topologicalOrder(Map.of(
                "q", List.of(),
                "r", List.of("q"),
                "s", List.of("r"),
                "t", List.of("s")
        )); // -> ["t", "s", "r", "q"]
        ResultPair<List<String>, List<String>> resultPair2 = new ResultPair<>("The topological order is ", List.of("t", "s", "r", "q"), result2);
        resultPair2.assertMatch();

        // == test_03: ==

        List<String> result3 = topologicalOrder(Map.of(
                "v", List.of("z", "w"),
                "w", List.of(),
                "x", List.of("w", "v", "z"),
                "y", List.of("x"),
                "z", List.of("w")
        )); // -> ["y", "x", "v", "z", "w"]
        ResultPair<List<String>, List<String>> resultPair3 = new ResultPair<>("The topological order is ", List.of("y", "x", "v", "z", "w"), result3);
        resultPair3.assertMatch();

    }

    private static List<String> topologicalOrder(Map<String, List<String>> graph) {

        // Map of each node and how many parents it has
        var numParents = new HashMap<String, Integer>();

        // Initialize the parent count of each node to 0
        for(String node : graph.keySet()) {
            numParents.put(node, 0);
        }

        // The way the graph is stored in the adjacency list, each node can have multiple children.
        // So for each child update the count of parents
        for(String node : graph.keySet()) {
            for(String child : graph.get(node)) {
                numParents.put(child, numParents.get(child) + 1);
            }
        }

        // Store the nodes that are ready to be visited
        // This stores nodes that have no parent node
        // Note: to start topological ordering of a DAG, there must at least be one node without a parent.
        // If there is no node without a parent, there is most probably a cycle, so this is not a DAG
        var readyNodes = new Stack<String>();

        for(String node: graph.keySet()) {
            // Start by checking nodes where number of parents is 0
            if(numParents.get(node) == 0) {
                readyNodes.push(node);
            }
        }

        // Result list with topological ordering
        List<String> orderedList = new ArrayList<>();

        while(!readyNodes.isEmpty()) {
            // Pop from the top of stack and add to the ordered list
            var currentNode = readyNodes.pop();
            orderedList.add(currentNode);

            // If I have visited this node, all its children will have one less parent,
            // hence decrement the size of the parents
            for(String child : graph.get(currentNode)) {
                numParents.put(child, numParents.get(child) - 1);
                // If the size of the parents of this child node has reached 0, let's add to the ready set
                if(numParents.get(child) == 0) {
                    readyNodes.push(child);
                }
            }
        }

        return orderedList;
    }
}

package com.kaby.ds.mixed;

import com.kaby.ds.graph.util.GraphUtil;
import com.kaby.ds.helper.ResultPair;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

// GRAPH
// KAHNS ALGORITHM
public class SafeCracking {

    /**
     * Oh-no! You forgot the number combination that unlocks your safe. Luckily, you knew that you'd be forgetful
     * so you previously wrote down a bunch of hints that can be used to determine the correct combination.
     * Each hint is a pair of numbers 'x, y' that indicates you must enter digit 'x' before 'y' (but not necessarily
     * immediately before y).
     * <p>
     * The keypad on the safe has digits 0-9. You can assume that the hints will generate exactly one working
     * combination and that a digit can occur zero or one time in the answer.
     * <p>
     * Write a function, safeCracking, that takes in an array of hints as an argument and determines the combination
     * that will unlock the safe. The function should return a string representing the combination.
     *
     * @param args
     */
    public static void main(String[] args) {

        // == test_00: ==

        String result0 = safeCracking(List.of(
                List.of(7, 1),
                List.of(1, 8),
                List.of(7, 8)
        )); // -> '718'
        ResultPair<String, String> resultPair0 = new ResultPair<>("The safe sequence is ", "718", result0);
        resultPair0.assertMatch();

        // == test_01: ==

        String result1 = safeCracking(List.of(
                List.of(3, 1),
                List.of(4, 7),
                List.of(5, 9),
                List.of(4, 3),
                List.of(7, 3),
                List.of(3, 5),
                List.of(9, 1)
        )); // -> '473591'
        ResultPair<String, String> resultPair1 = new ResultPair<>("The safe sequence is ", "473591", result1);
        resultPair1.assertMatch();

        // == test_02: ==

        String result2 = safeCracking(List.of(
                List.of(2, 5),
                List.of(8, 6),
                List.of(0, 6),
                List.of(6, 2),
                List.of(0, 8),
                List.of(2, 3),
                List.of(3, 5),
                List.of(6, 5)
        )); // -> '086235'
        ResultPair<String, String> resultPair2 = new ResultPair<>("The safe sequence is ", "086235", result2);
        resultPair2.assertMatch();

        // == test_03: ==

        String result3 = safeCracking(List.of(
                List.of(0, 1),
                List.of(6, 0),
                List.of(1, 8)
        )); // -> '6018'
        ResultPair<String, String> resultPair3 = new ResultPair<>("The safe sequence is ", "6018", result3);
        resultPair3.assertMatch();

        // == test_04: ==

        String result4 = safeCracking(List.of(
                List.of(8, 9),
                List.of(4, 2),
                List.of(8, 2),
                List.of(3, 8),
                List.of(2, 9),
                List.of(4, 9),
                List.of(8, 4)
        )); // -> '38429'
        ResultPair<String, String> resultPair4 = new ResultPair<>("The safe sequence is ", "38429", result4);
        resultPair4.assertMatch();


    }

    private static String safeCracking(List<List<Integer>> hints) {
        // Convert the hints edge list to an adjacency list graph
        Map<Integer, List<Integer>> graph = GraphUtil.buildDirectedGraphFromEdgeList(hints);
        // Do a topological ordering to get the safe code
        return topologicalOrderCode(graph);
    }

    private static String topologicalOrderCode(Map<Integer, List<Integer>> graph) {

        // Map of each node and how many parents it has
        var numOfParents = new HashMap<Integer, Integer>();

        // Initialize the parent count of each node to 0
        for(Integer node : graph.keySet()) {
            numOfParents.put(node, 0);
        }

        // Each node in the adjacency list can have multiple children
        // For each child update the count of the number of parents
        for(Integer node : graph.keySet()) {
            for(Integer child : graph.get(node)) {
                numOfParents.put(child, numOfParents.get(child) + 1);
            }
        }

        // Nodes that are ready to be visited
        // Stores the nodes that do not have a parent node
        // Note: to start topological ordering of a DAG, there must at least be one node without a parent.
        // If there is no node without a parent, there is most probably a cycle, so this is not a DAG
        var ready = new Stack<Integer>();

        for(Integer node : graph.keySet()) {
            // Start by checking nodes where the number of parents is 0
            if(numOfParents.get(node) == 0) {
                ready.push(node);
            }
        }

        // Resulting safe code
        StringBuilder code = new StringBuilder();

        while(!ready.isEmpty()) {
            // Pop the top of the stack and add it to the code string
            var current = ready.pop();
            code.append(current);

            // Since I have visited this node, all its children will have one less parent
            // let's decrement count of the parents
            for(Integer child : graph.get(current)) {
                numOfParents.put(child, numOfParents.get(child) - 1);
                // if after decrementing size of parents, the count reduces to 0, add to ready nodes
                if(numOfParents.get(child) == 0) {
                    ready.push(child);
                }
            }
        }

        return code.toString();
    }
}

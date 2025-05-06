package com.kaby.ds.graph;

import com.kaby.ds.graph.util.GraphUtil;
import com.kaby.ds.helper.ResultPair;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

// GRAPH
// WHITE-GRAY-BLACK ALGORITHM
public class PrereqsPossible {

    public static void main(String[] args) {

        // == test_00: ==

        var numCourses0 = 6;
        var prereqs0 = List.of(
                List.of(0, 1),
                List.of(2, 3),
                List.of(0, 2),
                List.of(1, 3),
                List.of(4, 5)
        );
        Boolean result0 = prereqsPossible(numCourses0, prereqs0); // -> true
        ResultPair<Boolean, Boolean> resultPair0 = new ResultPair<>("Prereqs Possible? ", Boolean.TRUE, result0);
        resultPair0.assertMatch();

        // == test_01: ==

        var numCourses1 = 6;
        var prereqs1 = List.of(
                List.of(0, 1),
                List.of(2, 3),
                List.of(0, 2),
                List.of(1, 3),
                List.of(4, 5),
                List.of(3, 0)
        );
        Boolean result1 = prereqsPossible(numCourses1, prereqs1); // -> false
        ResultPair<Boolean, Boolean> resultPair1 = new ResultPair<>("Prereqs Possible? ", Boolean.FALSE, result1);
        resultPair1.assertMatch();


        // == test_02: ==

        var numCourses2 = 5;
        var prereqs2 = List.of(
                List.of(2, 4),
                List.of(1, 0),
                List.of(0, 2),
                List.of(0, 4)
        );
        Boolean result2 = prereqsPossible(numCourses2, prereqs2); // -> true
        ResultPair<Boolean, Boolean> resultPair2 = new ResultPair<>("Prereqs Possible? ", Boolean.TRUE, result2);
        resultPair2.assertMatch();


        // == test_03: ==

        var numCourses3 = 6;
        var prereqs3 = List.of(
                List.of(2, 4),
                List.of(1, 0),
                List.of(0, 2),
                List.of(0, 4),
                List.of(5, 3),
                List.of(3, 5)
        );
        Boolean result3 = prereqsPossible(numCourses3, prereqs3); // -> false
        ResultPair<Boolean, Boolean> resultPair3 = new ResultPair<>("Prereqs Possible? ", Boolean.FALSE, result3);
        resultPair3.assertMatch();


        // == test_04: ==

        var numCourses4 = 8;
        var prereqs4 = List.of(
                List.of(1, 0),
                List.of(0, 6),
                List.of(2, 0),
                List.of(0, 5),
                List.of(3, 7),
                List.of(4, 3)
        );
        Boolean result4 = prereqsPossible(numCourses4, prereqs4); // -> true
        ResultPair<Boolean, Boolean> resultPair4 = new ResultPair<>("Prereqs Possible? ", Boolean.TRUE, result4);
        resultPair4.assertMatch();


        // == test_05: ==

        var numCourses5 = 8;
        var prereqs5 = List.of(
                List.of(1, 0),
                List.of(0, 6),
                List.of(2, 0),
                List.of(0, 5),
                List.of(3, 7),
                List.of(7, 4),
                List.of(4, 3)
        );
        Boolean result5 = prereqsPossible(numCourses5, prereqs5); // -> false
        ResultPair<Boolean, Boolean> resultPair5 = new ResultPair<>("Prereqs Possible? ", Boolean.FALSE, result5);
        resultPair5.assertMatch();


        // == test_06: ==

        var numCourses6 = 42;
        var prereqs6 = List.of(List.of(6, 36));
        Boolean result6 = prereqsPossible(numCourses6, prereqs6); // -> true
        ResultPair<Boolean, Boolean> resultPair6 = new ResultPair<>("Prereqs Possible? ", Boolean.TRUE, result6);
        resultPair6.assertMatch();

    }

    // This is also a WHITE-GRAY-BLACK Algorithm problem
    // We will not be able to complete all the courses if the prereqs form a cycle.
    private static Boolean prereqsPossible(int numCourses, List<List<Integer>> prereqs) {

        // First convert the prereq list into an adjacency list
        Map<Integer, List<Integer>> graph = GraphUtil.buildDirectedGraphFromEdgeList(prereqs);

        // Gray Nodes
        Set<Integer> visiting = new HashSet<>();
        // Black Nodes
        Set<Integer> visited = new HashSet<>();

        // Iterate over each course in the adjacency list and see if any of the courses are part of a cycle
        for (Integer node : graph.keySet()) {
            if (cycleDetectDFS(graph, node, visiting, visited)) {
                return Boolean.FALSE;
            }
        }

        // No cycle detected between prereqs, so we can complete all courses
        return Boolean.TRUE;
    }

    private static boolean cycleDetectDFS(Map<Integer, List<Integer>> graph, Integer node, Set<Integer> visiting, Set<Integer> visited) {
        // If a node is already visited return false, as no cycle was found
        if (visited.contains(node)) {
            return Boolean.FALSE;
        }

        // If node is in visiting state we have identified a cycle
        if (visiting.contains(node)) {
            return Boolean.TRUE;
        }

        // No cycle detected, add node in visiting set
        visiting.add(node);

        // Iterate over the neighbors of the node
        for (Integer neighbor : graph.get(node)) {
            // If the neighbor has a cycle the node has it too
            if (cycleDetectDFS(graph, neighbor, visiting, visited)) {
                return Boolean.TRUE;
            }
        }

        // No cycle detected for node, remove from visiting and mark it as visited
        visiting.remove(node);
        visited.add(node);

        // No cycle detected
        return Boolean.FALSE;
    }
}

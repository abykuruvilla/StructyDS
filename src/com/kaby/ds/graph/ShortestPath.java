package com.kaby.ds.graph;

import com.kaby.ds.graph.util.GraphUtil;
import com.kaby.ds.helper.Pair;
import com.kaby.ds.helper.ResultPair;

import java.util.*;

/**
 * Write a function, shortestPath, that takes in an array of edges for an undirected graph and two nodes
 * (nodeA, nodeB). The function should return the length of the shortest path between A and B.
 * Consider the length as the number of edges in the path, not the number of nodes.
 * If there is no path between A and B, then return -1.
 */
public class ShortestPath {

    public static void main(String[] args) {
//        const edges = [
//          ['w', 'x'],
//          ['x', 'y'],
//          ['z', 'y'],
//          ['z', 'v'],
//          ['w', 'v']
//        ];
//
//        shortestPath(edges, 'w', 'z'); // -> 2

        // The input is an edges list
        // Note this is an undirected graph
        String[][] edges = new String[][]{
                {"w", "x"},
                {"x", "y"},
                {"z", "y"},
                {"z", "v"},
                {"w", "v"}
        };

        // Convert the edges list to an adjacency list
        Map<String, LinkedList<String>> graph = GraphUtil.buildUndirectedGraphFromEdgeList(edges);

        // NOTE: While both DFS and BFS should give an answer BFS might give shortest path better as it
        // explores its immediate neighbors first instead of going down until one specific direction
        int shortestPath = shortestPath(graph, "w", "z");
        ResultPair<Integer, Integer> resultPair = new ResultPair<>("The shortest path between w and z is", 2, shortestPath);
        resultPair.assertMatch();

//        =======================================

//        const edges = [
//          ['a', 'c'],
//          ['a', 'b'],
//          ['c', 'b'],
//          ['c', 'd'],
//          ['b', 'd'],
//          ['e', 'd'],
//          ['g', 'f']
//        ];
//
//        shortestPath(edges, 'b', 'g'); // -> -1

        // The input is an edges list
        // Note this is an undirected graph
        String[][] edges2 = new String[][]{
                {"a", "c"},
                {"a", "b"},
                {"c", "b"},
                {"c", "d"},
                {"b", "d"},
                {"e", "d"},
                {"g", "f"}
        };

        // Convert the edges list to an adjacency list
        Map<String, LinkedList<String>> graph2 = GraphUtil.buildUndirectedGraphFromEdgeList(edges2);

        // NOTE: While both DFS and BFS should give an answer BFS might give shortest path better as it
        // explores its immediate neighbors first instead of going down until one specific direction
        int shortestPath2 = shortestPath(graph2, "b", "g");
        ResultPair<Integer, Integer> resultPair2 = new ResultPair<>("The shortest path between b and g is", -1, shortestPath2);
        resultPair2.assertMatch();

//        ============================================

//        const edges = [
//          ['a', 'c'],
//          ['a', 'b'],
//          ['c', 'b'],
//          ['c', 'd'],
//          ['b', 'd'],
//          ['e', 'd'],
//          ['g', 'f']
//        ];
//
//        shortestPath(edges, 'a', 'e'); // -> 3

        // The input is an edges list
        // Note this is an undirected graph
        String[][] edges3 = new String[][]{
                {"a", "c"},
                {"a", "b"},
                {"c", "b"},
                {"c", "d"},
                {"b", "d"},
                {"e", "d"},
                {"g", "f"}
        };

        // Convert the edges list to an adjacency list
        Map<String, LinkedList<String>> graph3 = GraphUtil.buildUndirectedGraphFromEdgeList(edges3);

        // NOTE: While both DFS and BFS should give an answer BFS might give shortest path better as it
        // explores its immediate neighbors first instead of going down until one specific direction
        int shortestPath3 = shortestPath(graph3, "a", "e");
        ResultPair<Integer, Integer> resultPair3 = new ResultPair<>("The shortest path between a and e is", 3, shortestPath3);
        resultPair3.assertMatch();

    }

    private static int shortestPath(Map<String, LinkedList<String>> graph, String src, String dest) {
        // Base case where the src and destination nodes are the same
        if (src.equals(dest)) {
            return 0;
        }

        // Let's keep track of the visited nodes
        Set<String> visited = new HashSet<>();

        // A BFS approach uses a queue
        // The queue will hold the node, and it's distance from the src node
        Queue<Pair<String, Integer>> queue = new LinkedList<>();

        // We have visited the current node
        visited.add(src);
        // Let's add the source node to the queue, it's distance from itself is 0
        queue.offer(new Pair<>(src, 0));

        // While the queue is not empty push each nodes neighbors onto the queue
        while (!queue.isEmpty()) {
            // get the front of the queue and get its neighbors onto the queue
            Pair<String, Integer> currentNode = queue.poll();
            // if the current node is equal to the destination return the distance from the src node
            if (currentNode.getValA().equals(dest)) {
                return currentNode.getValB();
            }

            for (String neighbor : graph.get(currentNode.getValA())) {
                // only add the neighbor if we have not visited it before to avoid a cycle
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    // The distance of the neighbor node is one more than the current node
                    queue.add(new Pair<>(neighbor, currentNode.getValB() + 1));
                }
            }
        }

        // We did not find a path to the destination, so return -1
        return -1;
    }
}

package com.kaby.ds.graph;


import com.kaby.ds.graph.util.GraphUtil;

import java.util.*;

/**
 * Write a function, undirectedPath, that takes in an array of edges for an undirected graph and two nodes
 * (nodeA, nodeB). The function should return a boolean indicating whether or not there exists a path
 * between nodeA and nodeB.
 */
public class UndirectedPath {

    public static void main(String[] args) {

        // input edge list representing undirected graph
        String[][] edges = new String[][]{
                {"i", "j"},
                {"k", "i"},
                {"m", "k"},
                {"k", "l"},
                {"o", "n"}
        };

        boolean isTherePath = undirectedPathRecursive(edges, "j", "m"); // -> true
        System.out.println("\n Undirected Graph : RECURSIVE path between j and m -> " + isTherePath);
        System.out.print("\n");

        boolean isTherePath2 = undirectedPathIterative(edges, "j", "m"); // -> true
        System.out.println("\n Undirected Graph : ITERATIVE path between j and m -> " + isTherePath2);
        System.out.print("\n");

        //=================================================================================================

        String[][] edges2 = new String[][]{
                {"b", "a"},
                {"c", "a"},
                {"b", "c"},
                {"q", "r"},
                {"q", "s"},
                {"q", "u"},
                {"q", "t"}
        };

        boolean isTherePath3 = undirectedPathRecursive(edges2, "r", "b"); // -> false
        System.out.println("\n Undirected Graph : RECURSIVE path between r and b -> " + isTherePath3);
        System.out.print("\n");

        boolean isTherePath4 = undirectedPathIterative(edges2, "r", "b"); // -> false
        System.out.println("\n Undirected Graph : ITERATIVE path between r and b -> " + isTherePath4);
        System.out.print("\n");

    }


    // BFS Iterative
    private static boolean undirectedPathIterative(String[][] edges, String src, String dest) {

        // Convert the list of edges to an adjacency list
        // Note that since this is an undirected graph edges go both ways
        Map<String, LinkedList<String>> graph = GraphUtil.buildUndirectedGraphFromEdgeList(edges);

        // Base case
        if(src.equals(dest)) {
            return true;
        }

        // Set to track already visited nodes. Let's avoid a cycle
        Set<String> visited = new HashSet<>();

        // Queue for BFS, add the node element to the queue
        Queue<String> queue = new LinkedList<>();
        visited.add(src);
        queue.offer(src);


        while(!queue.isEmpty()) {
            // Dequeue the first element of the queue
            String current = queue.poll();

            // Get all adjacent neighbors of the current dequeued node
            // If an adjacent has not been visited, then mark it visited  and enqueue it
            for(String neighbor : graph.get(current)) {
                // if the neighbor equals the dest node there is a path
                if(neighbor.equals(dest)) {
                    return true;
                }

                // Else continue with BFS and add to the visited set and also add node to the queue
                if(!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }

            }
        }

        // No path was found
        return false;

    }

    // DFS Recursive
    private static boolean undirectedPathRecursive(String[][] edges, String src, String dest) {
        // Convert the list of edges to an adjacency list
        // Note that since this is an undirected graph edges go both ways
        Map<String, LinkedList<String>> graph = GraphUtil.buildUndirectedGraphFromEdgeList(edges);

        return hasPathRecursive(graph, src, dest, new HashSet<>());
    }

    private static boolean hasPathRecursive(Map<String, LinkedList<String>> graph, String src, String dest, Set<String> visited) {

        // The current node in process is the src node.
        // hence if we
        if(src.equals(dest)) {
            return true;
        }

        // Account for closed loops, keep track of nodes visited
        // If the source node was already visited we are in a close loop
        if(visited.contains(src)) {
            return false;
        }
        // Mark the source node as visited
        visited.add(src);


        // Recursively call the method to determine if there is a path from the neighbor node to the destination
        for(String neighbor : graph.get(src)) {
            if(hasPathRecursive(graph, neighbor, dest, visited)) {
                return true;
            }
        }

        // No path was found to destination, hence returning false
        return false;
    }

}

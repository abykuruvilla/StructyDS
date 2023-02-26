package com.kaby.ds.graph;


import java.util.*;

/**
 * Problem to check if there is a path from a source to a destination node
 */
public class HasPathFromSrcToDestination {

    public static void main(String[] args) {
        //Adjacency List to store the graph
        Map<String, LinkedList<String>> graph = new HashMap<>();
        graph.put("f", new LinkedList<>(Arrays.asList("g", "i")));
        graph.put("g", new LinkedList<>(Arrays.asList("h")));
        graph.put("h", new LinkedList<>(Arrays.asList()));
        graph.put("i", new LinkedList<>(Arrays.asList("g", "k")));
        graph.put("j", new LinkedList<>(Arrays.asList("i")));
        graph.put("k", new LinkedList<>(Arrays.asList()));

        System.out.println("Input Graph: " + graph);

        boolean isTherePath = hasPathRecursive(graph, "f", "k");
        System.out.println("DFS Recursive : Is there path from f to k : " + isTherePath);

        boolean isTherePath2 = hasPathIterative(graph, "g", "k");
        System.out.println("BFS Iterative : Is there path from g to k : " + isTherePath2);
    }


    // BFS Iterative
    private static boolean hasPathIterative(Map<String, LinkedList<String>> graph, String src, String dest) {

        // BFS is based on a queue
        Queue<String> queue = new LinkedList<>();
        // Add the current node to the queue
        queue.offer(src);

        // while the queue is not empty
        while(!queue.isEmpty()) {
            // Get the value from front of queue
            String current = queue.poll();
            // If the current node equal to the destination node there is a path to reach this destination node
            if(current == dest) {
                return true;
            }
            // Poll the neighbors of the current node and add to the queue
            for(String neighbor : graph.get(current)){
                queue.add(neighbor);
            }
        }

        // We have not been able to reach the destination
        return false;
    }



    // DFS recursive
    private static boolean hasPathRecursive(Map<String, LinkedList<String>> graph, String src, String dest) {
        // here src is current node during recursion
        // if we have reached a dest, means there is a path to the destination
        if(src == dest) {
            return true;
        }

        // if not look at the neighbors
        for(String neighbor : graph.get(src)) {
            if(hasPathRecursive(graph, neighbor, dest)) {
                return true;
            }
        }

        return false;

    }
}

package com.kaby.ds.graph;

import java.util.*;

public class GraphBFS {

    public static void main(String[] args) {
        //Adjacency List to store the graph
        Map<String, LinkedList<String>> graph = new HashMap<>();
        graph.put("a", new LinkedList<>(Arrays.asList("c", "b")));
        graph.put("b", new LinkedList<>(Arrays.asList("d")));
        graph.put("c", new LinkedList<>(Arrays.asList("e")));
        graph.put("d", new LinkedList<>(Arrays.asList("f")));
        graph.put("e", new LinkedList<>(Arrays.asList()));
        graph.put("f", new LinkedList<>(Arrays.asList()));

        System.out.println("Input Graph: " + graph);

        System.out.println("BFS Print - Iterative");
        breadthFirstSearchPrint(graph, "a");

    }

    private static void breadthFirstSearchPrint(Map<String, LinkedList<String>> graph, String source) {

        // Initialize a queue and add source to the queue
        Queue<String> queue = new LinkedList<>();

        queue.offer(source);

        // While the queue is not empty remove the node from the queue
        while(!queue.isEmpty()) {
            String current = queue.poll();
            System.out.println(current);

            // Add all the neighbors of the current node to the queue
            for(String neighbor : graph.get(current)) {
                queue.offer(neighbor);
            }
        }
    }
}

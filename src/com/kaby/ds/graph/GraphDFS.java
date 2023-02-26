package com.kaby.ds.graph;

import java.util.*;

public class GraphDFS {

    public static void main(String[] args) {
        //Adjacency List to store the graph
        Map<String, LinkedList<String>> graph = new HashMap<>();
        graph.put("a", new LinkedList<>(Arrays.asList("b", "c")));
        graph.put("b", new LinkedList<>(Arrays.asList("d")));
        graph.put("c", new LinkedList<>(Arrays.asList("e")));
        graph.put("d", new LinkedList<>(Arrays.asList("f")));
        graph.put("e", new LinkedList<>(Arrays.asList()));
        graph.put("f", new LinkedList<>(Arrays.asList()));

        System.out.println("Input Graph: " + graph);

        System.out.println("DFS Print - Iterative");
        depthFirstSearchPrint(graph, "a");
        System.out.println("DFS Print - Recursive");
        depthFirstSearchRecursivePrint(graph, "a");

    }

    private static void depthFirstSearchRecursivePrint(Map<String, LinkedList<String>> graph, String source) {
        // Print the source node
        System.out.println(source);
        // Get the neighbors for each neighbor call the method recursively
        for (String neighbor : graph.get(source)) {
            depthFirstSearchRecursivePrint(graph, neighbor);
        }
    }

    private static void depthFirstSearchPrint(Map<String, LinkedList<String>> graph, String source) {
        Stack<String> stack = new Stack<>();
        // Add source node to stack
        stack.push(source);   // source is the first node of the graph that we start traversing

        // While stack is not empty pop the value off the stack and print it
        while(!stack.isEmpty()) {
            String current = stack.pop();
            System.out.println(current);

            // Get the neighbors for the current node from the Adjacency List
            // and add each neighbor to the stack
            for(String neighbor : graph.get(current)) {
                stack.push(neighbor);
            }
        }
    }
}

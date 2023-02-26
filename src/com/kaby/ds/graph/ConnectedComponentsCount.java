package com.kaby.ds.graph;


import java.util.*;

/**
 * Write a function, connectedComponentsCount, that takes in the adjacency list of an undirected graph.
 * The function should return the number of connected components within the graph.
 */
public class ConnectedComponentsCount {

    public static void main(String[] args) {

//        connectedComponentsCount({
//                0: [8, 1, 5],
//                1: [0],
//                8: [0, 5],
//                5: [0, 8],
//                2: [3, 4],
//                3: [2, 4],
//                4: [3, 2]
//        }); // -> 2



        //Adjacency List to store the graph
        Map<Integer, LinkedList<Integer>> graph = new HashMap<>();
        graph.put(0, new LinkedList<>(Arrays.asList(8, 1, 5)));
        graph.put(1, new LinkedList<>(Arrays.asList(0)));
        graph.put(5, new LinkedList<>(Arrays.asList(0, 8)));
        graph.put(8, new LinkedList<>(Arrays.asList(0, 5)));
        graph.put(2, new LinkedList<>(Arrays.asList(3, 4)));
        graph.put(3, new LinkedList<>(Arrays.asList(2, 4)));
        graph.put(4, new LinkedList<>(Arrays.asList(3, 2)));

        System.out.println("Input Graph: " + graph);

        Integer connectedComponentsCount = connectedComponentsCount(graph);
        System.out.println("Connected Components Count - DFS Recursive : The count : Expected = 2, Actual =  " + connectedComponentsCount);
    }

    // DFS Recursive
    private static Integer connectedComponentsCount(Map<Integer, LinkedList<Integer>> graph) {

        // Track the visited nodes globally
        Set<Integer> visited = new HashSet<>();
        // To maintain the count of connected components
        int count = 0;

        // Iterate over each of the keys in the graph
        for(Integer startNode : graph.keySet()) {
            // Do a depth first search starting from that node to as far as possible
            // If explore here returns true means we have visited all nodes in the component,
            // so lets increment the count of components
            if(explore(graph, startNode, visited) == true){
                count += 1;
            }
        }

        // Let's return the total count of components
        return count;
    }

    private static boolean explore(Map<Integer, LinkedList<Integer>> graph, Integer currentNode, Set<Integer> visited) {

        //To avoid loops we need to see if we have already visited the current node
        if(visited.contains(currentNode)) {
            // We are most probably in a closed loop and nothing more to explore
            return false;
        }

        // Ok so we have no visited this node, so lets add it to the visited Set
        visited.add(currentNode);

        for(Integer neighbor : graph.get(currentNode)) {
            explore(graph, neighbor, visited);
        }

        // We have already explored all the neighbors to the startNode, so lets return true
        return true;
    }
}

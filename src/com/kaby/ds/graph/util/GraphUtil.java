package com.kaby.ds.graph.util;

import java.util.*;

public class GraphUtil {


    public static Map<String, LinkedList<String>> buildGraphFromEdgeList(String[][] edges) {

        Map<String, LinkedList<String>> graph = new HashMap<>();

        for(String[] edge : edges) {
            // For each of the 2 nodes in an edge check to see if the key is present in the adjacency graph,
            // if not add as Key
            if(!(graph.containsKey(edge[0]))) {
                graph.put(edge[0], new LinkedList<>());
            }

            if(!(graph.containsKey(edge[1]))) {
                graph.put(edge[1], new LinkedList<>());
            }

            // since this is an undirected graph, you can travel bi-directionally between nodes
            // which have an edge connecting them
            graph.get(edge[0]).offer(edge[1]);
            graph.get(edge[1]).offer(edge[0]);
        }

        System.out.println("***********************");
        System.out.println("Graph as adjacency list");
        System.out.println("***********************");
        System.out.println(graph);

        return graph;

    }

}

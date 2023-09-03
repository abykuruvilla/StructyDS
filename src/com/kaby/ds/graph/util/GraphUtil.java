package com.kaby.ds.graph.util;

import java.util.*;

public class GraphUtil {

    public static <T> Map<T, LinkedList<T>> buildUndirectedGraphFromEdgeList(T[][] edges) {

        Map<T, LinkedList<T>> graph = new HashMap<>();

        for(T[] edge : edges) {
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

        System.out.println("**********************************");
        System.out.println("Undirected Graph as adjacency list");
        System.out.println("**********************************");
        System.out.println(graph);

        return graph;

    }

    public static <T> Map<T, List<T>> buildDirectedGraphFromEdgeList(List<List<T>> edgeList) {

        Map<T, List<T>> graph = new HashMap<>();

        for(List<T> edge : edgeList) {
            // Each edge has 2 nodes
            T e1 = edge.get(0);
            T e2 = edge.get(1);

            // For each of the 2 nodes in an edge check to see if the key is present in the adjacency graph,
            // if not add as Key

            if(!graph.containsKey(e1)) {
                graph.put(e1, new ArrayList<>());
            }
            if(!graph.containsKey(e2)) {
                graph.put(e2, new ArrayList<>());
            }

            // Since this is a directional graph node e1 -> e2
            graph.get(e1).add(e2);
        }

        System.out.println("********************************");
        System.out.println("Directed Graph as adjacency list");
        System.out.println("********************************");
        System.out.println(graph);

        return graph;

    }

}

package com.kaby.ds.graph;

import java.util.*;

/**
 * Write a function, largestComponent, that takes in the adjacency list of an undirected graph.
 * The function should return the size of the largest connected component in the graph.
 */
public class LargestComponent {

    public static void main(String[] args) {

//        largestComponent({
//                0: ['8', '1', '5'],
//                1: ['0'],
//                5: ['0', '8'],
//                8: ['0', '5'],
//                2: ['3', '4'],
//                3: ['2', '4'],
//                4: ['3', '2']
//        }); // -> 4

        Map<Integer, LinkedList<Integer>> graph = new HashMap<>();
        graph.put(0, new LinkedList<>(Arrays.asList(8, 1, 5)));
        graph.put(1, new LinkedList<>(Arrays.asList(0)));
        graph.put(5, new LinkedList<>(Arrays.asList(0, 8)));
        graph.put(8, new LinkedList<>(Arrays.asList(0, 5)));
        graph.put(2, new LinkedList<>(Arrays.asList(3, 4)));
        graph.put(3, new LinkedList<>(Arrays.asList(2, 4)));
        graph.put(4, new LinkedList<>(Arrays.asList(3, 2)));

        System.out.println("Input Graph: " + graph);

        Integer largestComponentsNodeCount = largestComponent(graph);
        System.out.println("Largest Component's Node Count - DFS Recursive : The count : Expected = 4, Actual =  " + largestComponentsNodeCount);

//        ==================================

//        largestComponent({
//                3: [],
//                4: ['6'],
//                6: ['4', '5', '7', '8'],
//                8: ['6'],
//                7: ['6'],
//                5: ['6'],
//                1: ['2'],
//                2: ['1']
//        }); // -> 5

        Map<Integer, LinkedList<Integer>> graph2 = new HashMap<>();
        graph2.put(3, new LinkedList<>(Arrays.asList()));
        graph2.put(4, new LinkedList<>(Arrays.asList(6)));
        graph2.put(6, new LinkedList<>(Arrays.asList(4, 5, 7, 8)));
        graph2.put(8, new LinkedList<>(Arrays.asList(6)));
        graph2.put(7, new LinkedList<>(Arrays.asList(6)));
        graph2.put(5, new LinkedList<>(Arrays.asList(6)));
        graph2.put(1, new LinkedList<>(Arrays.asList(2)));
        graph2.put(2, new LinkedList<>(Arrays.asList(1)));

        System.out.println("Input Graph: " + graph2);

        Integer largestComponentsNodeCount2 = largestComponent(graph2);
        System.out.println("Largest Component's Node Count - DFS Recursive : The count : Expected = 5, Actual =  " + largestComponentsNodeCount2);

//        =====================================

//        largestComponent({}); // -> 0
        Map<Integer, LinkedList<Integer>> graph3 = new HashMap<>();
        System.out.println("Input Graph: " + graph3);

        Integer largestComponentsNodeCount3 = largestComponent(graph3);
        System.out.println("Largest Component's Node Count - DFS Recursive : The count : Expected = 0, Actual =  " + largestComponentsNodeCount3);

    }

    private static Integer largestComponent(Map<Integer, LinkedList<Integer>> graph) {
        // Something to track the nodes visited
        Set<Integer> visited = new HashSet<>();
        // A global largest count of components
        int largestComponentNodeCount = 0;

        // Loop over each key in the graph
        for(Integer startNode : graph.keySet()) {
            // Let's do DFS starting at the startNode to explore all nodes in that connected component
            int nodeSizeOfComponent = explore(graph, startNode, visited);
            // If the size of this component is greater than the previous known largest size,
            // let's update the count
            if(nodeSizeOfComponent > largestComponentNodeCount) {
                largestComponentNodeCount = nodeSizeOfComponent;
            }
        }

        // This is the largest known component size
        return largestComponentNodeCount;
    }

    private static int explore(Map<Integer, LinkedList<Integer>> graph, Integer currentNode, Set<Integer> visited) {
        int nodeCountForComponent = 0;

        // Let's avoid a loop in the graph
        if(visited.contains(currentNode)) {
            // IF WE HAVE ALREADY VISITED A NODE LET US RETURN ZERO
            return nodeCountForComponent;
        }
        // We have not vistied this node before, so let's update the Set of visited nodes
        visited.add(currentNode);
        // Update the node count of this current node
        nodeCountForComponent +=1;

        for(Integer neighbor : graph.get(currentNode)) {
            int count = explore(graph, neighbor, visited);
            // Update the node count of this component
            nodeCountForComponent += count;
        }

        return nodeCountForComponent;
    }
}

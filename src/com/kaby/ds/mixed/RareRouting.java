package com.kaby.ds.mixed;

import com.kaby.ds.helper.ResultPair;

import java.util.*;

// GRAPH
public class RareRouting {

    /**
     * Write a function, rareRouting, that takes in a number of cities (n) and a two dimensional array where
     * each subarray represents a direct road that connects a pair of cities. The function should return a boolean
     * indicating whether or not there exists a unique route for every pair of cities. A route is a sequence of roads
     * that does not visit a city more than once.
     * <p>
     * Cities will be numbered 0 to n - 1.
     * <p>
     * You can assume that all roads are two-way roads. This means if there is a road between A and B, then you can use that road to go from A to B or go from B to A.
     * <p>
     * For example, given these roads:
     * <p>
     * 0 --- 1
     * | \
     * |  \
     * |   \
     * 2    3
     * <p>
     * There is a unique route for between every pair of cities.
     * So the answer is true.
     * <p>
     * <p>
     * For example, given these roads:
     * <p>
     * 0 --- 1
     * | \
     * |  \
     * |   \
     * 2 -- 3
     * <p>
     * There are two routes that can be used to travel from city 1 to city 2:
     * - first route:  1, 0, 2
     * - second route: 1, 0, 3, 2
     * The answer is false, because routes should be unique.
     *
     * @param args
     */
    public static void main(String[] args) {

        // == test_00: ==

        Boolean isRareRouting1 = rareRouting(4, new Integer[][]{
                {0, 1},
                {0, 2},
                {0, 3}
        }); // -> true
        ResultPair<Boolean, Boolean> resultPair1 = new ResultPair<>("Is there a unique route for every pair of cities ", Boolean.TRUE, isRareRouting1);
        resultPair1.assertMatch();


        // == test_01: ==

        Boolean isRareRouting2 = rareRouting(4, new Integer[][]{
                {0, 1},
                {0, 2},
                {0, 3},
                {3, 2}
        }); // -> false
        ResultPair<Boolean, Boolean> resultPair2 = new ResultPair<>("Is there a unique route for every pair of cities ", Boolean.FALSE, isRareRouting2);
        resultPair2.assertMatch();


        // == test_02: ==

        Boolean isRareRouting3 = rareRouting(6, new Integer[][]{
                {1, 2},
                {5, 4},
                {3, 0},
                {0, 1},
                {0, 4},
        }); // -> true
        ResultPair<Boolean, Boolean> resultPair3 = new ResultPair<>("Is there a unique route for every pair of cities ", Boolean.TRUE, isRareRouting3);
        resultPair3.assertMatch();

    }

    private static Boolean rareRouting(int numCities, Integer[][] roads) {

        // Let us convert the given edge list into an adjacency list
        Map<Integer, LinkedList<Integer>> graph = makeGraph(numCities, roads);

        // Track the visited cities
        Set<Integer> visited = new HashSet<>();

        // Recursively validate the graph starting at city 0. The previous node is null initially
        Boolean valid = validate(graph, 0, visited, null);

        // If valid and we were able to visit every city once return TRUE
        return valid && visited.size() == numCities;
    }

    private static Boolean validate(Map<Integer, LinkedList<Integer>> graph, int node, Set<Integer> visited, Integer previousNode) {

        // If we have already visited the node return false
        if(visited.contains(node)) {
            return Boolean.FALSE;
        }
        // Else add to the set of visited nodes
        visited.add(node);

        // Now let us check all the neighbors
        // We want to make sure we do not go back to the previous Node here
        for(Integer neighbor : graph.get(node)) {
            if(neighbor != previousNode && validate(graph, neighbor, visited, node) == Boolean.FALSE) {
                return Boolean.FALSE;
            }
        }

        // Everything validated fine
        return Boolean.TRUE;
    }

    private static Map<Integer, LinkedList<Integer>> makeGraph(int numCities, Integer[][] roads) {
        Map<Integer, LinkedList<Integer>> graph = new HashMap<>();

        for(int city = 0; city < numCities; city++) {
            graph.put(city, new LinkedList<>());
        }

        for(Integer[] road : roads) {
            // The road connects both ways, hence undirected
            graph.get(road[0]).offer(road[1]);
            graph.get(road[1]).offer(road[0]);
        }

        return graph;
    }
}

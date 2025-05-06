package com.kaby.ds.graph;

import com.kaby.ds.helper.ResultPair;

import java.util.*;

public class SemestersRequired {


    /**
     * Write a function, semestersRequired, that takes in a number of courses (n) and a list of
     * prerequisites as arguments. Courses have ids ranging from 0 through n - 1. A single prerequisite
     * of [A, B] means that course A must be taken before course B. Return the minimum number of semesters
     * required to complete all n courses. There is no limit on how many courses you can take in a
     * single semester, as long the prerequisites of a course are satisfied before taking it.
     * <p>
     * Note that given prerequisite [A, B], you cannot take course A and course B concurrently in
     * the same semester. You must take A in some semester before B.
     * <p>
     * You can assume that it is possible to eventually complete all courses.
     *
     * @param args
     */
    public static void main(String[] args) {

//        const numCourses = 6;
//        const prereqs = [
//          [1, 2],
//          [2, 4],
//          [3, 5],
//          [0, 5],
//        ];

        // TEST 1
        int numCourses = 6;
        Integer[][] prereqs = new Integer[][]{
                {1, 2},
                {2, 4},
                {3, 5},
                {0, 5}
        };
        int semestersRequired1 = semestersRequired(numCourses, prereqs); // -> 3
        ResultPair<Integer, Integer> resultPair = new ResultPair<>("The number of semesters required is ", 3, semestersRequired1);
        resultPair.assertMatch();


//        ===========================

//        const numCourses = 7;
//        const prereqs = [
//          [4, 3],
//          [3, 2],
//          [2, 1],
//          [1, 0],
//          [5, 2],
//          [5, 6],
//        ];

        // TEST 2
        int numCourses2 = 7;
        Integer[][] prereqs2 = new Integer[][]{
                {4, 3},
                {3, 2},
                {2, 1},
                {1, 0},
                {5, 2},
                {5, 6}
        };
        int semestersRequired2 = semestersRequired(numCourses2, prereqs2); // -> 5
        ResultPair<Integer, Integer> resultPair2 = new ResultPair<>("The number of semesters required is ", 5, semestersRequired2);
        resultPair2.assertMatch();


    }

    private static int semestersRequired(int numCourses, Integer[][] prereqs) {
        // To make life simple let's do an adjacency list of the prerequisites edge list
        Map<Integer, List<Integer>> graph = buildDirectedGraph(numCourses, prereqs);

        // A Map to track the distance from the terminal node
        Map<Integer, Integer> distance = new HashMap<>();

        // Let's Iterate over each course in the adjacency list
        for(Integer course : graph.keySet()) {
            // base case - finding the terminal course that will be done last
            if(graph.get(course).isEmpty()) {
                // The last course is at a distance of 0 from itself
                // But since we are counting number of nodes we will initialize to 1
                distance.put(course, 1);
            }
        }

        // Now that we have the terminal courses, let's figure out the distance of the other courses
        // from the terminal courses
        // We will be doing a recursive DFS
        for(Integer course : graph.keySet()) {
            exploreDistance(graph, course, distance);
        }

        // We have explored all the courses and the distance of each in a component of related courses from their terminal
        // course which has to be done last
        // So return the max distance
        return Collections.max(distance.values());
    }

    private static Integer exploreDistance(Map<Integer, List<Integer>> graph, Integer course, Map<Integer, Integer> distance) {
        // if the node is already in distance, return that value directly as we have determined the distance already from a terminal course
        if(distance.containsKey(course)) {
            return distance.get(course);
        }

        // track the max distance
        int maxDistance = 0;

        // look through the neighbors
        for(Integer neighborCourse : graph.get(course)) {
            int neighborDist = exploreDistance(graph, neighborCourse, distance);
            if(neighborDist > maxDistance) {
                maxDistance = neighborDist;
            }
        }

        // Update distances for this course, it is one additional to distance from the
        // neighbor of the course
        distance.put(course, 1 + maxDistance);

        // Return the max distance for the course
        return distance.get(course);
    }

    private static Map<Integer, List<Integer>> buildDirectedGraph(int numCourses, Integer[][] prereqs) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        // for number of courses initialize the graph
        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new LinkedList<>());
        }

        // Since this is directed there is only one direction
        for (Integer[] prereq : prereqs) {
            graph.get(prereq[0]).add(prereq[1]);
        }

        // Print the graph
        System.out.println("*************");
        System.out.println("Input graph => \n" + graph);
        System.out.println("*************");


        return graph;
    }
}

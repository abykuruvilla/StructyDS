package com.kaby.ds.graph;

import com.kaby.ds.graph.util.GraphUtil;
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


    }

    private static int semestersRequired(int numCourses, Integer[][] prereqs) {
        // To make life simple let's do an adjacency list of the prerequisites edge list
        Map<Integer, List<Integer>> graph = buildDirectedGraph(numCourses, prereqs);


        return 0;
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

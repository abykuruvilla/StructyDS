package com.kaby.ds.binarytree;

import com.kaby.ds.helper.ResultPair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LevelAverages {


    /**
     * Write a function, levelAverages, that takes in the root of a binary tree
     * that contains number values. The function should return an array containing
     * the average value of each level.
     * @param args
     */
    public static void main(String[] args) {
        ResultPair<Double[], Double[]> result0 = test0();
        System.out.println("Expected: " + Arrays.deepToString(result0.getExpectedVal()) +
                "\nActual: " + Arrays.deepToString(result0.getActualVal()));

    }

    private static ResultPair<Double[], Double[]> test0() {

        Node<Integer> a = new Node<>(3);
        Node<Integer> b = new Node<>(11);
        Node<Integer> c = new Node<>(4);
        Node<Integer> d = new Node<>(4);
        Node<Integer> e = new Node<>(-2);
        Node<Integer> f = new Node<>(1);

        a.leftNode = b;
        a.rightNode = c;
        b.leftNode = d;
        b.rightNode = e;
        c.rightNode = f;

        //       3
        //    /    \
        //   11     4
        //  / \      \
        // 4   -2     1

        List<Double> actual = levelAverages(a); // -> [ 3, 7.5, 1 ]
        Double[] actualStringArray = actual.toArray(Double[]::new);
        Double[] expected = new Double[] {3.0, 7.5, 1.0};

        return new ResultPair<>(expected, actualStringArray);
    }

    private static List<Double> levelAverages(Node<Integer> root) {
        List<List<Integer>> levels = new ArrayList<>();

        // Get the List grouped by levels
        levelAveragesHelper(root, levels, 0);

        // Find the averages per level
        List<List<Double>> averagesPerLevel = new ArrayList<>();
        for(List<Integer> level : levels) {
            Double averagePerLevel = level.stream().mapToDouble(Integer::doubleValue).average().getAsDouble();
            averagesPerLevel.add(List.of(averagePerLevel));
        }
        List<Double> averages = averagesPerLevel.stream().flatMap(List::stream).collect(Collectors.toList());

        return averages;
    }

    private static void levelAveragesHelper(Node<Integer> root, List<List<Integer>> levels, int levelNumber) {

        // Every Level is assigned a number
        // Base condition: If node is null return
        if(root == null) {
            return;
        }

        // If current level being added is equal to the size of the array just add the node value
        if(levelNumber == levels.size()) {
            levels.add(new ArrayList<>(Arrays.asList(root.val)));
        } else {
            levels.get(levelNumber).add(root.val);
        }

        // Call the method recursively with the children at current level + 1
        levelAveragesHelper(root.leftNode, levels, levelNumber + 1);
        levelAveragesHelper(root.rightNode, levels, levelNumber + 1);

    }


}

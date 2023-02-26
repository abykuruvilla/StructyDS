package com.kaby.ds.binarytree;

import com.kaby.ds.helper.Pair;
import com.kaby.ds.helper.ResultPair;

import java.util.*;

public class TreeLevels {

    /**
     * Write a function, treeLevels, that takes in the root of a binary tree.
     * The function should return a 2-Dimensional array where each subarray represents a level of the tree.
     * @param args
     */
    public static void main(String[] args) {

        ResultPair<String[][], String[][]> result0 = test0();
        System.out.println("Expected: " + Arrays.deepToString(result0.getExpectedVal()) +
                "\nActual: " + Arrays.deepToString(result0.getActualVal()));

    }

    private static ResultPair<String[][], String[][]> test0() {
        Node<String> a = new Node<>("a");
        Node<String> b = new Node<>("b");
        Node<String> c = new Node<>("c");
        Node<String> d = new Node<>("d");
        Node<String> e = new Node<>("e");
        Node<String> f = new Node<>("f");

        a.leftNode = b;
        a.rightNode = c;
        b.leftNode = d;
        b.rightNode = e;
        c.rightNode = f;

        //      a
        //    /   \
        //   b     c
        //  / \     \
        // d   e     f

        List<List<String>> actual = treeLevelsRecursive(a); // ->
        // [
        //   ['a'],
        //   ['b', 'c'],
        //   ['d', 'e', 'f']
        // ]
        String[][] expected = new String[][]{
                {"a"},
                {"b", "c"},
                {"d", "e", "f"}
        };

        String[][] actualStringArray = actual.stream()
                .map(res -> res.toArray(new String[res.size()]))
                .toArray(String[][]::new);

        return new ResultPair<>(expected, actualStringArray);
    }

    // BFS Iterative
    private static List<List<String>> treeLevels(Node<String> root) {

        // The result is s 2D array
        List<List<String>> result = new ArrayList<>();

        // This can be done as level order traversal BFS
        // If root is null return an empty list
        if(root == null) {
            return new ArrayList<>();
        }

        // We want to store the node value and its level, hence using a Pair<nodeVal, levelNumber>
        // Add the root node to queue with level 0
        Queue<Pair<Node<String>, Integer>> queue = new LinkedList<>();
        Pair<Node<String>, Integer> rootPair = new Pair<>(root, 0);
        queue.offer(rootPair);

        while(!queue.isEmpty()) {
            Pair<Node<String>, Integer> currentNodeAndLevel = queue.poll();
            // Add to result at correct level
            int currentIndex = currentNodeAndLevel.getValB();
            if(currentIndex == result.size()) {
                // If the result array does not have the level, add
                result.add(new ArrayList<>(Arrays.asList(currentNodeAndLevel.getValA().val))); // If you do not use new ArrayList this will throw UnsupportedOperationException due to using Arrays.asList which is backed by a fixed size array
            } else {
                // Append the val to the list at level
                result.get(currentNodeAndLevel.getValB()).add(currentNodeAndLevel.getValA().val);
            }

            // Add pair of left node and level to queue
            if(currentNodeAndLevel.getValA().leftNode != null) {
                Pair<Node<String>, Integer> leftPair = new Pair<>(currentNodeAndLevel.getValA().leftNode, currentNodeAndLevel.getValB() + 1);
                queue.offer(leftPair);
            }
            // Add pair of right node and level to queue
            if(currentNodeAndLevel.getValA().rightNode != null) {
                Pair<Node<String>, Integer> rightPair = new Pair<>(currentNodeAndLevel.getValA().rightNode, currentNodeAndLevel.getValB() + 1);
                queue.offer(rightPair);
            }

        }

        return result;
    }


    // DFS Iterative
    private static List<List<String>> treeLevelsDFSIterative(Node<String> root) {

        // The result is s 2D array
        List<List<String>> result = new ArrayList<>();

        // This can be done as level order traversal BFS
        // If root is null return an empty list
        if(root == null) {
            return new ArrayList<>();
        }

        // We want to store the node value and its level, hence using a Pair<nodeVal, levelNumber>
        // Add the root node to stack with level 0
        Stack<Pair<Node<String>, Integer>> stack = new Stack<>();
        Pair<Node<String>, Integer> rootPair = new Pair<>(root, 0);
        stack.push(rootPair);

        while(!stack.isEmpty()) {
            Pair<Node<String>, Integer> currentNodeAndLevel = stack.pop();
            // Add to result at correct level
            int currentIndex = currentNodeAndLevel.getValB();
            if(currentIndex == result.size()) {
                // If the result array does not have the level, add
                result.add(new ArrayList<>(Arrays.asList(currentNodeAndLevel.getValA().val)));
            } else {
                // Append the val to the list at level
                result.get(currentNodeAndLevel.getValB()).add(currentNodeAndLevel.getValA().val);
            }

            // Add pair of right node and level to queue
            if(currentNodeAndLevel.getValA().rightNode != null) {
                Pair<Node<String>, Integer> rightPair = new Pair<>(currentNodeAndLevel.getValA().rightNode, currentNodeAndLevel.getValB() + 1);
                stack.push(rightPair);
            }

            // Add pair of left node and level to queue
            if(currentNodeAndLevel.getValA().leftNode != null) {
                Pair<Node<String>, Integer> leftPair = new Pair<>(currentNodeAndLevel.getValA().leftNode, currentNodeAndLevel.getValB() + 1);
                stack.push(leftPair);
            }

        }

        return result;
    }

    // Recursive
    private static List<List<String>> treeLevelsRecursive(Node<String> root) {
        // The total list of all levels
        List<List<String>> allLevels = new ArrayList<>();

        // Root is at level 0
        // Recursively call this
        treeLevelsRecursiveHelper(root, allLevels, 0 );

        return allLevels;
    }

    private static void  treeLevelsRecursiveHelper(Node<String> root, List<List<String>> allLevels, int levelNumber) {

        // Return if node is null
        if(root == null) {
            return;
        }

        if(levelNumber == allLevels.size()) {
            // If the result array does not have the level, add
            allLevels.add(new ArrayList<>(Arrays.asList(root.val)));
        } else {
            // Append the val to the list at level
            allLevels.get(levelNumber).add(root.val);
        }


        // Call on the left subtree
        treeLevelsRecursiveHelper(root.leftNode, allLevels, levelNumber + 1);
        // Call on the right subtree
        treeLevelsRecursiveHelper(root.rightNode, allLevels, levelNumber + 1);
    }

}

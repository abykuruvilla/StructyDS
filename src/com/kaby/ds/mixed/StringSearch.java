package com.kaby.ds.mixed;

import com.kaby.ds.helper.ResultPair;

import java.util.Arrays;
import java.util.List;

// GRAPH
public class StringSearch {

    /**
     * Write a function, stringSearch, that takes in a grid of letters and a string as arguments.
     * The function should return a boolean indicating whether or not the string can be found in the grid as a path by
     * connecting horizontal or vertical positions. The path can begin at any position, but you cannot reuse a position
     * more than once in the path.
     * <p>
     * You can assume that all letters are lowercase and alphabetic.
     *
     * @param args
     */
    public static void main(String[] args) {

        // == test_00:

        List<List<String>> grid0 = Arrays.asList(
                Arrays.asList("e", "y", "h", "i", "j"),
                Arrays.asList("q", "x", "e", "r", "p"),
                Arrays.asList("r", "o", "l", "l", "n"),
                Arrays.asList("p", "r", "x", "o", "h"),
                Arrays.asList("a", "a", "m", "c", "m")
        );
        Boolean result0 = stringSearch(grid0, "hello"); // -> true
        ResultPair<Boolean, Boolean> resultPair0 = new ResultPair<>("Sequence Found? ", Boolean.TRUE, result0);
        resultPair0.printResultPair();

        // == test_01:

        List<List<String>> grid1 = Arrays.asList(
                Arrays.asList("e", "y", "h", "i", "j"),
                Arrays.asList("q", "x", "e", "r", "p"),
                Arrays.asList("r", "o", "l", "l", "n"),
                Arrays.asList("p", "r", "x", "o", "h"),
                Arrays.asList("a", "a", "m", "c", "m")
        );
        Boolean result1 = stringSearch(grid1, "proxy"); // -> true
        ResultPair<Boolean, Boolean> resultPair1 = new ResultPair<>("Sequence Found? ", Boolean.TRUE, result1);
        resultPair1.printResultPair();

        // == test_02:

        List<List<String>> grid2 = Arrays.asList(
                Arrays.asList("e", "y", "h", "i", "j"),
                Arrays.asList("q", "x", "e", "r", "p"),
                Arrays.asList("r", "o", "l", "l", "n"),
                Arrays.asList("p", "r", "x", "o", "h"),
                Arrays.asList("a", "a", "m", "c", "m")
        );
        Boolean result2 = stringSearch(grid2, "rolling"); // -> false
        ResultPair<Boolean, Boolean> resultPair2 = new ResultPair<>("Sequence Found? ", Boolean.FALSE, result2);
        resultPair2.printResultPair();

        // == test_03:

        List<List<String>> grid3 = Arrays.asList(
                Arrays.asList("e", "y", "h", "i", "j"),
                Arrays.asList("q", "x", "e", "r", "p"),
                Arrays.asList("r", "o", "l", "l", "n"),
                Arrays.asList("p", "r", "x", "o", "h"),
                Arrays.asList("a", "a", "m", "z", "m")
        );
        Boolean result3 = stringSearch(grid3, "zoo"); // -> false
        ResultPair<Boolean, Boolean> resultPair3 = new ResultPair<>("Sequence Found? ", Boolean.FALSE, result3);
        resultPair3.printResultPair();

        // == test_04:

        List<List<String>> grid4 = Arrays.asList(
                Arrays.asList("q", "w", "h", "i", "j"),
                Arrays.asList("q", "e", "r", "o", "p"),
                Arrays.asList("h", "y", "t", "x", "z"),
                Arrays.asList("k", "o", "m", "o", "p")
        );
        Boolean result4 = stringSearch(grid4, "qwerty"); // -> true
        ResultPair<Boolean, Boolean> resultPair4 = new ResultPair<>("Sequence Found? ", Boolean.TRUE, result4);
        resultPair4.printResultPair();

        // == test_05:

        List<List<String>> grid5 = Arrays.asList(
                Arrays.asList("f", "d", "i", "e", "l", "u", "j", "t", "q", "v", "o", "p"),
                Arrays.asList("o", "p", "b", "e", "m", "w", "m", "l", "h", "j", "s", "v"),
                Arrays.asList("g", "b", "s", "m", "i", "w", "w", "h", "l", "m", "l", "n"),
                Arrays.asList("a", "l", "s", "k", "p", "c", "t", "u", "v", "b", "c", "m"),
                Arrays.asList("m", "t", "c", "k", "e", "n", "r", "b", "a", "z", "l", "c"),
                Arrays.asList("q", "m", "a", "p", "a", "p", "i", "i", "u", "t", "z", "z"),
                Arrays.asList("d", "u", "z", "o", "e", "r", "a", "t", "t", "c", "q", "k"),
                Arrays.asList("f", "u", "z", "g", "c", "i", "k", "v", "o", "f", "s", "w"),
                Arrays.asList("p", "h", "u", "i", "k", "c", "v", "v", "h", "q", "v", "i"),
                Arrays.asList("l", "q", "w", "f", "y", "g", "w", "f", "a", "u", "x", "q")
        );
        Boolean result5 = stringSearch(grid5, "paprika"); // -> true
        ResultPair<Boolean, Boolean> resultPair5 = new ResultPair<>("Sequence Found? ", Boolean.TRUE, result5);
        resultPair5.printResultPair();

        // == test_06:

        List<List<String>> grid6 = Arrays.asList(
                Arrays.asList("s", "s", "s", "s", "s", "s", "s", "s", "s", "s", "s"),
                Arrays.asList("s", "s", "s", "s", "s", "s", "s", "s", "s", "s", "s"),
                Arrays.asList("s", "s", "s", "s", "s", "s", "s", "s", "s", "s", "s"),
                Arrays.asList("s", "s", "s", "s", "s", "s", "s", "s", "s", "s", "s"),
                Arrays.asList("s", "s", "s", "s", "s", "s", "s", "s", "s", "s", "s"),
                Arrays.asList("s", "s", "s", "s", "s", "s", "s", "s", "s", "s", "s"),
                Arrays.asList("s", "s", "s", "s", "s", "s", "s", "s", "s", "s", "s"),
                Arrays.asList("s", "s", "s", "s", "s", "s", "s", "s", "s", "x", "x"),
                Arrays.asList("s", "s", "s", "s", "s", "s", "s", "s", "s", "x", "h")
        );
        Boolean result6 = stringSearch(grid6, "sssssssh"); // -> false
        ResultPair<Boolean, Boolean> resultPair6 = new ResultPair<>("Sequence Found? ", Boolean.FALSE, result6);
        resultPair6.printResultPair();

        // == test_07:

        List<List<String>> grid7 = Arrays.asList(
                Arrays.asList("a", "b", "a"),
                Arrays.asList("t", "x", "x"),
                Arrays.asList("x", "x", "x")
        );
        Boolean result7 = stringSearch(grid7, "abat"); // -> true
        ResultPair<Boolean, Boolean> resultPair7 = new ResultPair<>("Sequence Found? ", Boolean.TRUE, result7);
        resultPair7.printResultPair();

    }

    private static Boolean stringSearch(List<List<String>> grid, String searchString) {

        // Start by iterating over the grid
        for (int r = 0; r < grid.size(); r++) {
            for (int c = 0; c < grid.get(0).size(); c++) {
                // For each row, col position start a DFS, if we have found the string, return TRUE
                if (dfs(grid, r, c, searchString)) {
                    return Boolean.TRUE;
                }
            }
        }

        // We could not find the string anywhere in the grid
        return Boolean.FALSE;
    }

    private static Boolean dfs(List<List<String>> grid, int r, int c, String searchString) {
        // If the search string is empty return TRUE
        if (searchString.isEmpty()) {
            return Boolean.TRUE;
        }

        // Check to see that my current row and col indexes are in bounds
        if (!positionInBounds(grid, r, c)) {
            return Boolean.FALSE;
        }

        // If we are in bounds now check if first char of string matches
        if (!String.valueOf(searchString.charAt(0)).equals(grid.get(r).get(c))) {
            return Boolean.FALSE;
        }

        // Recursively call in all directions
        // Every time we call pass in a substring without the first char
        String suffix = searchString.substring(1);

        // If a position is visited temporarily mark the value with a *
        // Save the original first
        String origVal = grid.get(r).get(c);
        grid.get(r).set(c, "*");

        Boolean result = dfs(grid, r - 1, c, suffix) ||
                dfs(grid, r + 1, c, suffix) ||
                dfs(grid, r, c - 1, suffix) ||
                dfs(grid, r, c + 1, suffix);

        // Set the value back to original value
        // This is needed to make sure some other branch search has the original value present to compare
        grid.get(r).set(c, origVal);

        return result;
    }

    private static boolean positionInBounds(List<List<String>> grid, int r, int c) {
        Boolean rowInBounds = r >= 0 && r < grid.size();
        Boolean colInBounds = c >= 0 && c < grid.get(0).size();

        return rowInBounds && colInBounds;
    }
}

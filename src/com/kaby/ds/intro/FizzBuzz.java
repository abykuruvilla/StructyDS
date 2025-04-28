package com.kaby.ds.intro;

import com.kaby.ds.helper.ResultPair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FizzBuzz {

    /**
     * Write a method, fizzBuzz, that takes in a number n as an argument.
     * The method should return a list containing numbers from 1 to n,
     * replacing certain numbers according to the following rules:
     *
     *     if the number is divisible by 3, make the element "fizz"
     *     if the number is divisible by 5, make the element "buzz"
     *     if the number is divisible by 3 and 5, make the element "fizzbuzz"
     *
     * @param args
     */
    public static void main(String[] args) {

        // == test0 ==
        List<Object> result0 = fizzBuzz(11); // -> [1,2,"fizz",4,"buzz","fizz",7,8,"fizz","buzz",11]
        ResultPair<List<Object>, List<Object>> resultPair0 = new ResultPair<>("FizzBuzz List for n = 11 is ", Arrays.asList(1,2,"fizz",4,"buzz","fizz",7,8,"fizz","buzz",11), result0);
        resultPair0.printResultPair();

        // == test1 ==
        List<Object> result1 = fizzBuzz(2); // -> [1,2]
        ResultPair<List<Object>, List<Object>> resultPair1 = new ResultPair<>("FizzBuzz List for n = 2 is ", Arrays.asList(1, 2), result1);
        resultPair1.printResultPair();

        // == test2 ==
        List<Object> result2 = fizzBuzz(16);
        ResultPair<List<Object>, List<Object>> resultPair2 = new ResultPair<>("FizzBuzz List for n = 16 is ", Arrays.asList(1,2,"fizz",4,"buzz","fizz",7,8,"fizz","buzz",11, "fizz", 13, 14, "fizzbuzz", 16), result2);
        resultPair2.printResultPair();


    }

    public static List<Object> fizzBuzz(int n) {
        List<Object> result = new ArrayList<>();

        // numbers from 1 to n
        for (int i = 1; i <= n; i++) {
            // check if divisible by 3 and 5 first
            if (i % 3 == 0 && i % 5 == 0) {
                result.add("fizzbuzz");
            } else if (i % 3 == 0) {
                result.add("fizz");
            } else if (i % 5 == 0) {
                result.add("buzz");
            } else {
                result.add(i);
            }
        }

        return result;
    }
}

package com.kaby.ds.intro;

public class IsNumberPrime {

    /**
     * Write a function, is_prime, that takes in a number as an argument.
     * The function should return a boolean indicating whether or not the given number is prime.
     *
     * A prime number is a number that is only divisible by two distinct numbers: 1 and itself.
     * @param inputValue
     * @return
     */
    public static boolean isPrime(int inputValue) {

        // For a prime number, it is only divisible by 1 and itself
        // Optimal solution is to search from 2 to the Square root of input value to see if it is divisible.
        // If it is divisible it is not a prime number
        for(int i = 2; i <= Math.sqrt(inputValue); i++) {
            if(inputValue % i == 0) {
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {
        int input1 = 7;    // true
        int input2 = 2017; // true
        int input3 = 2048; // false

        System.out.println("Number " + input1 + " is prime: Expected output = true ; Actual output = " + isPrime(input1));
        System.out.println("Number " + input2 + " is prime: Expected output = true ; Actual output = " + isPrime(input2));
        System.out.println("Number " + input3 + " is prime: Expected output = false ; Actual output = " + isPrime(input3));

    }
}

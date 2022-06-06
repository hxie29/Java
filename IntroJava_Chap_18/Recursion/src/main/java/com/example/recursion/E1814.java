/*(Find the largest number in an array) Write a recursive method that returns the
largest integer in an array. Write a test program that prompts the user to enter a
list of eight integers and displays the largest element.*/
package com.example.recursion;

public class E1814 {
    public static void main(String[] args) {
        int n = 12;
        System.out.println(n + " is odd? " + isOdd(n));
        System.out.println(n + " is even? " + isEven(n));
    }

    private static boolean isOdd(int n) {
        if (n == 1)
            return true;
        else
            return !isOdd(n-1);
    }

    private static boolean isEven(int n) {
        if (n == 0)
            return true;
        else
            return !isOdd(n-1);
    }
}

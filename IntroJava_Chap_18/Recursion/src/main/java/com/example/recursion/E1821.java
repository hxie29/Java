/*(Decimal to binary) Write a recursive method that converts a decimal number
into a binary number as a string. The method header is
public static String dec2Bin(int value)
Write a test program that prompts the user to enter a decimal number and displays
its binary equivalent.*/
package com.example.recursion;

public class E1821 {
    public static void main(String[] args) {
        int x = 356;
        System.out.println(dec2Bin(x));
        System.out.println(Integer.toBinaryString(x));
    }

    public static String dec2Bin(int x) {
        if (x > 0) {
            int digit = x % 2;
            return dec2Bin(x / 2) + digit;
        }
        else {
            return "";
        }
    }
}

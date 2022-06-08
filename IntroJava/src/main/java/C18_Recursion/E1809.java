/*(Print the characters in a string reversely) Write a recursive method that displays
a string reversely on the console using the following header:
public static void reverseDisplay(String value)
For example, reverseDisplay("abcd") displays dcba. Write a test program
that prompts the user to enter a string and displays its reversal.*/
package com.example.recursion;

import java.util.Scanner;

public class E1809 {
    public static void main(String[]args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String s = input.next();
        reverseDisplay(s);
    }

    public static void reverseDisplay(String s) {
        reverseDisplay(s, s.length() -1);
    }

    public static void reverseDisplay(String s, int index) {
        if (index >= 0) {
        System.out.print(s.charAt(index));
        reverseDisplay(s, index - 1);
        }
    }
}

/* (Print the characters in a string reversely) Rewrite Programming Exercise 18.9
using a helper method to pass the substring high index to the method. The
helper method header is
public static void reverseDisplay(String value, int high)
*/
package com.example.recursion;

import java.util.Scanner;

public class E1812 {
    public static void main(String[]args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String s = input.next();
        reverseDisplay(s, s.length());
    }

    public static void reverseDisplay(String s, int high) {
        if (high > 0) {
            System.out.print(s.substring(high - 1));
            reverseDisplay(s.substring(0, high - 1), high -1);
        }
    }

}

/*(Binary to decimal) Write a recursive method that parses a binary number as a
string into a decimal integer. The method header is
public static int bin2Dec(String binaryString)
Write a test program that prompts the user to enter a binary string and displays
its decimal equivalent.*/
package com.example.recursion;

public class E1823 {
    public static void main(String[] args) {
        String s = "110010010";
        System.out.println(bin2Dec(s));
        System.out.println(Integer.parseInt(s, 2));
    }

    public static int bin2Dec(String s) {
        if (s.length() > 1) {
            int digit = (int)Math.pow(2, s.length() - 1) * ((s.charAt(0) == '1') ? 1 : 0);
            return digit + bin2Dec(s.substring(1));
        }
        else {
            return (s.charAt(0) == '1') ? 1 : 0;
        }
    }
}

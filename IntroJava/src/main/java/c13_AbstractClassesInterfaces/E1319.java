package c13_AbstractClassesInterfaces;

import java.math.BigInteger;
import java.util.Scanner;

/*
(Convert decimals to fractions) Write a program that prompts the user to enter a
decimal number and displays the number in a fraction. (Hint: read the decimal
number as a string, extract the integer part and fractional part from the string,
and use the BigInteger implementation of the Rational class in Programming
Exercise 13.15 to obtain a rational number for the decimal number.) Here are some
sample runs:

Enter a decimal number: 3.25
The fraction number is 13/4
Enter a decimal number: –0.45452
The fraction number is –11363/25000
*/
public class E1319 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a decimal number:");
        String decimalStr = input.next();

        String n = decimalStr.split("[.]")[0];
        if (n.charAt(0) == '-') 
            checkDigit(n.substring(1));
        else 
            checkDigit(n);
            
        String d = decimalStr.split("[.]")[1];
        checkDigit(d);

        int digitSize = (int) Math.pow(10, d.length());
        long number = (long)(Double.parseDouble(decimalStr) * digitSize);
        checkDigit(d);

        RationalBig r = new RationalBig(new BigInteger(number + ""), new BigInteger(digitSize + ""));
        System.out.println("The fraction number is " + r);
        input.close();
    }

    public static void checkDigit(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                System.out.println("Wrong input: " + s);
                System.exit(1);
            }
        }
    }

}
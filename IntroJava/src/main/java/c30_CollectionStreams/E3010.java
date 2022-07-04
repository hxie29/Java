/*(Convert binary to decimal) Write a program that prompts the user to enter a
binary number in string and displays its decimal value. Use Stream’s reduce
method to convert a binary number to decimal.*/
package c30_CollectionStreams;

import java.util.Scanner;

public class E3010 {
    public static void main(String[] args) {
        System.out.println("Enter a binary number: ");
        Scanner input = new Scanner(System.in);
        String bin = input.next();
        int number = Integer.parseInt(bin, 2);
        //String chars() returns an IntStream
        int decimal = bin.chars().map(e -> e -'0').reduce(0, (a, b) -> a * 2 + b);
        System.out.println("The decimal number is " + decimal + " parseInt is " + number);
    }
}

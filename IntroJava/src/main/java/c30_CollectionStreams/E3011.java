/*(Convert hex to decimal) Write a program that prompts the user to enter a hex
number in string and displays its decimal value. Use Stream’s reduce method
to convert a hex number to decimal.*/
package c30_CollectionStreams;

import java.util.Scanner;

public class E3011 {
    public static void main(String[] args) {
        System.out.println("Enter a hex number: ");
        Scanner input = new Scanner(System.in);
        String bin = input.next().toLowerCase();
        input.close();
        int number = Integer.parseInt(bin, 16);
        //String chars() returns an IntStream
        int decimal = bin.chars().map(e -> (e -'0' < 10) ? e - '0' : e - 'a' + 10).reduce(0, (a, b) -> a * 16 + b);
        System.out.println("The decimal number is " + decimal + " parseInt hex is " + number);
    }
}

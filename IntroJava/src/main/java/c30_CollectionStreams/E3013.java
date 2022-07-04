//(Count the letters in a string) Rewrite Programming Exercise 6.20 using streams.
/*(Count the letters in a string) Write a method that counts the number of letters in
a string using the following header:
public static int countLetters(String s)
Write a test program that prompts the user to enter a string and displays the number
of letters in the string. */
package c30_CollectionStreams;

import java.util.Scanner;

public class E3013 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter a a string ");
        String s = input.nextLine();
        input.close();
        System.out.println("The number of letters in this string is " + s.toLowerCase().chars().filter(e -> e - 'a' >= 0 && e - 'z' <= 0).count());
    }
}

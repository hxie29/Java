/*(Occurrences of a specified character) Write a method that finds the number of
occurrences of a specified character in a string using the following header:
public static int count(String str, char a)
For example, count("Welcome", 'e') returns 2. Write a test program that
prompts the user to enter a string followed by a character then displays the number
of occurrences of the character in the string. */
package c30_CollectionStreams;

import java.util.Scanner;

public class E3014 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String str = input.nextLine();
        System.out.println("Enter a letter: ");
        char letter = Character.toLowerCase(input.next().charAt(0));
        System.out.println("Occurrence: " + str.toLowerCase().chars().filter(e -> e == (int) letter).count());
    }
}

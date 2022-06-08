package c07_SingleDimensionArrays;/* (Count the number of vowels in a string) Write a program that prompts the user to enter
a string, and counts and displays the number of both lowercase and uppercase vowels in the string. */

import java.util.Scanner;

public class E0722 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a string");
        String sentence = input.nextLine();
    
        char[] list = createArray(sentence);
        System.out.println("The array is:");
        displayArray(list);

        countVowels(list);
       
        input.close();
    }

    // parse the string into an array
    public static char[] createArray(String sentence) {
        char[] list = new char[sentence.length()];
        for (int i = 0; i < list.length; i++ ) {
            list[i] = sentence.charAt(i);
        }
        return list;
    }
    
    // Display integer array method, 20 per line
    public static void displayArray(char[] list) {
        int item = 0;
        for (char c : list) {
            item++;
            System.out.print((item % 20 == 0) ? c + "\n" : c + " ");
        } 
        System.out.println();
    }

    // count vowels and display
    public static void countVowels(char[] list) {
        int countLowCase = 0;
        int countHighCase = 0;
        for (char c : list) {
            if ("aeiou".contains(c + "")) countLowCase++;
            if ("AEIOU".contains(c + "")) countHighCase++;
        }

        System.out.println("Number of lower case vowels: " + countLowCase);
        System.out.println("Number of higher case vowels: " + countHighCase);
    }

}

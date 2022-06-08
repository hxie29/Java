package c07_SingleDimensionArrays;/* (Sort characters in a string) Write a method that returns a sorted string using the
following header:
public static String sort(String s)
For example, sort("acb") returns abc.
Write a test program that prompts the user to enter a string and displays the sorted
string. */

import java.util.Scanner;

public class E0734 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a string");
        String sentence = input.nextLine();
    
        char[] list = createArray(sentence);
        char[] newList = sortChar(list);
        String sentence2 = createString(newList);

        System.out.println("Sorted: " + sentence2);
       
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

     // bubble sort char
     public static char[] sortChar(char[] list) {
        int count = list.length - 1;
        while (count != 0) {
            count = 0;
            for (int i = 0; i < list.length -1; i++) {
                if (list[i] > list[i+1]) {
                    char temp = list[i];
                    list[i] = list[i+1];
                    list[i+1] = temp;
                    count++;
                }
            }
        }
        return list;
    }

    // parse the string into an array
    public static String createString(char[] list) {
        StringBuilder str = new StringBuilder();
        for (char c : list) {
            str.append(c);
        }
        return str.toString();
    }
}

/* Write a program that prompts the user to enter the number of students,
the students’ names, and their scores and prints student names in decreasing
order of their scores. Assume the name is a string without spaces, use the Scanner’s
next() method to read a name. */
package c07_SingleDimensionArrays;

import java.util.Scanner;

public class E0717 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of students:");
        int[] listScore = new int[input.nextInt()];
        String[] listName = new String[listScore.length];

        recordNameScore(listName, listScore);
        sortToScore(listName, listScore);
        displayList(listName, listScore);
        
        input.close();
    }
    
    // record name
    public static void recordNameScore(String[] name, int[] score) {
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < name.length; i++) {
            System.out.println("Enter next name and score");
            name[i] = input.next();
            score[i] = input.nextInt();
        }
        System.out.println("Recording complete.");
    }

    // sorting method
    public static void sortToScore(String[] name, int[] score) {
        System.out.println("Sorting...");
        for (int i = 0; i < name.length -1; i++) {
            int maxIndex = i;
            int max = score[i];
            // find the maximum score and its index after i
            for (int j = i+1; j < name.length; j++) {
                if (score[j] > max) {
                    maxIndex = j;
                    max = score[j];
                }
            }
            // swap scores and name list content
            if (maxIndex != i ) {
                // swap scores
                score[maxIndex] = score[i]; 
                score[i] = max;
                // swap names
                String temp = name[maxIndex];
                name[maxIndex] = name[i];
                name[i] = temp;
            }
        }
    }

    // display method
    public static void displayList(String[] name, int[] score) {
        System.out.printf("%-15s%-10s\n", "Name", "Score");
        for (int i = 0; i< name.length; i++) {
            System.out.printf("%-15s%-10d\n", name[i], score[i]);
        }
    }

}

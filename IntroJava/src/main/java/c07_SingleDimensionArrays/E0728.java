package c07_SingleDimensionArrays;/* (Normalizing integers) Write a program that prompts the user to enter 10 integers,
and normalizes the integers to be in the range of 0 to 1 by dividing every integer
with the largest integer. Display the 10 normalized real-valued numbers. */

import java.util.Objects;
import java.util.Scanner;

public class E0728 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the numbers of integers in the array:");
        int[] list = new int[input.nextInt()];
    
        // create an array
        createArray(list);
        System.out.println("The array is:");
        displayArray(list);

        // produce permutations
        String[] permutation = permutate(list);

        // Display permutations
        displayStringArray(permutation);

        input.close();
    }

    // create integer array
    public static void createArray(int[] list) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the numbers:");
        for (int i = 0; i < list.length; i++ ) {
            list[i] = input.nextInt();
        }
        input.close();
    }

    // Display array method, 20 per line
    public static void displayArray(int[] list) {
        int item = 0;
        for (int j : list) {
            item++;
            System.out.print((item % 20 == 0) ? j + "\n" : j + " ");
        } 
        System.out.println();
    }

    // find the total number of permutations
    public static int numberPermutation(int n) {
        int number = 1;
        for (int i= n; i > 0; i--) {
            number *= i;
        }
        return number;
    }

    // permutate
    public static String[] permutate(int[] list) {
        int count = 0;
        int index = 0;
        // create array to record permutations
        String[] permutation = new String[numberPermutation(list.length)];

        while (count < permutation.length) {
            shuffle(list);
            String newPermu = turnString(list);
            if (linearSearch(permutation, newPermu) == -1) {
                permutation[index] = newPermu;
                count++;
                index++;
            }
        }
        return permutation;
    }

    //shuffle a list of numbers
    public static void shuffle(int[] list) {
        for (int i = 0; i < list.length; i++) {
            int j = (int)(Math.random() * list.length);
            int temp = list[i];
            list[i] = list[j];
            list[j] = temp;
        }
    }

    // turn sequence into a string
    public static String turnString(int[] list) {
        StringBuilder str = new StringBuilder();
        for (int j : list) {
            str.append(j).append(" ");
        }
        return str.toString();
    }

    // linear search function
    public static int linearSearch(String[] permutation, String key){
        for (int i = 0; i < permutation.length; i++) {
            if (Objects.equals(key, permutation[i])) return i;
        }
        return -1;
    }

    // Display array method, 20 per line
    public static void displayStringArray(String[] list) {
        System.out.println();
        for (String s : list) {
            System.out.println(s);
        } 
    }
}

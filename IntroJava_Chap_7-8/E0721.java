/* (Normalizing integers) Write a program that prompts the user to enter 10 integers,
and normalizes the integers to be in the range of 0 to 1 by dividing every integer
with the largest integer. Display the 10 normalized real-valued numbers. */

import java.util.Scanner;

public class E0721 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the numbers of integers in the array:");
        int[] list = new int[input.nextInt()];

        createArray(list);
        System.out.println("The array is:");
        displayArray(list);

        double[] normalList = normalized(list);

        System.out.println("After normalization the array is");
        //display double array
        int item = 0;
        for (int i = 0; i < normalList.length; i++) {
            item++;
            System.out.print( (item % 20 == 0) ? normalList[i] + "\n" : normalList[i] + " ");
        } 
        input.close();
    }

    public static int[] createArray(int[] list) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the numbers:");
        for (int i = 0; i < list.length; i++ ) {
            list[i] = input.nextInt();
        }
        input.close();
        return list;
    }
    
    // Display integer array method, 20 per line
    public static void displayArray(int[] list) {
        int item = 0;
        for (int i = 0; i < list.length; i++) {
            item++;
            System.out.print( (item % 20 == 0) ? list[i] + "\n" : list[i] + " ");
        } 
        System.out.println();
    }

    // normalize method
    public static double[] normalized(int[] list) {
        double[] normal = new double[list.length];
        int max = list[0];
        for (int i = 1; i < list.length; i++) {
            if (max < list[i]) {
                max = list[i];
            }
        }

        for (int i = 0; i < list.length; i++) {
            normal[i] = list[i] * 1.0 / max;
        }
        return normal;
    }

}

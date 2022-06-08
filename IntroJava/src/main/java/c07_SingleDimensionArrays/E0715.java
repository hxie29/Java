package c07_SingleDimensionArrays;// Eliminate duplicates in a list of numbers

import java.util.Scanner;

public class E0715 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the numbers of integers in the array:");
        int[] list = new int[input.nextInt()];

        createArray(list);
        System.out.println("The array is:");
        displayArray(list);
        
        int[] direct = directList(list);
        System.out.println("The array without duplicated numbers is:");
        displayArray(direct);

        
        input.close();
    }

     // Display array method, 20 per line
     public static void displayArray(int[] list) {
        int item = 0;
         for (int j : list) {
             if (j > 0) {
                 item++;
                 System.out.print((item % 20 == 0) ? j + "\n" : j + " ");
             }
         }
        System.out.println();
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

    public static int[] directList(int[] list) {
        int[] direct = new int[list.length];
        for (int i = 0; i < list.length; i++) {
            if (linearSearch(direct, list[i]) == -1) {
                direct[i] = list[i];
            }
        }
        return direct;
    }

    public static int linearSearch(int[] list, int key) {
        for (int i = 0; i < list.length; i++) {
            if (key == list[i]) return i;
        }
        return -1;
    }
    
}

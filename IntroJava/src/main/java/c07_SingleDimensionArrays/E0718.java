package c07_SingleDimensionArrays;/* Write a sort method that uses the bubble-sort algorithm. The bubble-
sort algorithm makes several passes through the array. On each pass, successive
neighboring pairs are compared. If a pair is not in order, its values are
swapped; otherwise, the values remain unchanged. The technique is called a
bubble sort or sinking sort because the smaller values gradually “bubble” their
way to the top, and the larger values “sink” to the bottom. Write a test program
that reads in 10 double numbers, invokes the method, and displays the sorted numbers. */

import java.util.Scanner;

public class E0718 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the numbers of integers in the array:");
        int[] list = new int[input.nextInt()];

        createArray(list);
        System.out.println("The array is:");
        displayArray(list);
        
        bubbleSort(list);
        System.out.println("The array after sorting is:");
        displayArray(list);
        
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

    // bubble sort
    public static void bubbleSort(int[] list) {
        int count = list.length - 1;
        while (count != 0) {
            count = 0;
            for (int i = 0; i < list.length -1; i++) {
                if (list[i] > list[i+1]) {
                    int temp = list[i];
                    list[i] = list[i+1];
                    list[i+1] = temp;
                    count++;
                }
            }
        }
    }
}

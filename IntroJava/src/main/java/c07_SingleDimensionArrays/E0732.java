package c07_SingleDimensionArrays;/* (Partition of a list) Write the following method that partitions the list using the
first element, called a pivot: public static int partition(int[] list)

After the partition, the elements in the list are rearranged so all the elements before
the pivot are less than or equal to the pivot, and the elements after the pivot are
greater than the pivot. The method returns the index where the pivot is located in
the new list. For example, suppose the list is {5, 2, 9, 3, 6, 8}. After the partition,
the list becomes {3, 2, 5, 9, 6, 8}. */

import java.util.Scanner;

public class E0732 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the numbers of integers in the first array:");
        int[] list1 = new int[input.nextInt()];

        createArray(list1);
        System.out.println("The original list is:");
        displayArray(list1);

        int[] list2 = partition(list1);
        System.out.println("The list after partition is");
        displayArray(list2);

        int[] example = {10, 1, 5, 16, 61,  9, 11, 1};
        int[] list3 = partition(example);
        displayArray(list3);

        input.close();
    }

    // create integer array d d
    public static void createArray(int[] list) {
        for (int i = 0; i < list.length; i++ ) {
            list[i] = (int)(Math.random() * 100) + 1;
        }
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

    public static int[] partition(int[] list) {
        int pivot = 0;
        int low = 1;
        int high = list.length -1;
        int temp;

        while (high >= low ) {
            if (list[low] > list [high]) {
                temp = list[low];
                list[low] = list[high];
                list[high] = temp;
            }
            if (list[low] <= list[pivot]) low++;
            if (list[high] > list[pivot]) high--;
        }

        temp = list[high];
        list[high] = list[pivot];
        list[pivot] = temp;

        return list;
    }
}

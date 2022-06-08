package c07_SingleDimensionArrays;/* (Merge two sorted lists) Write the following method that merges two sorted lists
into a new sorted list:
public static int[] merge(int[] list1, int[] list2)
Implement the method in a way that takes at most list1.length + list2. */

import java.util.Scanner;

public class E0731 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the numbers of integers in the first array:");
        int[] list1 = new int[input.nextInt()];

        createArray(list1);
        System.out.println("The first list is:");
        displayArray(list1);
        
        bubbleSort(list1);
        System.out.println("The sorted first list is:");
        displayArray(list1);

        System.out.println("Enter the number of integers in the second array:");
        int[] list2 = new int[input.nextInt()];

        createArray(list2);
        System.out.println("The second list is:");
        displayArray(list2);
        
        bubbleSort(list2);
        System.out.println("The sorted second list is:");
        displayArray(list2);

        int[] list3 = mergeList(list1, list2);
        System.out.println("The merged list is:");
        displayArray(list3);
        
        input.close();
    }

    // create integer array
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

    // merge two sorted list
    public static int[] mergeList(int[] list1, int[] list2) {
        int[] newList = new int[list1.length + list2.length];
        int index1 = 0;
        int index2 = 0;
        for (int i = 0; i < newList.length; i++ ) {
            // !!!!! an out of bound error happens here!!!!!
            if (index1 <= list1.length -1 && index2 <= list2.length -1) {
                if (list1[index1] <= list2[index2]) { 
                    newList[i] = list1[index1];
                    index1++;
                }
                else {
                    newList[i] = list2[index2];
                    index2++;
                }
            }
            else if (index1 > list1.length -1) {
                    newList[i] = list2[index2];
                    index2 ++;
                }
            else {
                newList[i] = list1[index1];
                index1++;
            }
        }
        return newList;
    }
}

/*  Write a recursive method that displays all permutations of a given array of
integers. Here is a sample run:
Enter the array size : 3
[1, 2, 3]
[1, 3, 2]
[2, 1, 3]
[2, 3, 1]
[3, 1, 2]
[3, 2, 1]
*/
package com.example.recursion;

import java.util.Arrays;
import java.util.Scanner;

public class E1811 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the array size:");
        listPermutation(input.nextInt());
    }

    private static void listPermutation(int n) {
        int[] list = new int[n];
        for (int i = 0; i < n; i++) {
            list[i] = i + 1;
        }
        permute(list, 0, list.length-1);
    }

    private static void permute(int[] list, int i, int n) {
        if (i == n)
            System.out.println(Arrays.toString(list));
        else {
            for (int j = i; j <= n; j++) {
                swap(list, i, j);
                permute(list, i + 1, j);
                swap(list, i, j);
            }
        }
    }

    private static void swap(int[] list, int i, int j) {
        int temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }
}

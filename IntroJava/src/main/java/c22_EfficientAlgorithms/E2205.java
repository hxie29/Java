/*(Fill and sort array) Write a program that randomly fills an array of integers and
then sorts it. The array size is entered by the user and the values are chosen at random
in {-1, 0, 1}. Analyze the time complexity of your program. Here is a sample run:
Enter the size: 10
1 0 1 −1 0 1 −1 0 0 0
−1 −1 0 0 0 0 0 1 1 1 */
package c22_EfficientAlgorithms;

import java.util.Scanner;

public class E2205 {
    public static void main(String[] args) {
        System.out.println("Enter the size:");
        Scanner input = new Scanner(System.in);
        int size = input.nextInt();
        int[] count = new int[3];
        int[] elements = {-1,0,1};

        // time = n * c;
        for (int i = 0; i < size; i++) {
            int index = (int)(Math.random() * 3);
            System.out.print(elements[index] + " ");
            count[index]++;
        }
        System.out.println();

        // time = n * c
        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[i]; j++) {
                System.out.print(elements[i] + " ");
            }
        }

        // total time = n * c * 2, O(n)
    }
}

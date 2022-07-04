//Rewrite E0715 using streams and display numbers in increasing order
/*(Eliminate duplicates) Write a method that returns a new array by eliminating the
duplicate values in the array using the following method header:
public static int[] eliminateDuplicates(int[] list)
Write a test program that reads in 10 integers, invokes the method, and displays
the distinct numbers separated by exactly one space. Here is a sample run of the
program:
Enter 10 numbers: 1 2 3 2 1 6 3 4 5 2
The distinct numbers are: 1 2 3 6 4 5 */
package c30_CollectionStreams;

import java.util.Scanner;
import java.util.stream.IntStream;

public class E3008 {
    public static void main(String[] args) {
        int[] list = new int[10];
        Scanner input = new Scanner(System.in);
        System.out.println("Enter ten numbers: ");
        for (int i = 0; i < list.length; i++) {
            list[i] = input.nextInt();
        }
        input.close();
        System.out.print("The distinct numbers are: " );
        IntStream.of(list).distinct().sorted().forEach(e -> System.out.print(e + " "));
    }
}

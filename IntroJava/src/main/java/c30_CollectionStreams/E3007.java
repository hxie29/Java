//Rewrite E0709 using streams
/*(Find the largest element) Write a method that finds the largest element in an array
of double values using the following header:
public static double max(double[] array)
Write a test program that prompts the user to enter ten numbers, invokes this
method to return the maximum value, and displays the maximum value. Here is
a sample run of the program:
Enter ten numbers: 1.9 2.5 3.7 2 1.5 6 3 4 5 2
The maximum number is: 6 */
package c30_CollectionStreams;

import java.util.Scanner;
import java.util.stream.DoubleStream;

public class E3007 {
    public static void main(String[] args) {
        double[] list = new double[10];
        Scanner input = new Scanner(System.in);
        System.out.println("Enter ten numbers: ");
        for (int i = 0; i < list.length; i++) {
            list[i] = input.nextDouble();
        }
        input.close();
        System.out.println("The maximum number is " + DoubleStream.of(list).max().getAsDouble());
    }
}

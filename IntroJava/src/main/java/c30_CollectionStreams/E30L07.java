/*Section 7.3 gives a program that prompts the user to enter values, obtains their average, and
displays the number of values greater than the average. The program can be simplified using
a DoubleStream as shown in Listing 30.7.*/
package c30_CollectionStreams;

import java.util.Scanner;
import java.util.stream.DoubleStream;

public class E30L07 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of items ");
        int n = input.nextInt();
        double[] numbers = new double[n];

        System.out.println("Enter the numbers:");
        for (int i = 0; i < n; i++) {
            numbers[i] = input.nextDouble();
        }

        input.close();

        double average = DoubleStream.of(numbers).average().getAsDouble();
        System.out.println("The average is " + average);
        System.out.println("Number of elements above the average is " + DoubleStream.of(numbers).filter(e -> e > average).count());
    }
}

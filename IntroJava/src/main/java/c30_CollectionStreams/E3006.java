//Rewrite E0708 using streams
/*(Average an array) Write two overloaded methods that return the average of an
array with the following headers:
public static int average(int[] array)
public static double average(double[] array)
Write a test program that prompts the user to enter 10 double values, invokes this
method, then displays the average value.*/
package c30_CollectionStreams;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class E3006 {
    public static void main(String[] args) {
        int[] list = new int[200];
        double[] list2 = new double[200];
        for (int i = 0; i < list.length; i++) {
            list[i]= (int)(Math.random() * 10);
            list2[i] = Math.random() * 10;
        }
        System.out.println(average(list));
        System.out.println(average(list2));
    }

    public static int average(int[] array) {
        return (int)IntStream.of(array).average().getAsDouble();
    }

    public static double average(double[] array) {
        return DoubleStream.of(array).average().getAsDouble();
    }
}

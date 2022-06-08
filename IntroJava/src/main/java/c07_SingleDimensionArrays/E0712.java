package c07_SingleDimensionArrays;// Reverse an array and return itself
import java.util.Scanner;

public class E0712 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the numbers of integers in the array:");
        double[] list = new double[input.nextInt()];

        createArray(list);
        System.out.println("The array before reversing is:");
        displayArray(list);

        reverse(list);
        System.out.println("The array after reversing is:");
        displayArray(list);

        input.close();
    }

    public static void createArray(double[] list) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the numbers:");
        for (int i = 0; i < list.length; i++ ) {
            list[i] = input.nextDouble();
        }
        input.close();
    }

    // Display array method, 20 per line
    public static void displayArray(double[] list) {
        int item = 0;
        for (double v : list) {
            item++;
            System.out.print((item % 20 == 0) ? v + "\n" : v + " ");
        } 
        System.out.println();
    }

    public static void reverse(double[] list) {
        for (int i = 0; i < list.length / 2; i++ ) {
            double temp = list[i];
            list[i] = list[list.length-1-i];
            list[list.length-1-i] = temp;
        }
    }
}

package c07_SingleDimensionArrays;// Reads 10 integers, count even and odd numbers
import java.util.Scanner;

public class E0705 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of integers:");
        int[] list = new int[input.nextInt()];

        countEven(list);
        input.close();
    }

    public static void countEven(int[] list) {
        int even = 0;
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < list. length; i++) {
            list[i] = input.nextInt();
            if (list[i] % 2 == 0) even++;
        }
        System.out.println("The number of even numbers: " + even);
        System.out.println("The number of odd numbers: " + (list.length - even));
        input.close();
    }
    
}

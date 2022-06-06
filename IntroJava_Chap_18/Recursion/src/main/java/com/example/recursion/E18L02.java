// Compute Fibonacci
package com.example.recursion;
import java.util.Scanner;
public class E18L02 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter an index for a Fibonacci number:");
        int index = input.nextInt();
        System.out.printf("The Fibonacci number at index %d is %d", index, fib(index));
    }

    private static long fib(long index) {
        if (index == 0) return 0;
        else if (index == 1) return 1;
        else return fib(index -1) + fib(index - 2);
    }
}

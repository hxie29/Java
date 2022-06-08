/*(Fibonacci series) Modify Listing 18.2, ComputeFibonacci.java, so that the program
finds the number of times the fib method is called. (Hint: Use a static
variable and increment it every time the method is called.)*/
package com.example.recursion;
import java.util.Scanner;

public class E1807 {
    private static int call = 0;

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter an index for a Fibonacci number:");
        int index = input.nextInt();
        System.out.printf("The Fibonacci number at index %d is %d\n", index, fib(index));
        System.out.print("Recursion called " + call + " times");
    }

    private static long fib(long index) {
        call++;
        if (index == 0) return 0;
        else if (index == 1) return 1;
        else return fib(index -1) + fib(index - 2);
    }
}

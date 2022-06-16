/*(Remove Consecutive Integers) Write a program that reads 10 integers and
displays them in the reverse of the order in which they were read. If two consecutive
numbers are identical, then only display one of them. Implement your
program using only stack and not arrays or queues.*/
package c03_Selections;

import java.util.Scanner;
import java.util.Stack;

public class E2011 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Stack<Integer> numbers = new Stack<>();
        System.out.println("Enter 10 integers: ");
        for (int i = 0; i < 10; i++) {
            Integer n = input.nextInt();
            if (!numbers.contains(n)) {
                numbers.push(n);
            }
        }
        while (numbers.size() > 0) {
            System.out.print(numbers.pop() + " ");
        }
    }
}

/*
(Display the prime factors) Write a program that prompts the user to enter a
positive integer and displays all its smallest factors in decreasing order. For
example, if the integer is 120, the smallest factors are displayed as 5, 3, 2, 2, 2. 
Use the StackOfIntegers class to store the factors (e.g., 2, 2, 2, 3, 5) and
retrieve and display them in reverse order.
*/

import java.util.Scanner;

public class E1005 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter an integer:");
        int n = input.nextInt();
        StackOfIntegers stack = new StackOfIntegers();

        while (n > 1) {
            for (int i = 2; i <= n; i++) {
                if (n % i == 0) {
                    stack.push(i);
                    n /= i;
                    break;
                }
            }
        }
    
        while(!stack.empty()) {
           System.out.println(stack.pop() + " ");
        }

        input.close();
    }
}

class StackOfIntegers {
    // DATA fields
    private int[] elements;
    private int size;
    public static final int DEFAULT_CAPACITY = 16;

    // Constructors
    public StackOfIntegers() {
        this(DEFAULT_CAPACITY);
    }

    public StackOfIntegers(int capacity) {
        elements = new int[capacity];
    }

    public void push(int value){
        if (size >= elements.length) {
            int[] temp = new int[elements.length * 2];
            System.arraycopy(elements, 0, temp, 0, elements.length);
            elements = temp;
        }
        elements[size++] = value;
    }

    public int pop(){
        return elements[--size];
    }
    
    public int getSize() {
        return size;
    }

    public boolean empty() {
        return (size == 0);
    }

    public int peek() {
        return elements[size - 1];
    }
}

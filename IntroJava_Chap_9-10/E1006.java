/*
(Display the prime numbers) Write a program that displays all the prime numbers
less than 120 in decreasing order. Use the StackOfIntegers class to
store the prime numbers (e.g., 2, 3, 5, . . . ) and retrieve and display them in
reverse order.
*/


public class E1006 {
    public static void main(String[] args) {
        StackOfIntegers stack = new StackOfIntegers();

        for (int i = 2; i <= 120; i++) {
            if (isPrime(i)) {
                stack.push(i);
            }
        }
    
        while(!stack.empty()) {
           System.out.print (stack.pop() + " ");
        }
    }

    public static boolean isPrime(int n) {
        boolean prime = true;
        for (int i = 2; i < n; i++) {
            if (n % i == 0) return false;
        }
        return prime;
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

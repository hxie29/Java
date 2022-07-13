/*(Fibonacci number iterator) Define an iterator class named Fibonacci
Iterator for iterating Fibonacci numbers. The constructor takes an argument
that specifies the limit of the maximum Fibonacci number. For example, new
FibonacciIterator(23302) creates an iterator that iterates Fibonacci numbers
less than or equal to 23302. Write a test program that uses this iterator to
display all Fibonacci numbers less than or equal to 120000.*/
package c24_ImpleListStackQueue;

import java.util.Iterator;

public class FibonacciIterator implements Iterator<Integer> {
    private final int limit;
    private int current = 0;
    private int next = 1;

    public FibonacciIterator(int limit) {
        this.limit = limit;
    }

    @Override
    public boolean hasNext() {
        return current <= limit;
    }

    @Override
    public Integer next() {
        if (hasNext()) {
            int temp = current;
            current = next;
            next += temp;
            return temp;
        }
        return null;
    }
}

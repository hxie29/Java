/*(Fibonacci number iterator) Define an iterator class named Fibonacci
Iterator for iterating Fibonacci numbers. The constructor takes an argument
that specifies the limit of the maximum Fibonacci number. For example, new
FibonacciIterator(23302) creates an iterator that iterates Fibonacci numbers
less than or equal to 23302. Write a test program that uses this iterator to
display all Fibonacci numbers less than or equal to 120000.*/
package c24_ImpleListStackQueue;

public class E2413 {
    public static void main(String[] args) {
        FibonacciIterator iterator = new FibonacciIterator(120000);
        int count = 0;
        while (iterator.hasNext())
            System.out.print(iterator.next() + (++count % 10 == 0 ? "\n" : " " ));
    }
}

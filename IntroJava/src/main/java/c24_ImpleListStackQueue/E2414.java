/*(Prime number iterator) Define an iterator class named PrimeIterator for
iterating prime numbers. The constructor takes an argument that specifies the limit
of the maximum prime number. For example, new PrimeIterator(23302)
creates an iterator that iterates prime numbers less than or equal to 23302. Write
a test program that uses this iterator to display all prime numbers less than or
equal to 120000.*/
package c24_ImpleListStackQueue;

public class E2414 {
    public static void main(String[] args) {
        PrimeIterator iterator = new PrimeIterator(23302);
        int count = 0;
        while (iterator.hasNext())
            System.out.print(iterator.next() + (++count % 10 == 0 ? "\n" : " " ));
    }
}

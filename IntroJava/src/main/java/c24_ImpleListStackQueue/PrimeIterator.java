/*(Prime number iterator) Define an iterator class named PrimeIterator for
iterating prime numbers. The constructor takes an argument that specifies the limit
of the maximum prime number. For example, new PrimeIterator(23302)
creates an iterator that iterates prime numbers less than or equal to 23302. Write
a test program that uses this iterator to display all prime numbers less than or
equal to 120000.*/
package c24_ImpleListStackQueue;

import java.util.Iterator;

public class PrimeIterator implements Iterator<Integer> {
    private final int limit;
    private int number = 2;
    private int root = 0;

    public PrimeIterator(int limit) {
        this.limit = limit;
    }

    @Override
    public boolean hasNext() {
        return number <= limit;
    }

    @Override
    public Integer next() {
        if (hasNext()) {
            int temp = number;
            number++;
            boolean isPrime = false;
            while (!isPrime) {
                isPrime = true;
                //root = (int)Math.sqrt(number);
                //reduce the number of sqrt computations, O(n * sqrt(n))
                if (root * root < number)
                    root++;
                for (int i = 2; i <= root; i++) {
                    if (number % i == 0) {
                        isPrime = false;
                        number++;
                        break;
                    }
                }
            }
            return temp;
        }
        return null;
    }
}

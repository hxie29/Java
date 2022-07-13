/*(Use the GenericStack class) Write a program that displays the first 100 prime
numbers in descending order. Use a stack to store the prime numbers.*/
package c24_ImpleListStackQueue;

public class E2404 {
    private static final GenericStack<Integer> primeStack = new GenericStack<>();

    public static void main(String[] args) {
        findPrime(100);
        int count = 0;
        while (!primeStack.isEmpty())
            System.out.print(primeStack.pop() + ((++count % 10 == 0) ? "\n" : " "));
    }

    private static void findPrime(int countOfPrimes) {
        int count = 0;
        int root = 0;
        int number = 2;

        while (count < 100) {
            boolean isPrime = true;
            //root = (int)Math.sqrt(number);
            //reduce the number of sqrt computations, O(n * sqrt(n))
            if (root * root < number)
                root++;
            for (int i = 2; i <= root; i++) {
                if (number % i == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                count++;
                primeStack.push(number);
            }
            number++;
        }
    }
}

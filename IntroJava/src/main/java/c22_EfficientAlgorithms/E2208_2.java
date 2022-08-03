/*(All prime numbers up to 10,000,000,000) Write a program that finds
all prime numbers up to 10,000,000,000. There are approximately
455,052,511 such prime numbers. Your program should meet the following
requirements:
■■ Your program should store the prime numbers in a binary data file, named
PrimeNumbers.dat. When a new prime number is found, the number is
appended to the file.
■■ To find whether a new number is prime, your program should load the prime
numbers from the file to an array of the long type of size 10000. If no
number in the array is a divisor for the new number, continue to read the
next 10000 prime numbers from the data file, until a divisor is found or all
numbers in the file are read. If no divisor is found, the new number is prime.
■■ Since this program takes a long time to finish, you should run it as a batch
job from a UNIX machine. If the machine is shut down and rebooted, your
program should resume by using the prime numbers stored in the binary data
file rather than start over from scratch.*/

package c22_EfficientAlgorithms;

import java.io.IOException;
import java.io.RandomAccessFile;

public class E2208_2 {
    final static int ARRAY_SIZE = 100000;

    public static void main(String[] args) throws IOException {
        // A list to hold prime numbers
        final long N = 100000002; // Find primes up to N
        long[] primeNumbers = new long[ARRAY_SIZE];

        long number; // A number to be tested for primeness
        RandomAccessFile inout = new RandomAccessFile("PrimeNumbers.dat", "rw");
        if (inout.length() == 0) {
            number = 1;
        }
        else {
            inout.seek(inout.length() - 8); // A long is 8 bytes
            number = inout.readLong(); // Get the last prime number in the file
        }

        long squareRoot = 1;

        // Repeatedly find prime numbers
        newNumber:while (number <= N) {
            // Check if 2, 3, 4, ..., N is prime
            number++;

            inout.seek(0);

            if (squareRoot * squareRoot < number) {
                squareRoot++;
            }

            while (inout.getFilePointer() < inout.length()) {
                int size = readNextBatch(primeNumbers, inout);

                // Exercise03_21 if number is prime
                for (int k = 0; k < size && primeNumbers[k] <= squareRoot; k++) {
                    if (number % primeNumbers[k] == 0) { // If true, not prime
                        continue newNumber; // Exit the for loop
                    }
                }
            }

            // Append a new prime number to the end of the file
            inout.seek(inout.length());
            inout.writeLong(number);
        }

        inout.close();
    }

    public static int readNextBatch(long[] primeNumbers, RandomAccessFile inout) {
        int size = 0;
        try {
            while (inout.getFilePointer() < inout.length() && size < ARRAY_SIZE) {
                primeNumbers[size++] = inout.readLong();
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

        return size;
    }
}

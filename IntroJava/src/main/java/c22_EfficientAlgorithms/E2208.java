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

import java.io.*;

public class E2208 {

    public static void main(String[] args){
        long count = 1;
        long limit = 10000;
        long prime;

        try (RandomAccessFile file = new RandomAccessFile("PrimeNumbers.dat", "rw")){
            file.writeLong(2);
            file.seek(0);
            for (long i = 3; i < limit; i++) {
                file.seek(0);
                boolean isPrime = true;
                while ((prime = file.readLong()) !=-1) {
                    if (i % prime == 0) {
                        isPrime = false;
                        break;
                    }
                }

                if (isPrime) {
                    file.writeLong(2);
                    count++;
                }
            }
        }

        catch (IOException ex) {
            ex.printStackTrace();
        }

        System.out.println("In total " + count + " prime numbers under " + limit);

    }
}

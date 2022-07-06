/*(Synchronize threads) Write a program that launches 1,000 threads. Each thread
adds 1 to a variable sum that initially is 0. You need to pass sum by reference to
each thread. In order to pass it by reference, define an Integer wrapper object to
hold sum. Run the program with and without synchronization to see its effect.*/
package c32_Muiltithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class E3204 {
    private static Integer sum = 0;
    private static final Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(1000);
        for (int i = 0; i < 1000; i++) {
            executor.execute(new AddOne());
        }
        executor.shutdown();
        while (!executor.isTerminated()) {}

        System.out.println("Sum is " + sum);
    }

    private static class AddOne implements Runnable {

        @Override
        public void run() {
            lock.lock();
            sum += 1;
            lock.unlock();
        }
    }
}

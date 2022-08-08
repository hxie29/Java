package c32_Muiltithreading;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class demo_ReentrantLock {

    public static void main(String[] args) {
        Processor processor = new Processor();

        Thread t1 = new Thread(() -> {
            try {
                processor.firstThread();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                processor.secondThread();
            }
            catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        processor.isFinished();
    }
    static class Processor {
        private int count = 0;
        private final Lock lock = new ReentrantLock();
        private final Condition condition = lock.newCondition();

        void increment() {
            for (int i = 0; i < 1000; i++)
                count++;
        }
        void firstThread() throws InterruptedException {

            lock.lock();
            System.out.println("Thread 1 started...");
            condition.await(); // similar to wait in object

            // always use try & finally to make sure the lock is unlocked
            //so even the code in try blocks throw exceptions, the thread will release the lock to let others continue their work
            try {
                   increment();
            }
            finally {
                lock.unlock();
            }
        }

        void secondThread() throws InterruptedException {
            Thread.sleep(1000);
            lock.lock();

            System.out.println("Press enter key!");
            new Scanner(System.in).nextLine();
            System.out.println("Got the enter key!");
            condition.signal(); // similar to notify method in object

            try {
                increment();
            }
            finally {
                lock.unlock();
            }
        }

        void isFinished() {
            System.out.println("Count is " + count);
        }
    }
}

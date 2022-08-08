package c32_Muiltithreading;

import java.util.LinkedList;
import java.util.Scanner;

public class demo_WaitNotify {

    public static void main(String[] args) {
        Processor processor = new Processor();

        Thread t1 = new Thread(() -> {
            try {
                processor.producer();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                processor.consumer();
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

    }
    static class Processor {
        private final LinkedList<Integer> list = new LinkedList<>();

        private final int LIMIT = 10;
        private final Object lock = new Object();
        void producer() throws InterruptedException {
            int value = 0;
            while (true) {
                synchronized (lock) {
                    // it acquires the key of the object
                    System.out.println("Processor running...");
                    // using a while loop to wrap wait make sure that the condition is checked again
                    // after the thread has been awakened
                    while (list.size() == LIMIT) {
                        // it releases the key temporarily and waits for the key to be free again
                        // wait() can only be called within synchronized block code
                        // make sure to call wait on the object whose lock is being used (this)
                        lock.wait();
                    }
                    list.add(value++);
                    //make sure to call notify on the object whose lock is used
                    lock.notify();
                }
            }
        }

        void consumer() throws InterruptedException {
            while (true) {
                synchronized (lock) {
                    //it acquires the key
                    //wait unless the list is not empty
                    while (list.size() == 0) {
                        lock.wait();
                    }
                    System.out.print("List size is " + list.size());
                    int value = list.removeFirst();
                    System.out.println("; Take value: " + value + value);
                    // notify other threads that are waiting
                    lock.notify();
                }

            }
        }

    }
}

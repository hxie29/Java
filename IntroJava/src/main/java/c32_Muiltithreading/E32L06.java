//Thread cooperation with condition objects
package c32_Muiltithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class E32L06 {
    private static final Account account = new Account();

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 100; i++) {
            executor.execute(new AddAPennyTask());
        }

        executor.shutdown();

        while (!executor.isTerminated()) {}

        System.out.println("Balance is " + account.getBalance());
    }

    private static class AddAPennyTask implements Runnable {
        @Override
        public void run() {
            account.deposit(1);
        }
    }
    private static class Account {
        private int balance;
        private static final Lock lock = new ReentrantLock();

        public int getBalance() {
            return balance;
        }

        /*It is a good practice to always immediately follow a call to lock() with a try-catch
        block and release the lock in the finally clause, as shown in lines 41–56, to ensure
        that the lock is always released. */
        public void deposit(int amount) {
            lock.lock();

            try {
                int newBalance = balance + amount;
                Thread.sleep(5);
                balance = newBalance;
            } catch (InterruptedException ignored) {
            }

            finally {
                lock.unlock();
            }
        }
    }
}



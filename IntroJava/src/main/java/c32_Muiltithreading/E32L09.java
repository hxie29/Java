package c32_Muiltithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class E32L09 {
    private static final Account account = new Account();

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

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
        private static final Semaphore semaphore = new Semaphore(1);

        public int getBalance() {
            return balance;
        }

        public synchronized void deposit(int amount) {
            try {
                semaphore.acquire();
                int newBalance = balance + amount;
                Thread.sleep(5);
                balance = newBalance;
            } catch (InterruptedException ignored) {
            }
            //always put release in a finally clause
            finally {
                semaphore.release();
            }
        }
    }
}




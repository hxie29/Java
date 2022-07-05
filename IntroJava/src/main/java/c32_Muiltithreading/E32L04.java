//Account without synchronization
// Keywords synchronized is added in deposit method in Account
package c32_Muiltithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class E32L04 {
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

        public int getBalance() {
            return balance;
        }

        public synchronized void deposit(int amount) {
            int newBalance = balance + amount;

            try {
                Thread.sleep(5);
            } catch (InterruptedException ignored) {
            }
            balance = newBalance;
        }
    }
}



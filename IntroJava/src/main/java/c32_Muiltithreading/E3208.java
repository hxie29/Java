/*(Account synchronization) Rewrite Listing 32.6, ThreadCooperation.java, using the
object’s wait() and notifyAll() methods.*/
package c32_Muiltithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class E3208 {
    private static final Account account = new Account();

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        executor.execute(new AddAPennyTask());
        executor.execute(new WithdrawAPennyTask());

        executor.shutdown();

        while (!executor.isTerminated()) {}

        System.out.println("Balance is " + account.getBalance());
    }

    private static class AddAPennyTask implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i ++)
                account.deposit(1);
        }
    }

    private static class WithdrawAPennyTask implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i ++)
                account.withdraw(1);
        }
    }
    private static class Account {
        private int balance;

        public int getBalance() {
            return balance;
        }

        /*It is a good practice to always immediately follow a call to lock() with a try-catch
        block and release the lock in the finally clause, as shown in lines 41–56, to ensure
        that the lock is always released. */
        public synchronized void deposit(int amount) {
            balance += amount;
            System.out.println("Deposit " + amount + "\t\t\t\t" + getBalance());
            notifyAll();
        }

        public synchronized void withdraw(int amount) {
            try {
                while (balance < amount) wait();
            }
            catch (InterruptedException ex) {
                ex.printStackTrace();
            }

            balance -= amount;
            System.out.println("Deposit " + amount + "\t\t\t\t" + getBalance());
        }
    }
}



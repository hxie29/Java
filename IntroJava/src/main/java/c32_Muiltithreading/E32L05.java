//Account with synchronizing locks
package c32_Muiltithreading;

import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class E32L05 {
    private static final Account account = new Account();

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        executor.execute(new DepositTask());
        executor.execute(new WithdrawTask());
        executor.shutdown();

        System.out.println("Thread 1 \t\tThread 2\t\tBalance");
    }

    private static class DepositTask implements Runnable {
        @Override
        public void run() {
            try {
                while(true) {
                    account.deposit((int)(Math.random() * 10) + 1);
                    Thread.sleep(1000);
                }
            }
            catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    private static class WithdrawTask implements Runnable {
        @Override
        public void run() {
            try {
               while (true) {
                   account.withdraw((int)(Math.random() * 10) + 1);
                   Thread.sleep(1000);
               }
            }
            catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
    private static class Account {
        private int balance;
        private static final Lock lock = new ReentrantLock();
        private static final Condition allowWithdraw = lock.newCondition();

        public int getBalance() {
            return balance;
        }

        /*It is a good practice to always immediately follow a call to lock() with a try-catch
        block and release the lock in the finally clause, as shown in lines 41–56, to ensure
        that the lock is always released. */
        void deposit(int amount) {
            lock.lock();

            try {
                balance += amount;
                System.out.println("Deposit " + amount + "\t\t\t\t\t" + getBalance());
                allowWithdraw.signalAll();
            }
            finally {
                lock.unlock();
            }
        }

        void withdraw(int amount) {
            lock.lock();

            try {
                while(balance < amount) {
                    System.out.println("\t\tWait for deposit");
                    allowWithdraw.await();
                }
                balance -= amount;
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

            finally {
                lock.unlock();
            }
        }
    }
}



package c32_Muiltithreading;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class demo_ReentrantLock2 {

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
        private final Account account1 = new Account();
        private final Account account2 = new Account();

        private final Lock lock1 = new ReentrantLock();
        private final Lock lock2 = new ReentrantLock();

        // create a separate method that always makes sure all relevant locks are locked/unlocked
        void acquireLock(Lock lock1, Lock lock2) {
            while (true) {
                boolean gotLock1 = false;
                boolean gotLock2 = false;
                try {
                    gotLock1 = lock1.tryLock();
                    gotLock2 = lock2.tryLock();
                }
                finally {
                    if (gotLock1 && gotLock2) return;
                    if (gotLock1) lock1.unlock();
                    if (gotLock2) lock2.unlock();
                }
            }
        }
        void firstThread() throws InterruptedException {
            Random random = new Random();

            for (int i = 0; i < 1000; i++) {
                acquireLock(lock1, lock2);
                try {
                    Account.transfer(account1, account2, random.nextInt(100));
                }
                finally {
                    lock1.unlock();
                    lock2.unlock();
                }
            }
        }

        void secondThread() throws InterruptedException {
            Random random = new Random();

            for (int i = 0; i < 1000; i++) {
                acquireLock(lock1, lock2);
                try {
                    Account.transfer(account2, account1, random.nextInt(100));
                }
                finally {
                    lock1.unlock();
                    lock2.unlock();
                }
            }
        }

        void isFinished() {
            System.out.println("Account 1 balance: " + account1.getBalance());
            System.out.println("Account 2 balance: " + account2.getBalance());
            System.out.println("Total balance: " + (account1.getBalance() + account2.getBalance()));
        }
    }

    static class Account{
        private int balance = 10000;

        public int getBalance(){return balance;}

        public void deposit(int amount) {
            balance +=amount;
        }

        public void withdraw(int amount) {balance -= amount;}

        public static void transfer (Account account1, Account account2, int amount) {
            account1.withdraw(amount);
            account2.deposit(amount);
        }
    }
}

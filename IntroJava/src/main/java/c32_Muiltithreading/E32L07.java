//Consumer Producer demonstrating thread coordination
package c32_Muiltithreading;

import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class E32L07 {
    private static final Buffer buffer = new Buffer();

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(new ProducerTask());
        executor.execute(new ConsumerTask());
        executor.shutdown();
    }

    private static class ProducerTask implements Runnable {
        @Override
        public void run() {
            try {
                int i = 1;
                while (true) {
                    System.out.println("Producer writes " + i);
                    buffer.write(i++);
                    Thread.sleep((int)(Math.random() * 10000));
                }
            }
            catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    private static class ConsumerTask implements Runnable {
        @Override
        public void run() {
            try {
                while (true) {
                    System.out.println("Consumer reads " + buffer.read());
                    Thread.sleep((int)(Math.random() * 10000));
                }
            }
            catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    private static class Buffer{
        private static final int CAPACITY = 1;
        private final LinkedList<Integer> queue = new LinkedList<>();

        //Create a lock
        private static final Lock lock = new ReentrantLock();
        //Create two conditions
        private static final Condition notEmpty = lock.newCondition();
        private static final Condition notFull = lock.newCondition();

        public void write(int value) {
            lock.lock();
            try{
                while(queue.size() == CAPACITY) {
                    System.out.println("Wait for notFull condition");
                    notFull.await();
                }
                queue.offer(value);
                notEmpty.signal();
            }
            catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            finally {
                lock.unlock();
            }
        }

        public int read() {
            int value = 0;
            lock.lock();
            try{
                while (queue.isEmpty()) {
                    System.out.println("Wait for notEmpty condition");
                    notEmpty.await();
                }
                value = queue.remove();
                notFull.signal();
            }
            catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            finally {
                lock.unlock();
            }
            return value;
        }
    }
}

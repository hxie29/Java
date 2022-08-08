package c32_Muiltithreading;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class demo_BlockingQueue {
    // the queue's capacity is 10
    private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            try {
                producer();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                consumer();
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

    private static void producer() throws InterruptedException {
        Random random = new Random();

        while (true) {
            // this call will wait till queue has empty slots to execute the put
            queue.put(random.nextInt());
        }
    }

    private static void consumer() throws InterruptedException {
        Random random = new Random();

        while (true) {
            Thread.sleep(100);

            if (random.nextInt(10) == 0) {
                // this call will wait till queue is non empty to execute the take
                int value = queue.take();
                System.out.println("Taken value: " + value + ", queue size: " + queue.size());
            }
        }
    }
}

package c32_Muiltithreading;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class demo_CountDown {
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(5);
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 5; i++) {
            executorService.submit(new Work(latch, i));
        }

        try {
            latch.await();
        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        executorService.shutdown();

        try {
            executorService.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("All completed.");
    }

    static class Work implements Runnable {
        private final CountDownLatch latch;
        private final int id;

        public Work(CountDownLatch latch, int id) {
            this.latch = latch;
            this.id = id;
        }

        public void run() {
            System.out.println("Started: " + id);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Completed: " + id);
            latch.countDown();
        }
    }
}

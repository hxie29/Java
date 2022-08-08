package c32_Muiltithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class demo_ThreadPools {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 10; i++) {
            executorService.submit(new Worker(i));
        }
        executorService.shutdown();
        System.out.println("All tasks submitted");

        try {
            executorService.awaitTermination(1, TimeUnit.DAYS);
        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("All tasks completed");
    }

    static class Worker implements Runnable{
        private int id;

        public Worker(int id) {this.id = id;}

        public void run() {
            System.out.println("Work " + id + " start");
            try {
                Thread.sleep(5000);
            }
            catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Work " + id + " completed");
        }
    }
}

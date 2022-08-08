package c32_Muiltithreading;

import java.util.Random;
import java.util.concurrent.*;

public class demo_InterruptingThreads {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        Thread thread = new Thread(() -> {
            Random random = new Random();
            for (int i = 0; i < 1E8; i++) {
                try {
                    Thread.sleep(1);
                }
                catch (InterruptedException ex) {
                    System.out.println("Interrupted 1!");
                }
                Math.sin(random.nextInt(100));
            }
        });
        thread.start();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        thread.interrupt();

        // lambda here is: new Callable<Void>()
        Future<?> future = executorService.submit((Callable<Void>) () -> {
            Random random = new Random();
            for (int i = 0; i < 1E8; i++) {
                try {
                    Thread.sleep(1);
                }
                catch (InterruptedException ex) {
                    System.out.println("Interrupted 2!");
                }
                Math.sin(random.nextInt(100));
            }
            return null;
        }) ;
        executorService.shutdown();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        future.cancel(true); // true = if already running, interrupt it

        try {
            executorService.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Finished");
    }
}

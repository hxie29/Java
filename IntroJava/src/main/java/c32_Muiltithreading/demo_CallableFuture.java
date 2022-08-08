package c32_Muiltithreading;

import java.util.Random;
import java.util.concurrent.*;

public class demo_CallableFuture {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        // here the lambda is new Callable<Integer>();
        // if no return required but we want to have a future object to do interruption
        // do :
        /*

        Future<?> futureVoid = executorService.submit(new Callable<Void>() {
            @Override
            public Void call() throws Exception {
                return null;
            }
        }) ;

        */
        Future<Integer> future = executorService.submit(() -> {
            Random random = new Random();
            int duration = random.nextInt(4000);

            if (duration > 2000)
                throw new IllegalStateException("Sleep for too long.");

            System.out.println("Starting...");
            try {
                Thread.sleep(duration);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Finished.");
            return duration;
        });

        executorService.shutdown();

        try {
            // the future.get() will be blocked and wait if the thread that needs to be finished to get result is not finished
            System.out.println("Return value: " + future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            // here will print: java.lang.IllegalStateException: Sleep for too long.
            System.out.println(e.getMessage());
        }
    }
}

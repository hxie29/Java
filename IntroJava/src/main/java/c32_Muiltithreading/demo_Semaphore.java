package c32_Muiltithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class demo_Semaphore {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 200; i++) {
            executorService.submit(() -> {
                Connection.getInstance().connect();
            });
        }
        executorService.shutdown();
        try {
            executorService.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    // Singleton class
    static class Connection {
        // by limiting the numbers of permits, the most connections could have is 10;
        private final Semaphore semaphore = new Semaphore(10);
        private static final Connection connection = new Connection();
        private int connections = 0;
        private Connection() {
        }
        public static Connection getInstance() {return connection;}

        public void connect() {
            try {
                //acquire a permit to work
                semaphore.acquire();
            }catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            try {
                synchronized (this) {
                    connections++;
                    System.out.println("Current connections: " + connections);
                }
                Thread.sleep(1000);
                // before permit is released, decrement the connections
                synchronized (this){
                    connections--;
                }
            }
            catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            finally {
                semaphore.release();
            }
        }
    }
}

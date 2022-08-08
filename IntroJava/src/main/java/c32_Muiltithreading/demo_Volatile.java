package c32_Muiltithreading;

import java.util.Scanner;

public class demo_Volatile {
    public static void main(String[] args) {
        Runner runner  = new Runner();
        runner.start();

        System.out.println("Press enter to stop ...");

        Scanner input = new Scanner(System.in);
        input.nextLine();
        runner.shutDown();
    }
    static class Runner extends Thread {
        //by adding volatile the variable will be updated in all threads that reads this variable
        private volatile boolean running = true;
        @Override
        public void run() {
            while (running) {
                System.out.println("Hello!");
                try {
                    Thread.sleep(100);
                }
                catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        public void shutDown() {
            running = false;
        }
    }
}

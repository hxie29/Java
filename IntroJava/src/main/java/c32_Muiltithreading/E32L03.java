//Executor demo
package c32_Muiltithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class E32L03 {
    public static void main(String[] args) {
//        Create a fixed thread pool with maximum three threads
        ExecutorService executor = Executors.newFixedThreadPool(3);

//        Submit runnable tasks to the executor
        executor.execute(new PrintChar('a',1000));
        executor.execute(new PrintChar('b',1000));
        executor.execute(new PrintNum(100));
// shut down remember!
        executor.shutdown();
    }
}

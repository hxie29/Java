// Task and Thread demo
package c32_Muiltithreading;

public class E32L01 {
    public static void main(String[] args) {
//         Create tasks
        Runnable printA = new PrintChar('a', 1000);
        Runnable printB = new PrintChar('b', 1000);
        Runnable print100 = new PrintNum(100);
//        Create threads
        Thread t1 = new Thread(printA);
        Thread t2 = new Thread(printB);
        Thread t3 = new Thread(print100);
//        Start threads
        // if run() method is called instead, the tasks will be executed sequentially
        t1.start();
        t2.start();
        t3.start();
    }
}


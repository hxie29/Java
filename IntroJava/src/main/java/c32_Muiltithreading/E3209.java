/*(Demonstrate ConcurrentModificationException) The iterator is fail-fast.
Write a program to demonstrate it by creating two threads that concurrently access
and modify a set. The first thread creates a hash set filled with numbers and adds
a new number to the set every second. The second thread obtains an iterator for
the set and traverses the set back and forth through the iterator every second. You
will receive a ConcurrentModificationException because the underlying
set is being modified in the first thread while the set in the second thread is being
traversed.*/
package c32_Muiltithreading;

import java.util.HashSet;
import java.util.Iterator;

public class E3209 {
    private static HashSet<Integer> set;

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            set = new HashSet<>();
            for (int i = 0; i < 1000; i++)
                set.add(i);
            for (int i = 1005; i <1035; i++){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                set.add(i);
                System.out.println("Thread 1 adds: " + i);
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Iterator<Integer> iterator = set.iterator();
            for (int i = 0; i < 30; i++) {
                while (iterator.hasNext()) {
                    System.out.println("Thread 2 reads: " + iterator.next());
                }
            }
        });

        t1.start();
        t2.start();
    }
}

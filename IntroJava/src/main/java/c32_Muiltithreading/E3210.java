/*(Use synchronized sets) Using synchronization, correct the problem
in the preceding exercise so that the second thread does not throw a
Concurrent ModificationException.

(Demonstrate ConcurrentModificationException) The iterator is fail-fast.
Write a program to demonstrate it by creating two threads that concurrently access
and modify a set. The first thread creates a hash set filled with numbers and adds
a new number to the set every second. The second thread obtains an iterator for
the set and traverses the set back and forth through the iterator every second. You
will receive a ConcurrentModificationException because the underlying
set is being modified in the first thread while the set in the second thread is being
traversed.*/
package c32_Muiltithreading;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class E3210 {
    private static final Set<Integer> set = Collections.synchronizedSet(new HashSet<>());

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++)
                set.add(i);
            for (int i = 1005; i <1035; i++){
                try {
                    Thread.sleep(500);
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
                synchronized (set){
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    if (iterator.hasNext())
                        System.out.println("Thread 2 reads: " + iterator.next());
                }
            }
        });

        t1.start();
        t2.start();
    }
}

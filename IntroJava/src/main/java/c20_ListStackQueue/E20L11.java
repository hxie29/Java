//Priority queue demo
package c20_ListStackQueue;

import java.util.Collections;
import java.util.PriorityQueue;

public class E20L11 {
    public static void main(String[] args) {
        PriorityQueue<String> q1 = new PriorityQueue<>();
        q1.offer("Indiana");
        q1.offer("Texas");
        q1.offer("New York");
        q1.offer("Georgia");

        System.out.println("Priority queue using Comparable: ");
        while (q1.size() > 0)
            System.out.print(q1.remove() + " ");

        PriorityQueue<String> q2 = new PriorityQueue<>(4, Collections.reverseOrder());
        q2.offer("Indiana");
        q2.offer("Texas");
        q2.offer("New York");
        q2.offer("Georgia");

        System.out.println("\nPriority queue using Comparator in reverse order:");
        while (q2.size() > 0)
            System.out.print(q2.remove() + " ");
    }
}

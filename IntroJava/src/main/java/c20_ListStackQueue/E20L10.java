// Test Queue
package c20_ListStackQueue;

import java.util.LinkedList;
import java.util.Queue;

public class E20L10 {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        queue.offer("Indiana");
        queue.offer("Texas");
        queue.offer("New York");
        queue.offer("Georgia");

        while (queue.size() > 0) {
            System.out.print(queue.remove() + " ");
        }
    }
}

// Test Tree set
package c21_SetsMaps;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class E21L04 {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("London");
        set.add("Paris");
        set.add("New York");
        set.add("San Francisco");
        set.add("Beijing");
        set.add("New York");
        System.out.println(set);

        TreeSet<String> treeSet = new TreeSet<>(set);
        System.out.println(treeSet);

        System.out.println("first: " + treeSet.first());
        System.out.println("last: " + treeSet.last());
        System.out.println("headset New York: " + treeSet.headSet("New York"));
        System.out.println("tailset New York: " + treeSet.tailSet("New York"));
        System.out.println("pollFirst: " + treeSet.pollFirst());
        System.out.println("poll last: " + treeSet.pollLast());
        System.out.println("remaining set: " + treeSet);
    }
}

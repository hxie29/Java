/*Set List Performance test*/
package c21_SetsMaps;

import java.util.*;

public class E21L06 {
    static final int n = 50000;

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        Collections.shuffle(list);

        //Hashset
        Collection<Integer> set1 = new HashSet<>(list);
        System.out.println("Member test set for hash set is " + getTestTime(set1) + " milliseconds");
        System.out.println("Remove element for hash set is " + removeElement(set1) + " milliseconds");

        Collection<Integer> set2 = new LinkedHashSet<>(list);
        System.out.println("Member test set for LinkedHashSet is " + getTestTime(set2) + " milliseconds");
        System.out.println("Remove element for LinkedHashSet is " + removeElement(set2) + " milliseconds");

        Collection<Integer> set3 = new TreeSet<>(list);
        System.out.println("Member test set for TreeSet is " + getTestTime(set3) + " milliseconds");
        System.out.println("Remove element for TreeSet is " + removeElement(set3) + " milliseconds");

        Collection<Integer> list1 = new ArrayList<>(list);
        System.out.println("Member test set for arrayList is " + getTestTime(list1) + " milliseconds");
        System.out.println("Remove element for arrayList is " + removeElement(list1) + " milliseconds");

        Collection<Integer> list2 = new LinkedList<>(list);
        System.out.println("Member test set for LinkedList is " + getTestTime(list2) + " milliseconds");
        System.out.println("Remove element for LinkedList is " + removeElement(list2) + " milliseconds");

    }

    private static long getTestTime(Collection<Integer> c) {
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < n; i++) {
            c.contains((int)(Math.random() * 2 * n));
        }
        return System.currentTimeMillis() - startTime;
    }

    private static long removeElement(Collection<Integer> c) {
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < n; i++) {
            c.remove(i);
        }

        return System.currentTimeMillis() - startTime;
    }
}

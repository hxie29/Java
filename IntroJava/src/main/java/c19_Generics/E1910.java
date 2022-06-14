/*(Smallest element in ArrayList) Write the following method that returns the smallest element in an ArrayList:
public static <E extends Comparable<E>> E min(ArrayList<E> list)*/
package c19_Generics;

import java.util.ArrayList;

public class E1910 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(100);
        list.add(22);
        list.add(13);
        list.add(40);
        list.add(5);

        System.out.println(min(list));
    }
    public static <E extends Comparable<E>> E min(ArrayList<E> list) {
        E min = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).compareTo(min) < 0) {
                min = list.get(i);
            }
        }
        return min;
    }
}

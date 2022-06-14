/*(Sort ArrayList) Write the following method that sorts an ArrayList:
public static <E extends Comparable<E>> void sort(ArrayList<E> list)*/
package c19_Generics;

import java.util.ArrayList;

public class E1909 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(100);
        list.add(22);
        list.add(13);
        list.add(40);
        list.add(5);

        sort(list);
        System.out.println(list.toString());
    }
    public static <E extends Comparable<E>> void sort(ArrayList<E> list) {
        E min;
        int index;
        for (int i = 0; i < list.size(); i++) {
            min = list.get(i);
            index = i;
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j).compareTo(min) < 0) {
                    min = list.get(j);
                    index = j;
                }
            }
            if (index != i) {
                list.set(index, list.get(i));
                list.set(i, min);
            }
        }
    }
}

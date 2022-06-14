/*(Shuffle ArrayList) Write the following method that shuffles an ArrayList:
public static <E> void shuffle(ArrayList<E> list)*/
package c19_Generics;

import java.util.ArrayList;

public class E1908 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        shuffle(list);
        System.out.println(list);
    }
    public static <E> void shuffle(ArrayList<E> list) {
        for (int i = 0; i < list.size(); i++) {
            int index = (int)(Math.random() * list.size());
            E temp = list.get(i);
            list.set(i, list.get(index));
            list.set(index, temp);
        }
    }
}

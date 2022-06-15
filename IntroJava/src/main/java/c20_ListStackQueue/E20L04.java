//Test Array list and linked list
package c20_ListStackQueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class E20L04 {
    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(1);
        arrayList.add(4);
        arrayList.add(0,10);
        arrayList.add(3,30);

        System.out.println(arrayList);

        LinkedList<Object> linkedList = new LinkedList<>(arrayList);
        linkedList.add(1, "red");
        linkedList.removeLast();
        linkedList.addFirst("green");

        System.out.println("Display the linked list forward:");
        linkedList.forEach(e -> System.out.print(e + " "));
        System.out.println();
        System.out.println("Display the linked list backward:");
        // put iterator at the end of the list
        ListIterator<Object> listIterator = linkedList.listIterator(linkedList.size());
        while (listIterator.hasPrevious())
            System.out.print(listIterator.previous() + " ");
    }
}

//Testing iterator class
package c20_ListStackQueue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class E20L02 {
    public static void main(String[] args) {
        Collection<String> c1 = new ArrayList<>();
        c1.add("New York");
        c1.add("Atlanta");
        c1.add("Dallas");
        c1.add("Madison");

        Iterator<String> it = c1.iterator();
        while(it.hasNext()) {
            System.out.println(it.next().toUpperCase() + " ");
        }
    }
}

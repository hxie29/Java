//Using for Each method
package c20_ListStackQueue;

import java.util.ArrayList;
import java.util.Collection;

public class E20L03 {
    public static void main(String[] args) {
        Collection<String> c1 = new ArrayList<>();
        c1.add("New York");
        c1.add("Atlanta");
        c1.add("Dallas");
        c1.add("Madison");

        c1.forEach(e -> System.out.println(e + " "));
    }
}

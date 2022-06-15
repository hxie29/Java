package c20_ListStackQueue;

import java.util.ArrayList;
import java.util.Collection;

public class E20L01 {
    public static void main(String[] args) {
        ArrayList<String> c1 = new ArrayList<>();
        c1.add("New York");
        c1.add("Atlanta");
        c1.add("Dallas");
        c1.add("Madison");

        System.out.println(c1);
        //[New York, Atlanta, Dallas, Madison]
        System.out.println("\nIs Dallas in collection? " + c1.contains("Dallas"));
        // true
        c1.remove("Dallas");
        System.out.println("\n collection size: " + c1.size());
        // 3

        Collection<String> c2 = new ArrayList<>();
        c2.add("Seattle");
        c2.add("Portland");
        c2.add("Los Angeles");
        c2.add("Atlanta");

        System.out.println(c2);
        //[Seattle, Portland, Los Angeles, Atlanta]
        ArrayList<String> c3 = (ArrayList<String>)(c1.clone());
        c3.addAll(c2);
        System.out.println(c3);
        //[New York, Atlanta, Madison, Seattle, Portland, Los Angeles, Atlanta]

        c3 = (ArrayList<String>)(c1.clone());
        c3.retainAll(c2);
        System.out.println(c3);
        //[Atlanta]

        c3 = (ArrayList<String>)(c1.clone());
        c3.removeAll(c2);
        System.out.println(c3);
        //[New York, Madison]
    }
}

package c11_InheritancePolymorphism;

import java.util.ArrayList;

//Test arrayList
public class E11L08 {
    public static void main(String[] args) {
        ArrayList<String> cities = new ArrayList<>();
        cities.add("London");
        cities.add("Denver");
        cities.add("Paris");
        cities.add("Miami");
        cities.add("Seoul");
        cities.add("Tokyo");

        System.out.println("Size: " + cities.size());
        System.out.println("London? " + cities.contains("London"));
        System.out.println("Location of Paris? " + cities.indexOf("Paris"));
        System.out.println("Empty? " + cities.isEmpty() );

        cities.add(2, "Beijing");
        cities.remove("London");
        System.out.println(cities);
        System.out.println(cities.get(3));

    }
}

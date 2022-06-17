// Test methods in collection
package c21_SetsMaps;

import java.util.HashSet;
import java.util.Set;

public class E21L02 {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("London");
        set.add("Paris");
        set.add("New York");
        set.add("San Francisco");
        set.add("Beijing");
        set.add("New York");
        System.out.println(set);
        System.out.println("Size: " + set.size());
        System.out.println("Contains \"Taipei\" ? " + set.contains("Taipei"));
        set.remove("London");
        set.forEach(s -> System.out.print(s.toUpperCase() + " "));
    }
}

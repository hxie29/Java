// Test hashset
package c21_SetsMaps;
import java.util.*;
public class E21L01 {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("London");
        set.add("Paris");
        set.add("New York");
        set.add("San Francisco");
        set.add("Beijing");
        set.add("New York");
        System.out.println(set);
        set.forEach(s -> System.out.print(s.toUpperCase() + " "));
    }
}

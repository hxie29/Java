//Stream demo
package c30_CollectionStreams;

import java.util.Arrays;
import java.util.stream.Stream;

public class E30L01 {
    public static void main(String[] args) {
        String[] names = {"John", "Peter", "Susan", "Kim", "Jen","George", "Alan", "Stacy", "Michelle", "john"};

        //Display the first four names sorted
        Stream.of(names).limit(4).sorted().forEach(e -> System.out.println(e + " "));

        // Skip four names and display the rest sorted ignore cases
        System.out.println();
        Stream.of(names).skip(4).sorted(String::compareToIgnoreCase).forEach(e -> System.out.print(e + " "));

        System.out.println("\nLargest string with length > 4: " + Stream.of(names).filter(e -> e.length() > 4).max(String::compareTo).get());
        System.out.println("\nSmallest string alphabetically: " + Stream.of(names).min(String::compareTo).get());
        System.out.println("\nStacy is in names? " + Stream.of(names).anyMatch(e -> e.equals("Stacy")));
        System.out.println("\nAll names start with a capital letter? " + Stream.of(names).allMatch(e -> Character.isUpperCase(e.charAt(0))));
        System.out.println("\nNo names begin with Ko? " + Stream.of(names).noneMatch(e -> e.startsWith("Ko")));
        System.out.println("\nNumber of distinct case-insensitive strings: " + Stream.of(names).map(String::toUpperCase).distinct().count());
        System.out.println("\nNumber of distinct case-insensitive strings: " + Stream.of(names).map(String::toUpperCase).distinct().count());
        System.out.println("\nFirst element in this stream in lowercase" + Stream.of(names).map(String::toLowerCase).findFirst().get());
        System.out.println("\nSkip 4 and get any element in this stream:" + Stream.of(names).skip(4).findAny().get());
        Object[] namesInLowerCase = Stream.of(names).map(String:: toLowerCase).toArray();
        System.out.println(Arrays.toString(namesInLowerCase));
        System.out.println("String print this string: " );
        System.out.println("Link see below: String print his string  ");

    }
}

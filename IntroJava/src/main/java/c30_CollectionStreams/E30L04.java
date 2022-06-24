// Stream reduction method demo
package c30_CollectionStreams;

import java.util.stream.IntStream;

public class E30L04 {
    public static void main(String[] args) {
        int[] values = {3, 4, 1, 5, 20, 1, 3, 3, 4, 6};

        System.out.println("The values are: ");
        IntStream.of(values).forEach(e -> System.out.print(e + " "));

        System.out.println("\nThe result of multiplying all values is " +
                IntStream.of(values).parallel().reduce(1,(e1, e2) -> e1 * e2));

        // map to Object returns a stream of string objects
        System.out.println("The values are " + IntStream.of(values).mapToObj(e -> e + "").reduce((e1,e2) -> e1 + "," + e2).get());

    }
}

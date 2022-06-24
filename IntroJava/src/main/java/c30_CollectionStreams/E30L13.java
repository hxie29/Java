/*Listing 21.9 gives a program that counts the occurrences of words in a text. You can rewrite
the code using streams as shown in Listing 30.13.*/
package c30_CollectionStreams;

import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class E30L13 {
    public static void main(String[] args) {
        String text = "Good morning, have a good class." + " Have a good visit. Have fun!";

        Stream.of(text.split("[\\s+\\p{P}]")).parallel().filter(e ->
                e.length() > 0).collect(Collectors.groupingBy(String::toLowerCase, TreeMap::new, Collectors.counting())).forEach((k,v) ->
                System.out.println(k + " " + v));

    }
}

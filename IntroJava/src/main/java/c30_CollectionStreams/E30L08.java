/*Listing 7.4, CountLettersInArrays.java gives a program that randomly generates 100 lowercase
letters and counts the occurrences of each letter.
The program can be simplified using a Stream as shown in Listing 30.8.*/
package c30_CollectionStreams;

import java.util.Random;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class E30L08 {
    private static int count;

    public static void main(String[] args) {
        Random random = new Random();

        Object[] chars = random.ints(100,'a', 'z' + 1).mapToObj(e -> (char)e).toArray();

        System.out.println("The lowercase letters are:");
        Stream.of(chars).forEach(e -> System.out.print(e + ((++count % 20 == 0)? "\n" : " ")));

        count = 0;
        System.out.println("\nThe occurrences of each letter are:");
        Stream.of(chars).collect(Collectors.groupingBy(e -> e, TreeMap::new, Collectors.counting())).forEach((k,v) ->
                System.out.print( v + " " + k + (++count %20 == 0 ? "\n" : " ")));
    }
}

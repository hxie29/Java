//Rewrite E0707 using streams
/*(Count single digits) Write a program that generates 200 random integers between
0 and 9 and displays the count for each number. (Hint: Use an array of ten integers,
say counts, to store the counts for the number of 0s, 1s, . . . , 9s.)*/

package c30_CollectionStreams;

import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class E3005 {
    public static void main(String[] args) {
        Integer[] list = new Integer[200];
        for (int i = 0; i < list.length; i++) {
            list[i]= (int)(Math.random() * 10);
        }
        Stream.of(list).collect(Collectors.groupingBy(e -> e, TreeMap:: new, Collectors.counting())).forEach((k,v) ->
                System.out.println(k + " appears " + v + " times."));
    }
}

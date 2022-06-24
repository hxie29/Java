//IntStream, LongStream, DoubleStream demo
package c30_CollectionStreams;

import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class E30L02 {
    public static void main(String[] args) {
        int[] values = {3, 4, 1, 5, 20, 1, 3, 3, 4, 6};

        System.out.println("The average of distinct even numbers > 3:" +
                IntStream.of(values).distinct().filter(e -> e > 3 && e % 2 == 0).average().getAsDouble());

        System.out.println("The sum of the first 4 numbers is" +
                IntStream.of(values).limit(4).sum());

        IntSummaryStatistics stats = IntStream.of(values).summaryStatistics();
        System.out.println("Count: " + stats.getCount());
        System.out.println("Average: " + stats.getAverage());
        System.out.println("Max: " + stats.getMax());
        System.out.println("Min: " + stats.getMin());

        String[] names = {"John", "Peter", "Susan", "Kim", "Jen","George", "Alan", "Stacy", "Michelle", "john"};
        System.out.println("Total character count for all names is " +
                Stream.of(names).mapToInt(String::length).sum());
        System.out.println("The number of digits in array values is " +
                Stream.of(values).map(e -> e + "").mapToInt(String:: length).sum());
    }
}

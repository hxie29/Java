/*You can create a stream from a one-dimensional array. Can you create a stream for processing
two-dimensional arrays? Listing 30.10 gives an example of processing two-dimensional
arrays using streams.*/
package c30_CollectionStreams;

import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class E30L10 {
    private static int count;
    public static void main(String[] args) {
        int[][] m = {{1, 2}, {3, 4}, {4, 5}, {1, 3}};

        int[] list = Stream.of(m).map(IntStream::of).reduce(IntStream::concat).get().toArray();

        IntSummaryStatistics stats = IntStream.of(list).summaryStatistics();
        System.out.println("Max is " + stats.getMax());
        System.out.println("Min is " + stats.getMin());
        System.out.println("Average is " + stats.getAverage());

        System.out.println("Sum of row: ");
        Stream.of(m).mapToInt(e -> IntStream.of(e).sum()).forEach(e -> System.out.println("Row " + ++count + ": " + e));
    }
}

//Rewrite E0704
/*(Analyze scores) Write a program that reads an unspecified number of scores and
determines how many scores are above or equal to the average, and how many
scores are below the average. Enter a negative number to signify the end of the
input. Assume the maximum number of scores is 100.*/
package c30_CollectionStreams;

import java.util.stream.IntStream;

public class E3003 {
    public static void main(String[] args) {
        int[] scores = {30,49,29,40,67,85,86,67,88,92,66,78};

        double average = IntStream.of(scores).average().getAsDouble();
        System.out.println("Average score is " + average);
        System.out.println("There are " + IntStream.of(scores).filter(e -> e >= average).count() + " scores are not less than average");
        System.out.println("There are " + IntStream.of(scores).filter(e -> e < average).count() + " scores are lower than average");
    }
}

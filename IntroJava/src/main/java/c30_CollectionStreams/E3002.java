//Rewrite E0703
/*(Count occurrence of numbers) Write a program that reads the integers between
1 and 50 and counts the occurrences of each. Assume the input ends with 0. Here
is a sample run of the program:
Enter the integers between 1 and 50: 2 5 6 5 4 3 23 43 2 0
2 occurs 2 times
3 occurs 1 time
4 occurs 1 time
5 occurs 2 times
6 occurs 1 time
23 occurs 1 time
43 occurs 1 time*/

package c30_CollectionStreams;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class E3002 {
    public static void main(String[] args) {
        int[] count = new int[50];
        System.out.println("Enter numbers between 1 and 50:");

        Scanner input = new Scanner(System.in);
        while (true) {
            int number = input.nextInt();
            if (number == 0) break;
            if (number > 0 && number <= 50) count[(number -1)]++;
        }
        input.close();

        IntStream.of(count).parallel().filter(e -> e > 0 && e <= 50).boxed().collect(Collectors.groupingBy(e ->
                e, TreeMap:: new, Collectors.counting())).forEach((k, v) ->
                System.out.println(k + " appears " + v + (v > 1 ? " times" : " time")));
    }
}

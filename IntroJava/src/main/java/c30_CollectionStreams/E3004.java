//Rewrite E0705 using streams. Display the numbers in increasing order.
/*(The number of even numbers and odd numbers) Write a program that reads ten
integers, and then display the number of even numbers and odd numbers. Assume
that the input ends with 0. Here is the sample run of the program.
Enter numbers: 1 2 3 2 1 6 3 4 5 2 3 6 8 9 9 0
The number of odd numbers: 8
The number of even numbers: 7
*/
package c30_CollectionStreams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class E3004 {
    public static void main(String[] args) {
        System.out.println("Enter the numbers:");
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        while (true) {
            int n = input.nextInt();
            if (n != 0) {
                list.add(n);
            }
            else
                break;
        }
        input.close();

        // map Integer arraylist to int[]
        int[] arr = list.stream().mapToInt(i -> i).toArray();
        int[] even = IntStream.of(arr).filter(e -> e % 2 == 0).sorted().toArray();
        int[] odd = IntStream.of(arr).filter(e -> e % 2 != 0).sorted().toArray();
        System.out.println("There are " + even.length + " even numbers. They are: " + Arrays.toString(even));
        System.out.println("There are " + odd.length + " odd numbers. They are: " + Arrays.toString(odd));

    }
}

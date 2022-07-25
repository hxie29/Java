/*(4 * 4 16 tails analysis) The nine tails problem in the text uses a 3 * 3 matrix.
Assume you have 16 coins placed in a 4 * 4 matrix. Write a program to find
out the number of the starting patterns that don’t have a solution.*/
package c28_Graphs;

import java.util.List;
import java.util.Scanner;

public class E2814 {
    public static void main(String[] args) {
        SixteenTailModel model = new SixteenTailModel();
        int count = 0;
        for (int i = 0; i < (int)Math.pow(2, 16); i++) {
            if (!model.hasSolution(i))
                count++;
        }
        System.out.println("Number of no solution patterns: " + count);
        System.out.println("Percentage of no solution patterns: " + count * 100/ Math.pow(2, 16) + "%" );
    }
}

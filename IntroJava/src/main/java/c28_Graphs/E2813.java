/*(4 * 4 16 tails problem) Listing 28.14, NineTail.java, presents a solution for
the nine tails problem. Revise this program for the 4 * 4 16 tails problem.
Note it is possible that a solution may not exist for a starting pattern. If so,
report that no solution exists.*/
package c28_Graphs;

import java.util.List;
import java.util.Scanner;

public class E2813 {
    public static void main(String[] args) {
        System.out.print("Enter the initial sixteen coins Hs and Ts: ");
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        char[] initialNode = s.toCharArray();
        SixteenTailModel model = new SixteenTailModel();
        List<Integer> path = model.getShortestPath(SixteenTailModel.getIndex(initialNode));

        if (path.size() > 1) {
            System.out.println("The steps to flip the coins are: ");
            for (Integer p: path) {
                SixteenTailModel.printNode(SixteenTailModel.getNode(p));
                System.out.println();
            }
        }
        else
            System.out.println("No path found.");

    }
}

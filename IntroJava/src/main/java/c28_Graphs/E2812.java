/*(Variation of the nine tails problem) In the nine tails problem, when you flip a
coin, the horizontal and vertical neighboring cells are also flipped. Rewrite the
program, assuming all neighboring cells including the diagonal neighbors are
also flipped.*/
package c28_Graphs;

import java.util.List;
import java.util.Scanner;

public class E2812 {
    public static void main(String[] args) {
        System.out.print("Enter the initial nine coins Hs and Ts: ");
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        char[] initialNode = s.toCharArray();
        NineTailModel2 model = new NineTailModel2();
        List<Integer> path = model.getShortestPath(NineTailModel2.getIndex(initialNode));

        System.out.println("The steps to flip the coins are: ");
        for (Integer p: path) {
            NineTailModel2.printNode(NineTailModel2.getNode(p));
            System.out.println();
        }

    }
}

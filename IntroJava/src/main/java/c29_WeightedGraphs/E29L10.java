//Nine tail model test
package c29_WeightedGraphs;

import c28_Graphs.NineTailModel;

import java.util.List;
import java.util.Scanner;

public class E29L10 {
    public static void main(String[] args) {
        System.out.print("Enter the initial nine coins Hs and Ts: ");
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        char[] initialNode = s.toCharArray();

        NineTailModelWeighted model = new NineTailModelWeighted();
        List<Integer> path = model.getShortestPath(NineTailModel.getIndex(initialNode));

        System.out.println("The steps to flip the coins are: ");
        for (Integer p: path) {
            NineTailModel.printNode(NineTailModel.getNode(p));
            System.out.println();
        }
        System.out.println("The number of flips is " + model.getNumberOfFlips(NineTailModel.getIndex(initialNode)));
    }
}

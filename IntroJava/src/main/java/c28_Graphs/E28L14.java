//Nine tail model test
package c28_Graphs;

import java.util.List;
import java.util.Scanner;

public class E28L14 {
    public static void main(String[] args) {
        System.out.print("Enter the initial nine coins Hs and Ts: ");
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        char[] initialNode = s.toCharArray();
        NineTailModel model = new NineTailModel();
        List<Integer> path = model.getShortestPath(NineTailModel.getIndex(initialNode));

        System.out.println("The steps to flip the coins are: ");
        for (Integer p: path) {
            NineTailModel.printNode(NineTailModel.getNode(p));
            System.out.println();
        }

    }
}

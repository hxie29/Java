/*(Prove or disprove) The conjecture is that both NineTailModel and
WeightedNineTailModel result in the same shortest path. Write a program
to prove or disprove it. (Hint: Let tree1 and tree2 denote the trees rooted at
node 511 obtained from NineTailModel and WeightedNineTailModel,
respectively. If the depth of a node u is the same in tree1 and in tree2, the
length of the path from u to the target is the same.)*/
package c29_WeightedGraphs;

import c28_Graphs.NineTailModel;

import java.util.List;

public class E2905 {
    public static void main(String[] args) {
        NineTailModel model1 = new NineTailModel();
        NineTailModelWeighted model2 = new NineTailModelWeighted();
        boolean differentResult = false;
        int count = 0;
        for (int i = 0; i < 512; i++) {
            count++;
            List<Integer> path1 = model1.getShortestPath(i);
            List<Integer> path2 = model2.getShortestPath(i);
            if (!path1.equals(path2)) {
                differentResult = true;
                break;
            }
        }
        System.out.println("Two models produce different result? " + differentResult + " Test rounds: " + count);
    }
}

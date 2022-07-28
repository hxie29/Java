/*(Weighted 4 * 4 16 tails model) The weighted nine tails problem in the text
uses a 3 * 3 matrix. Assume that you have 16 coins placed in a 4 * 4 matrix.
Create a new model class named WeightedTailModel16. Create an instance
of the model and save the object into a file named WeightedTailModel16.dat.*/
package c29_WeightedGraphs;

import c28_Graphs.SixteenTailModel;
import java.util.ArrayList;
import java.util.List;

public class SixteenTailModelWeighted extends SixteenTailModel {
    public SixteenTailModelWeighted() {
        List<WeightedEdge> edges = getEdges();
        WeightedGraph<Integer> graph = new WeightedGraph<>(edges, NUMBER_OF_NODES);
        tree = graph.getShortestPath(NUMBER_OF_NODES -1);
    }

    private List<WeightedEdge> getEdges() {
        List<WeightedEdge> edges = new ArrayList<>();
        for (int u = 0; u < NUMBER_OF_NODES; u++) {
            for (int k = 0; k < 16; k++) {
                char[] node = getNode(u);
                if (node[k] == 'H') {
                    int v = getFlipped(node, k);
                    edges.add(new WeightedEdge(v, u, getNumberOfFlips(v, u)));
                }
            }
        }
        return edges;
    }

    public int getNumberOfFlips(int u) {
        return (int)((WeightedGraph<Integer>.ShortestPathTree)tree).getCost(u);
    }

    private int getNumberOfFlips(int u, int v) {
        char[] nodeU = getNode(u);
        char[] nodeV = getNode(v);
        int count = 0;
        for (int i = 0; i < nodeU.length; i++) {
            if (nodeU[i] != nodeV[i])
                count++;
        }
        return count;
    }
}

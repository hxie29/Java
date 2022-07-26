package c29_WeightedGraphs;

import c28_Graphs.NineTailModel;
import java.util.ArrayList;
import java.util.List;

public class NineTailModelWeighted extends NineTailModel {
    public NineTailModelWeighted() {
        List<WeightedEdge> edges = getEdges();
        WeightedGraph<Integer> graph = new WeightedGraph<>(edges, NUMBER_OF_NODES);
        tree = graph.getShortestPath(511);
    }

    private List<WeightedEdge> getEdges() {
        List<WeightedEdge> edges = new ArrayList<>();
        for (int u = 0; u < NUMBER_OF_NODES; u++) {
            for (int k = 0; k < 9; k++) {
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

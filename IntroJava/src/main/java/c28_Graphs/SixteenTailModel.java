/*(4 * 4 16 tails problem) Listing 28.14, NineTail.java, presents a solution for
the nine tails problem. Revise this program for the 4 * 4 16 tails problem.
Note it is possible that a solution may not exist for a starting pattern. If so,
report that no solution exists.*/
package c28_Graphs;

import java.util.ArrayList;
import java.util.List;

public class SixteenTailModel {
    public final static int NUMBER_OF_NODES = (int)Math.pow(2, 16);
    protected UnweightedGraph<Integer>.SearchTree tree;

    public SixteenTailModel(){
        List<Edge> edges = getEdges();
        UnweightedGraph<Integer> graph = new UnweightedGraph<>(edges, NUMBER_OF_NODES);
        tree = graph.bfs((int)Math.pow(2, 16) -1);
    }

    private List<Edge> getEdges() {
        List<Edge> edges = new ArrayList<>();
        for (int u = 0; u < NUMBER_OF_NODES; u++) {
            for (int k = 0; k < 16; k++) {
                char[] node = getNode(u);
                if (node[k] == 'H') {
                    int v = getFlipped(node, k);
                    edges.add(new Edge(v, u));
                }
            }
        }
        return edges;
    }

    public static int getFlipped(char[] node, int position) {
        int row = position /4;
        int column = position % 4;
        flipACell(node, row, column);
        flipACell(node, row, column + 1);
        flipACell(node, row, column -1);
        flipACell(node, row -1, column);
        flipACell(node, row + 1, column);
        return getIndex(node);
    }

    public static void flipACell(char[] node, int row, int column) {
        if (row >= 0 && row <= 3 && column >= 0 && column <= 3) {
            if (node[row * 4 + column] == 'H')
                node[row * 4 + column] ='T';
            else
                node[row * 4 + column] ='H';
        }
    }

    public static int getIndex(char[] node) {
        int result = 0;
        for (int i = 0; i < 16; i++) {
            if (node[i] == 'T')
                result = result * 2 +1;
            else
                result *= 2;
        }
        return result;
    }

    public static char[] getNode(int u) {
        char[] result = new char[16];
        for (int i = 0; i < 16; i++) {
            int digit = u % 2;
            if (digit == 0)
                result[15-i] = 'H';
            else
                result[15-i] = 'T';
            u /= 2;
        }
        return result;
    }

    public List<Integer> getShortestPath(int nodeIndex) {
        return tree.getPath(nodeIndex);
    }

    public boolean hasSolution(int nodeIndex) {
        return tree.getPath(nodeIndex).size() > 1;
    }

    public static void printNode(char[] node) {
        for (int i = 0; i < 16; i++)
            System.out.print((i % 4 == 3) ? node[i] + "\n" : node[i] + "");
    }
}

/*(Variation of the nine tails problem) In the nine tails problem, when you flip a
coin, the horizontal and vertical neighboring cells are also flipped. Rewrite the
program, assuming all neighboring cells including the diagonal neighbors are
also flipped.*/
package c28_Graphs;

import java.util.ArrayList;
import java.util.List;

public class NineTailModel2{
    public final static int NUMBER_OF_NODES = 512;
    protected UnweightedGraph<Integer>.SearchTree tree;

    public NineTailModel2(){
        List<Edge> edges = getEdges();
        UnweightedGraph<Integer> graph = new UnweightedGraph<>(edges, NUMBER_OF_NODES);
        tree = graph.bfs(511);
    }

    private List<Edge> getEdges() {
        List<Edge> edges = new ArrayList<>();
        for (int u = 0; u < NUMBER_OF_NODES; u++) {
            for (int k = 0; k < 9; k++) {
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
        int row = position /3;
        int column = position % 3;
        flipACell(node, row, column);
        //diagonal flip
        flipACell(node, row-1, column-1);
        flipACell(node, row+1, column-1);
        flipACell(node, row-1, column+1);
        flipACell(node, row+1, column+1);
        //direct flip
        flipACell(node, row, column + 1);
        flipACell(node, row, column -1);
        flipACell(node, row -1, column);
        flipACell(node, row + 1, column);
        return getIndex(node);
    }
    public static void flipACell(char[] node, int row, int column) {
        if (row >= 0 && row <= 2 && column >= 0 && column <= 2) {
            if (node[row * 3 + column] == 'H')
                node[row * 3 + column] ='T';
            else
                node[row * 3 + column] ='H';
        }
    }

    public static int getIndex(char[] node) {
        int result = 0;
        for (int i = 0; i < 9; i++) {
            if (node[i] == 'T')
                result = result * 2 +1;
            else
                result *= 2;
        }
        return result;
    }

    public static char[] getNode(int u) {
        char[] result = new char[9];
        for (int i = 0; i < 9; i++) {
            int digit = u % 2;
            if (digit == 0)
                result[8-i] = 'H';
            else
                result[8-i] = 'T';
            u /= 2;
        }
        return result;
    }

    public List<Integer> getShortestPath(int nodeIndex) {
        return tree.getPath(nodeIndex);
    }

    public static void printNode(char[] node) {
        for (int i = 0; i < 9; i++)
            System.out.print((i % 3 == 2) ? node[i] + "\n" : node[i] + "");
    }
}

/*(Create a file for a graph) Modify Listing 28.2, TestGraph.java to create a file
representing graph1. The file format is described in Programming Exercise
28.1. Create the file from the array defined in lines 8–21 in Listing 28.2. The
number of vertices for the graph is 12, which will be stored in the first line of
the file. The contents of the file should be as follows:
12
0 1 3 5
1 0 2 3
2 1 3 4 10
3 0 1 2 4 5
4 2 3 5 7 8 10
5 0 3 4 6 7
6 5 7
7 4 5 6 8
8 4 7 9 10 11
9 8 11
10 2 4 8 11
11 8 9 10
*/
package c28_Graphs;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class E2802 {
    public static void main(String[] args) {

        int[][] edges = {
                {0, 1}, {0, 3}, {0, 5},
                {1, 0}, {1, 2}, {1, 3},
                {2, 1}, {2, 3}, {2, 4}, {2, 10},
                {3, 0}, {3, 1}, {3, 2}, {3, 4}, {3, 5},
                {4, 2}, {4, 3}, {4, 5}, {4, 7}, {4, 8}, {4, 10},
                {5, 0}, {5, 3}, {5, 4}, {5, 6}, {5, 7},
                {6, 5}, {6, 7},
                {7, 4}, {7, 5}, {7, 6}, {7, 8},
                {8, 4}, {8, 7}, {8, 9}, {8, 10}, {8, 11},
                {9, 8}, {9, 11},
                {10, 2}, {10, 4}, {10, 8}, {10, 11},
                {11, 8}, {11, 9}, {11, 10}
        };
        Graph<Integer> graph = new UnweightedGraph<>(edges, 12);
        File file = new File("E2802_result.txt");
        try (PrintWriter output = new PrintWriter(file)) {
            output.print(graph.getSize());
            for (int i = 0; i < graph.getSize(); i++) {
                output.print("\n" + i + " ");
                for (int j = 0; j < graph.getNeighbors(i).size(); j++)
                    output.print(graph.getNeighbors(i).get(j) + " ");
            }
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

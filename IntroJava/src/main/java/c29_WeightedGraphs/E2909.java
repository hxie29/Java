/*(Find a minimum spanning tree) Write a program that reads a connected graph
from a file and displays its minimum spanning tree. The first line in the file
contains a number that indicates the number of vertices (n). The vertices are
labeled as 0, 1, ... , n−1. Each subsequent line describes the edges in the form
of u1, v1, w1 | u2, v2, w2 | .... Each triplet in this form describes
an edge and its weight. Figure 29.23 shows an example of the file for the corresponding
graph. Note that we assume the graph is undirected. If the graph has
an edge (u, v), it also has an edge (v, u). Only one edge is represented in the
file. When you construct a graph, both edges need to be added.

File
6
0, 1, 100 | 0, 2, 3
1, 3, 20
2, 3, 40 | 2, 4, 2 | 2, 5, 5
3, 5, 5
4, 5, 9

Only one edge is represented in the file. When you construct a graph, both
edges need to be added. Your program should prompt the user to enter the name
of the file, read data from the file, create an instance g of WeightedGraph,
invoke g. printWeightedEdges() to display all edges, invoke
getMinimumSpanningTree() to obtain an instance tree of WeightedGraph.
MST, invoke tree.getTotalWeight() to display the weight of the minimum
spanning tree, and invoke tree. printTree() to display the tree. Here is a
sample run of the program:

Enter a file name: c:\exercise\WeightedGraphSample2.txt
The number of vertices is 6
Vertex 0: (0, 1, 100) (0, 2, 3)
Vertex 1: (1, 0, 100) (1, 3, 20)
Vertex 2: (2, 0, 3)(2, 3, 40) (2, 4, 2) (2, 5, 5)
Vertex 3: (3, 1, 20) (3, 2, 40) (3, 5, 5)
Vertex 4: (4, 2, 2) (4, 5, 9)
Vertex 5: (5, 2, 5) (5, 3, 5) (5, 4, 9)
Total weight in MST is 35
Root is: 0
Edges: (3, 1) (0, 2) (5, 3)(2, 4) (2, 5)

(Hint: Use new WeightedGraph(list, numberOfVertices) to create
a graph, where list contains a list of WeightedEdge objects. Use
new WeightedEdge(u, v, w) to create an edge. Read the first line to
get the number of vertices. Read each subsequent line into a string s and use
s.split("[\\|]") to extract the triplets. For each triplet, use triplet
.split("[,]") to extract vertices and weight.)*/
package c29_WeightedGraphs;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class E2909 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a file name: ");
        File file = new File(input.nextLine());
        input.close();

        try {
            WeightedGraph<Integer> graph = readGraph(file);
            System.out.println("The number of vertices is " + graph.getSize());
            graph.printWeightedEdges();
            WeightedGraph<Integer>.MST mst = graph.getMinimumSpanningTree();
            System.out.println("Total weight in MST is " + mst.getTotalWeight());
            mst.printTree();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public static WeightedGraph<Integer> readGraph(File file) throws IOException {
        try (Scanner in = new Scanner(file)) {
            int numberOfVertices = Integer.parseInt(in.nextLine());
            List<WeightedEdge> edges = new ArrayList<>();
            while (in.hasNextLine()) {
                String line = in.nextLine();
                String[] edgeLine = line.split("[|]");
                for (String edge: edgeLine) {
                    ArrayList<String> points = new ArrayList<>(Arrays.asList(edge.split("[\\s+,]")));
                    points.removeIf(e -> e.length() == 0);
                    for (int i = 0; i < points.size(); i+=3) {
                        edges.add(new WeightedEdge(Integer.parseInt(points.get(i)), Integer.parseInt(points.get(i+1)),
                                Integer.parseInt(points.get(i+2))));
                        edges.add(new WeightedEdge(Integer.parseInt(points.get(i + 1)), Integer.parseInt(points.get(i)),
                                Integer.parseInt(points.get(i+2))));
                    }
                }
            }
            return new WeightedGraph<>(edges, numberOfVertices);
        }
    }
}

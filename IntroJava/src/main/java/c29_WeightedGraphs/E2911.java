/*(Find shortest paths) Write a program that reads a connected graph from a
file. The graph is stored in a file using the same format specified in Programming
Exercise 29.9. Your program should prompt the user to enter the name of
the file then two vertices, and should display a shortest path between the two
vertices. For example, for the graph in Figure 29.23, a shortest path between
0 and 1 can be displayed as 0 2 5 3 1. Here is a sample run of the program:

Enter a file name: WeightedGraphSample2.txt
Enter two vertices (integer indexes): 0 1
The number of vertices is 6
Vertex 0: (0, 1, 100.0) (0, 2, 3.0)
Vertex 1: (1, 0, 100.0) (1, 3, 20.0)
Vertex 2: (2, 0, 3.0) (2, 3, 40.0) (2, 4, 2.0) (2, 5, 5.0)
Vertex 3: (3, 1, 20.0) (3, 2, 40.0) (3, 5, 5.0)
Vertex 4: (4, 2, 2.0) (4, 5, 9.0)
Vertex 5: (5, 2, 5.0) (5, 3, 5.0) (5, 4, 9.0)
A path from 0 to 1: 0 2 5 3 1*/
package c29_WeightedGraphs;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class E2911 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a file name: ");
        File file = new File(input.nextLine());
        System.out.println("Enter two vertices' integer indexes: ");
        int start = input.nextInt();
        int end = input.nextInt();
        input.close();

        try {
            WeightedGraph<Integer> graph = E2909.readGraph(file);
            System.out.println("The number of vertices is " + graph.getSize());
            graph.printWeightedEdges();
            WeightedGraph<Integer>.ShortestPathTree path = graph.getShortestPath(end);
            List<Integer> pathIndex = path.getPath(start);
            System.out.print("A path from " + start + " to " + end + ": ");
            pathIndex.forEach(e -> System.out.print(e + " "));
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

/*(Find paths) Define a new class named UnweightedGraphWithGetPath that
extends UnweightedGraph with a new method for finding a path between two
vertices with the following header:
public List<Integer> getPath(int u, int v);
The method returns a List<Integer> that contains all the vertices in a
path from u to v in this order. Using the BFS approach, you can obtain
the shortest path from u to v. If there isn’t a path from u to v, the method
returns null. Write a test program that creates a graph for Figure 28.1. The
program prompts the user to enter two cities and displays their paths. Here
is a sample run:

Enter a starting city: Seattle
Enter an ending city: Miami
The path is Seattle Denver Kansas City Atlanta Miami

*/
package c28_Graphs;

import java.util.List;
import java.util.Scanner;

public class E2805 {
    public static void main(String[] args) {
        String[] vertices = {"Seattle", "San Francisco", "Los Angeles",
                "Denver", "Kansas City", "Chicago", "Boston", "New York",
                "Atlanta", "Miami", "Dallas", "Houston"};

        // Edge array for graph in Figure 28.1
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
        UnweightedGraphWithGetPath<String> graph = new UnweightedGraphWithGetPath<>(vertices, edges);
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a starting city: ");
        String start = input.next();
        System.out.println("Enter an ending city: ");
        String end = input.next();

        List<Integer> path = graph.getPath(graph.getIndex(start), graph.getIndex(end));
        System.out.print("The path(1) is ");
        path.forEach(e -> System.out.print(graph.getVertex(e) + " "));
        System.out.println();

        List<String> path2 = graph.bfs(graph.getIndex(end)).getPath(graph.getIndex(start));
        System.out.print("The path(2) is ");
        path2.forEach(e -> System.out.print(e + " "));
        System.out.println();
    }
}

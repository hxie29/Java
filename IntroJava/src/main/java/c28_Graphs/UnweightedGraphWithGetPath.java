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

import java.util.ArrayList;
import java.util.List;

public class UnweightedGraphWithGetPath<V> extends UnweightedGraph<V> {
    public UnweightedGraphWithGetPath(){super();}
    public UnweightedGraphWithGetPath(V[] vertices, int[][] edges) {super(vertices, edges);}
    public UnweightedGraphWithGetPath(int[][] edges, int numberOfVertices){super(edges, numberOfVertices);}

    public List<Integer> getPath(int u, int v) {
        List<V> pathNodes = this.bfs(v).getPath(u);
        List<Integer> path = new ArrayList<>();
        pathNodes.forEach(e -> path.add(getIndex(e)));
        return path;
    }
}

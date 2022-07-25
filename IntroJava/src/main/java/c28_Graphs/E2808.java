/*((Test bipartite) Recall that a graph is bipartite if its vertices can be divided
into two disjoint sets such that no edges exist between vertices in the same set.
Define a new class named UnweightedGraphTestBipartite with the following
method to detect whether the graph is bipartite:
public boolean isBipartite();*/
package c28_Graphs;


public class E2808 {
    public static void main(String[] args) {
        int[][] edges = {
                {0, 1}, {0, 2}, {0, 3},
                {1, 0}, {1, 3},
                {2, 0}, {2, 3},
                {3, 0}, {3, 1}, {3, 2},
                {4, 5},
                {5, 4}};
        UnweightedGraphTestBipartite<Integer> graph = new UnweightedGraphTestBipartite<>(edges, 6);
        System.out.println("The graph is bipartite? " + graph.isBipartite());
    }
}

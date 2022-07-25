/*((Get bipartite sets) Add a new method in UnweightedGraph with the following
header to return two bipartite sets if the graph is bipartite:
public List<List<Integer>> getBipartite();
The method returns a List that contains two sublists, each of which contains a
set of vertices. If the graph is not bipartite, the method returns null.*/
package c28_Graphs;


public class E2809 {
    public static void main(String[] args) {
        int[][] edges = {
                {0, 1}, {0, 2}, {0, 3},
                {1, 0}, {1, 3},
                {2, 0}, {2, 3},
                {3, 0}, {3, 1}, {3, 2},
                {4, 5},
                {5, 4}};
        UnweightedGraph<Integer> graph = new UnweightedGraph<>(edges, 6);
        System.out.println("The graph is bipartite? " + graph.isBipartite() + graph.getBipartite());
    }
}

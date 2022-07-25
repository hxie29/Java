/*(Find connected components) Create a new class named MyGraph as a subclass
of UnweightedGraph that contains a method for finding all connected components
in a graph with the following header:
public List<List<Integer>> getConnectedComponents();
The method returns a List<List<Integer>>. Each element in the list is
another list that contains all the vertices in a connected component. For example,
for the graph in Figure 28.21b, getConnectedComponents() returns
[[0, 1, 2, 3], [4, 5]].*/
package c28_Graphs;

import java.util.*;

public class MyGraph<V> extends UnweightedGraph<V> {
    public MyGraph(){
        super();
    }
    public MyGraph(V[] vertices, int[][] edges) {super(vertices, edges);}
    public MyGraph(int[][] edges, int numberOfVertices) {super(edges, numberOfVertices);}

    @Override
    public List<List<Integer>> getConnectedComponents() {
        List<List<Integer>> paths = new ArrayList<>();
        ArrayList<V> remaining = new ArrayList<>(getVertices());
        while (remaining.size() > 0) {
            List<Integer> list = this.dfs(getIndex(remaining.get(0))).getSearchOrder();
            Collections.sort(list);
            paths.add(list);
            list.forEach(e -> remaining.remove(getVertex(e)));
        }
        return paths;
    }
}

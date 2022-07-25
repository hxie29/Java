/*(Test bipartite) Recall that a graph is bipartite if its vertices can be divided
into two disjoint sets such that no edges exist between vertices in the same set.
Define a new class named UnweightedGraphTestBipartite with the following
method to detect whether the graph is bipartite:
public boolean isBipartite();*/
package c28_Graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UnweightedGraphTestBipartite<V> extends MyGraph<V> {
    public UnweightedGraphTestBipartite(){
        super();
    }
    public UnweightedGraphTestBipartite(V[] vertices, int[][] edges) {super(vertices, edges);}
    public UnweightedGraphTestBipartite(int[][] edges, int numberOfVertices) {super(edges, numberOfVertices);}

    public boolean isBipartite() {
        return this.getConnectedComponents().size() == 2;
    }
}

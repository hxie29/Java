package c28_Graphs;

import java.io.Serializable;
import java.util.List;

public interface Graph<V> extends Serializable {
    int getSize();

    List<V> getVertices();

    V getVertex(int index);

    int getIndex(V v);

    List<Integer> getNeighbors(int index);

    int getDegree(int index);

    void printEdges();

    void clear();

    boolean addVertex(V vertex);

    boolean addEdge(int u, int v);

    boolean remove(V vertex);

    boolean remove (int u, int v);

    UnweightedGraph<V>.SearchTree dfs(int v);

    UnweightedGraph<V>.SearchTree bfs(int v);
}

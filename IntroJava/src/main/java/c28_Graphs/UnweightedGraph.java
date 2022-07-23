package c28_Graphs;

import java.util.ArrayList;
import java.util.List;

public class UnweightedGraph<V> implements Graph<V> {
    protected List<V> vertices = new ArrayList<>();
    protected  List<List<Edge>> neighbors = new ArrayList<>();

//    Constructors
    public UnweightedGraph(){
    }
    public UnweightedGraph(V[] vertices, int[][] edges) {
        for (V v: vertices)
            addVertex(v);
        createAdjacencyLists(edges);
    }
    public UnweightedGraph(List<V> vertices, List<Edge> edges) {
        for (V v: vertices)
            addVertex(v);
        createAdjacencyLists(edges);
    }
    public UnweightedGraph(int[][] edges, int numberOfVertices) {
        for (int i = 0; i < numberOfVertices; i++)
            addVertex((V) Integer.valueOf(i));
        createAdjacencyLists(edges);
    }
    public UnweightedGraph(List<Edge> edges, int numberOfVertices){
        for (int i = 0; i < numberOfVertices; i++)
            addVertex((V) Integer.valueOf(i));
        createAdjacencyLists(edges);
    }

//    Methods
    private void createAdjacencyLists(int[][] edges) {
        for (int[] pair: edges)
            addEdge(pair[0], pair[1]);
    }

    private void createAdjacencyLists(List<Edge> edges) {
        for (Edge e: edges)
            addEdge(e);
    }

    @Override
    public int getSize() {
        return vertices.size();
    }
    @Override
    public List<V> getVertices() {
        return vertices;
    }
    @Override
    public V getVertex(int index) {
        return vertices.get(index);
    }
    @Override
    public int getIndex(V v) {
        return vertices.indexOf(v);
    }
    @Override
    public List<Integer> getNeighbors(int index) {
        List<Integer> result = new ArrayList<>();
        for (Edge e: neighbors.get(index))
            result.add(e.v);
        return result;
    }
    @Override
    public int getDegree(int index) {
        return neighbors.get(index).size();
    }
    @Override
    public void clear() {
        vertices.clear();
        neighbors.clear();
    }
    @Override
    public boolean addVertex(V vertex) {
        if (!vertices.contains(vertex)) {
            vertices.add(vertex);
            neighbors.add((new ArrayList<>()));
            return true;
        }
        return false;
    }

    @Override
    public boolean addEdge(int u, int v) {
        return addEdge(new Edge(u, v));
    }

    private boolean addEdge(Edge edge) {
        if (edge.u < 0 || edge.u > getSize() -1)
            throw new IllegalArgumentException("No such index: " + edge.u);
        if (edge.v < 0 || edge.v > getSize() -1)
            throw new IllegalArgumentException("No such index: " + edge.v);
        if (!neighbors.get(edge.u).contains(edge)){
            neighbors.get(edge.u).add(edge);
            return true;
        }
        return false;
    }

    @Override
    public void printEdges() {
        for (int i = 0; i < neighbors.size(); i++) {
            System.out.print(getVertex(i) + " (" + i + "): ");
            for (Edge e: neighbors.get(i))
                System.out.print("(" + i + ", " + getVertex(e.v) + ") ");
        }
        System.out.println();
    }

    @Override
    public boolean remove(V vertex) {
        int index = vertices.indexOf(vertex);
        if (index >= 0) {
            vertices.remove(index);
            neighbors.remove(index);
            for (List<Edge> list: neighbors) {
                for (Edge e: list) {
                    if (e.v > index)
                        e.v--;
                    else if (e.v == index)
                        list.remove(e);
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(int u, int v) {
        return neighbors.get(u).removeIf(e -> e.v == v);
    }

    @Override
    public SearchTree dfs(int v) {
        return null;
    }

    @Override
    public SearchTree bfs(int v) {
        return null;
    }

    public class SearchTree {
        private final int root;
        private final int[] parent;
        private final List<Integer> searchOrder;

        public SearchTree(int root, int[] parent, List<Integer> searchOrder) {
            this.root = root;
            this.parent = parent;
            this.searchOrder = searchOrder;
        }
        public int getRoot(){
            return root;
        }
        public int getParent(int v) {return parent[v];}
        public List<Integer> getSearchOrder(){return searchOrder;}
        public int getNumberOfVerticesFound(){return searchOrder.size();}
        public List<V> getPath(int index) {
            ArrayList<V> path = new ArrayList<>();
            do {
                path.add(vertices.get(index));
                index = parent[index];
            }while(index != -1);
            return path;
        }

        public void printPath(int index) {
            List<V> path = getPath(index);
            System.out.print("A path from " + vertices.get(root) + " to " + vertices.get(index) + ": ");
            for (int i = path.size()-1; i >=0; i--)
                System.out.print(path.get(i) + " ");
        }

        public void printTree() {
            System.out.println("Root is: " + vertices.get(root));
            System.out.println("Edges: ");
            for (int i = 0; i < parent.length; i++)
                if (parent[i] != -1)
                    System.out.print("(" + vertices.get(parent[i]) + ", " + vertices.get(i) + ") ");
            System.out.println();
        }

    }
}


package c28_Graphs;

import java.io.Serializable;
import java.util.*;

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

    public boolean addEdge(Edge edge) {
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
            System.out.print("\n" + getVertex(i) + " (" + i + "): ");
            for (Edge e: neighbors.get(i))
                System.out.print("(" + i + ", " + e.v + ") ");
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
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).v > index) {
                        list.get(i).v--;
                        i--;
                    }
                    else if (list.get(i).v == index) {
                        list.remove(list.get(i));
                    }
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
        ArrayList<Integer> searchOrder = new ArrayList<>();
        int[] parent = new int[vertices.size()];
        Arrays.fill(parent, -1);
        boolean[] isVisited = new boolean[vertices.size()];
        dfs(v, parent, searchOrder, isVisited);
        return new SearchTree(v, parent, searchOrder);
    }

    private void dfs(int v, int[] parent, List<Integer> searchOrder, boolean[] isVisited) {
        searchOrder.add(v);
        isVisited[v] = true;
        for (Edge e: neighbors.get(v)) {
            if (!isVisited[e.v]) {
                parent[e.v] = v;
                dfs(e.v,parent,searchOrder,isVisited);
            }
        }
    }

    @Override
    public SearchTree bfs(int v) {
        LinkedList<Integer> queue = new LinkedList<>();
        ArrayList<Integer> searchOrder = new ArrayList<>();
        boolean[] isVisited = new boolean[vertices.size()];
        int[] parent = new int[vertices.size()];
        Arrays.fill(parent, -1);
        queue.offer(v);
        isVisited[v] = true;
        while (!queue.isEmpty()) {
            int u = queue.poll();
            searchOrder.add(u);
            for (Edge e: neighbors.get(u)) {
                if (!isVisited[e.v]) {
                    queue.add(e.v);
                    parent[e.v] = u;
                    isVisited[e.v] = true;
                }
            }
        }
        return new SearchTree(v,parent,searchOrder);
    }

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

    public boolean isBipartite() {
        return this.getConnectedComponents().size() == 2;
    }

    public List<List<Integer>> getBipartite() {
        return (this.isBipartite()) ? getConnectedComponents() : null;
    }

    public boolean isCyclic() {
        return false;
    }

    public class SearchTree implements Serializable {
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


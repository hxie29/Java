package c29_WeightedGraphs;

import c28_Graphs.Edge;
import c28_Graphs.UnweightedGraph;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WeightedGraph<V> extends UnweightedGraph<V> implements Serializable {

    public WeightedGraph(){}
    public WeightedGraph(V[] vertices, int[][]edges) {
        createWeightedGraph(Arrays.asList(vertices), edges);
    }
    public WeightedGraph(int[][] edges, int numberOfVertices) {
        List<V> vertices = new ArrayList<>();
        for (int i = 0; i < numberOfVertices; i++)
            vertices.add((V)(Integer.valueOf(i)));
        createWeightedGraph(vertices, edges);
    }
    public WeightedGraph(List<V> vertices, List<WeightedEdge> edges) {
        createWeightedGraph(vertices, edges);
    }

    public WeightedGraph(List<WeightedEdge> edges, int numberOfVertices) {
        List<V> vertices = new ArrayList<>();
        for (int i = 0; i < numberOfVertices; i++)
            vertices.add((V)(Integer.valueOf(i)));
        createWeightedGraph(vertices, edges);
    }

    private void createWeightedGraph(List<V> vertices, int[][] edges) {
        this.vertices = vertices;
        for (V v: vertices)
            neighbors.add(new ArrayList<>());
        for (int i = 0; i < edges.length; i++)
            neighbors.get(edges[i][0]).add(new WeightedEdge(edges[i][0], edges[i][1], edges[i][2]));
    }
    private void createWeightedGraph(List<V> vertices, List<WeightedEdge> edges) {
        this.vertices = vertices;
        for (V v: vertices)
            neighbors.add(new ArrayList<>());
        for (WeightedEdge edge: edges)
            neighbors.get(edge.getU()).add(edge);
    }

    public double getWeight(int u, int v) throws Exception {
        for (Edge edge: neighbors.get(u)) {
            if (edge.getV() == v)
                return ((WeightedEdge)edge).getWeight();
        }
        throw new Exception("Edge does not exit");
    }

    public void printWeightedEdges() {
        for (int i = 0; i < neighbors.size(); i++) {
            System.out.print("\n" + getVertex(i) + " (" + i + "): ");
            for (Edge e: neighbors.get(i))
                System.out.print("(" + i + ", " + e.getV() + ", " + ((WeightedEdge)e).getWeight() + ") ");
        }
        System.out.println();
    }

    public boolean addEdge(int u, int v, double weight) {
        return addEdge(new WeightedEdge(u, v, weight));
    }

    public MST getMinimumSpanningTree() {
        return getMinimumSpanningTree(0);
    }

    public MST getMinimumSpanningTree(int startingIndex) {
        ArrayList<Integer> searchOrder = new ArrayList<>();
        int[] parent = new int[vertices.size()];
        parent[startingIndex] = -1;
        double[] cost = new double[vertices.size()];
        Arrays.fill(cost, Double.POSITIVE_INFINITY);
        cost[startingIndex] = 0;
        double totalWeight = 0;

        List<Integer> T = new ArrayList<>();
        while (T.size() < vertices.size()) {
            int u = -1;
            double currentMinCost = Double.POSITIVE_INFINITY;
            //find the minimum cost in V-T set
            for (int i = 0; i < getSize(); i++) {
                if (!T.contains(i) && cost[i] < currentMinCost){
                    u = i;
                    currentMinCost = cost[i];
                }
            }
            // add u to the tree
            if (u == -1) break; // if graph is not connected, partial MST found
            else T.add(u);
            totalWeight += cost[u];

            // update the cost and parent of all adjacent nodes
            for (Edge e: neighbors.get(u)) {
                if (!T.contains(e.getV()) && cost[e.getV()] > ((WeightedEdge)e).getWeight()) {
                    cost[e.getV()] = ((WeightedEdge)e).getWeight();
                    parent[e.getV()] = u;
                }
            }
        }

        return new MST(startingIndex, parent, searchOrder, totalWeight);
    }

    public ShortestPathTree getShortestPath(int sourceIndex) {
        ArrayList<Integer> searchOrder = new ArrayList<>();
        int[] parent = new int[vertices.size()];
        parent[sourceIndex] = -1;
        double[] cost = new double[vertices.size()];
        Arrays.fill(cost, Double.POSITIVE_INFINITY);
        cost[sourceIndex] = 0;

        List<Integer> T = new ArrayList<>();
        while (T.size() < vertices.size()) {
            int u = -1;
            double currentMinCost = Double.POSITIVE_INFINITY;
            //find the minimum cost in V-T set
            for (int i = 0; i < getSize(); i++) {
                if (!T.contains(i) && cost[i] < currentMinCost){
                    u = i;
                    currentMinCost = cost[i];
                }
            }

            // add u to the tree
            if (u == -1) break;
            else T.add(u);

            // update the cost and parent of all adjacent nodes
            for (Edge e: neighbors.get(u)) {
                if (!T.contains(e.getV()) && cost[e.getV()] > ((WeightedEdge)e).getWeight() + cost[u]) {
                    cost[e.getV()] = ((WeightedEdge)e).getWeight() + cost[u];
                    parent[e.getV()] = u;
                }
            }
        }

        return new ShortestPathTree(sourceIndex, parent, searchOrder, cost);
    }
    public class MST extends SearchTree {
        private final double totalWeight;

        public MST(int root, int[] parent, List<Integer> searchOrder, double totalWeight) {
            super(root, parent, searchOrder);
            this.totalWeight = totalWeight;
        }
        public double getTotalWeight() {return totalWeight;}
    }

    public class ShortestPathTree extends SearchTree {
        private final double[] cost;
        public ShortestPathTree(int source, int[] parent, List<Integer> searchOrder, double[] cost) {
            super(source, parent, searchOrder);
            this.cost = cost;
        }

        public double getCost(int v) {return cost[v];}

        public void printAllPaths() {
            System.out.println("All shortest paths from " + vertices.get(getRoot()) + " are:");
            for (int i = 0; i < cost.length; i++) {
                printPath(i);
                System.out.println("(cost: " + cost[i] + ") ");
            }
        }

    }

}

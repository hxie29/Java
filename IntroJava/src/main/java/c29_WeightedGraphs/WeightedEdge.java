package c29_WeightedGraphs;

import c28_Graphs.Edge;

public class WeightedEdge extends Edge implements Comparable<WeightedEdge>{
    private double weight;

    public WeightedEdge(int u, int v, double weight) {
        super(u, v);
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public int compareTo(WeightedEdge o) {
        return Double.compare(weight, o.getWeight());
    }
}

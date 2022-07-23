package c28_Graphs;

public class Edge {
    int u;
    int v;

    public Edge(int u, int v) {
        this.u = u;
        this.v = v;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Edge)
            return u == ((Edge)o).u && v == ((Edge)o).v;
        return false;
    }

}

package c28_Graphs;

public class Edge {
    protected int u;
    protected int v;

    public Edge(int u, int v) {
        this.u = u;
        this.v = v;
    }

    public int getU(){return u;}

    public int getV(){return v;}

    @Override
    public boolean equals(Object o) {
        if (o instanceof Edge)
            return u == ((Edge)o).u && v == ((Edge)o).v;
        return false;
    }

}

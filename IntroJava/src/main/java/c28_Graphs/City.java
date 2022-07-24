package c28_Graphs;

public class City implements Displayable{
    private final double x;
    private final double y;
    private final String name;
    City(String name, double x, double y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public String getName() {
        return name;
    }
}

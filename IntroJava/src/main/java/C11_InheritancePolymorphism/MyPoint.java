package C11_InheritancePolymorphism;

class MyPoint {
    //data fields
    private final double x;
    private final double y;

    //Constructor
    public MyPoint() {
        this(0, 0);
    }

    public MyPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    //Methods
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double distance(double a, double b) {
        return Math.pow(((a - x) * (a - x) + (b - y) * (b - y)), 0.5);
    }

    public static double distance(MyPoint a, MyPoint b) {
        return a.distance(b.getX(), b.getY());
    }
}

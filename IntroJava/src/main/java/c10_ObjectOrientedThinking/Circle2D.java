package c10_ObjectOrientedThinking;

@SuppressWarnings("unused")
class Circle2D {
    private final double x;
    private final double y;
    private final double radius;

    //Constructor
    public Circle2D(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public Circle2D() {
        this(0, 0, 1);
    }

    //Methods
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getRadius() {
        return radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public double getPerimeter() {
        return Math.PI * radius * 2;
    }

    public boolean contains(double x, double y) {
        return (this.distance(x, y) < radius);
    }

    public boolean contains(Circle2D circle) {
        return (this.distance(circle.getX(), circle.getY()) + circle.getRadius() < radius);
    }

    public double distance(double x, double y) {
        return Math.pow(((x - this.x) * (x - this.x) + (y - this.y) * (y - this.y)), 0.5);
    }

    public boolean overlaps(Circle2D circle) {
        return (this.distance(circle.getX(), circle.getY()) + circle.getRadius() > radius)
                && (this.distance(circle.getX(), circle.getY()) - circle.getRadius() < radius);
    }

}

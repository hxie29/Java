package c13_AbstractClassesInterfaces;

//Subclass
class Triangle extends GeometricObject {
    //Data fields
    private double side1 = 1;
    private double side2 = 1;
    private double side3 = 1;

    //Constructor
    public Triangle() {
    }

    public Triangle(double side1, double side2, double side3) throws IllegalArgumentException {
        if (side1 + side2 > side3 && side2 + side3 > side1 && side1 + side3 > side2) {
            this.side1 = side1;
            this.side2 = side2;
            this.side3 = side3;
        } else throw new IllegalArgumentException("Length input invalid.");
    }

    public Triangle(double side1, double side2, double side3, String color, boolean filled) throws IllegalArgumentException {
        super(color, filled);
        if (side1 + side2 > side3 && side2 + side3 > side1 && side1 + side3 > side2) {
            this.side1 = side1;
            this.side2 = side2;
            this.side3 = side3;
        } else throw new IllegalArgumentException("Length input invalid.");
    }

    //Methods
    public double getSide1() {
        return side1;
    }

    public double getSide2() {
        return side2;
    }

    public double getSide3() {
        return side3;
    }

    public double getArea() {
        double s = (side1 + side2 + side3) / 2;
        return Math.pow((s * (s - side1) * (s - side2) * (s - side3)), 0.5);
    }

    public double getPerimeter() {
        return side1 + side2 + side3;
    }

    @Override
    public String toString() {
        return "Triangle: side1 = " + side1 + " side2 = " + side2 + " side3 = " + side3;
    }

}

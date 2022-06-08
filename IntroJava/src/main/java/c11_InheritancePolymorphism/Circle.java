package c11_InheritancePolymorphism;

//Subclass
class Circle extends GeometricObject {
    //Data fields (all data fields in superclass are inherited)
    private double radius;

    //Constructor
    public Circle() {
    }

    public Circle(double radius) {
        setRadius(radius);
    }

    public Circle(double radius, String color, boolean filled) {
        //Calling constructor from super class  --> always put on the first line of command
        super(color, filled);
        setRadius(radius);
    }

    //Methods
    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public double getPerimeter() {
        return Math.PI * radius * 2;
    }

    public void printCircle() {
        System.out.println("The circle is created " + getDate() + " and the radius is " + radius);
    }

    @Override
    public String toString() {
        return super.toString() + "\nradius is " + radius;
    }

}

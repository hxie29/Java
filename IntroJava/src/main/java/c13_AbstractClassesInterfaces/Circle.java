package c13_AbstractClassesInterfaces;

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

    // Implement
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
    public int compareTo(GeometricObject o) {
        return Double.compare(getArea(), o.getArea());
    }

    @Override
    public boolean equals(Object a) {
        try {
            return ((Circle)a).getRadius() == radius;
        }
        catch (Exception ex){
            System.out.println("Object must be a Circle.");
            return false;
        }
    }

    @Override
    public String toString() {
        return super.toString() + "\nradius is " + radius;
    }

}

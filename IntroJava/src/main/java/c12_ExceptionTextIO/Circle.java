package c12_ExceptionTextIO;

class Circle extends GeometricObject {

    //Data fields (all data fields in superclass are inherited)
    private double radius;
    private static int numberOfObjects = 0;

    //Constructor
    public Circle(double radius) throws InvalidRadiusException {
        setRadius(radius);
        numberOfObjects++;
    }

    public Circle(double radius, String color, boolean filled) throws InvalidRadiusException {
        //Calling constructor from super class  --> always put on the first line of command
        super(color, filled);
        setRadius(radius);
        numberOfObjects++;
    }

    //Methods
    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) throws InvalidRadiusException { // Declaring Exception on method line
        if (radius >= 0) {
            this.radius = radius;
        }
        else throw new InvalidRadiusException(radius); // Throw an exception
    }

    public static int getNumberOfObjects() {
        return numberOfObjects;
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

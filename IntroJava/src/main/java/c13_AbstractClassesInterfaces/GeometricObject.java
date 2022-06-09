package c13_AbstractClassesInterfaces;

import java.util.Date;

//Superclass
abstract class GeometricObject implements Comparable<GeometricObject> {
    //Data encapsulation
    private String color = "white";
    private boolean filled;
    private final Date dateCreated;

    //Constructor is defined as protected because it is used only by subclasses (even outside the package)
    protected GeometricObject() {
        dateCreated = new Date();
    }

    protected GeometricObject(String color, boolean filled) {
        setColor(color);
        setFilled(filled);
        dateCreated = new Date();
    }

    //Methods
    public String getColor() {
        return color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public Date getDate() {
        return dateCreated;
    }

    @Override
    public String toString() {
        return "created on " + dateCreated + "\ncolor: " + color + " and filled: " + filled;
    }

    //Public abstract methods does not have implementation, does not have a body, ends with;
    public abstract double getArea();

    public abstract double getPerimeter();

    @Override
    public int compareTo(GeometricObject o) {
        return Double.compare(getArea(), o.getArea());
    }

    //Return the max geometric object based on area
    public static GeometricObject max(GeometricObject a, GeometricObject b) {
        return (a.getArea() > b.getArea()) ? a : b;
    }


    public static double sumArea(GeometricObject[] list) {
        double sum = 0;
        for (GeometricObject geometricObject : list) {
            sum += geometricObject.getArea();
        }
        return sum;
    }

}

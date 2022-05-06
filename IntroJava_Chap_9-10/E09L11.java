// Array of objects
public class E09L11 {
    public static void main(String[] args) {
       Circle[] circleArray = createCircles();
       printCircleArray(circleArray);

    }

    public static Circle[] createCircles() {
        Circle[] array = new Circle[5];
        for (int i = 0; i < array.length; i++) {
            array[i] = new Circle((int)(Math.random() * 10));
        }
        return array;
    }

    public static void printCircleArray(Circle[] array) {
        System.out.printf("%-30s%-15s\n", "Radius", "Area");
        for (int i =0; i < array.length; i++) {
            System.out.printf("%-30.2f%-15f\n", array[i].getRadius(), array[i].getArea());
        }
        System.out.printf("The total area of circles is %-10.2f\n", sum(array));
    }

    public static double sum(Circle[] array){
        double sum = 0;
        for (int i =0; i < array.length; i++) {
            sum += array[i].getArea();
        }
        return sum;
    }
}

class Circle {
    //data field
    private double radius = 1;
    //This static data should not be modified via client directly
    private static int numberOfObjects = 0;

    // constructor
    public Circle() { // can be accessed from any class in any packages
        numberOfObjects++;
    }

    // constructor with arguments
    public Circle(double newRadius) {
        radius = newRadius;
        numberOfObjects++;
    }

    //To provide reader access to private data fields from other classes/ packages
    public double getRadius() {
        return radius; // now radius is accessed from a method defined in this class
    } 

    //To provide writer access to private data fields from other classes/ packages
    public void setRadius(double newRadius) {
        radius = (newRadius >= 0) ? newRadius : 0; // now radius is accessed from a method defined in this class
    }

    //To provide reader access to private data fields from other classes/ package
    //This is also an static method (can only access/invoke static methods/data fields)
    public static int getNumberOfObjects() {
        return numberOfObjects;
    }

    public double getArea() {
        return radius * radius * Math.PI;
    }
}

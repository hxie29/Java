import javax.crypto.Cipher;

/* modify the Circle class by adding a static variable numberOfObjects to
count the number of circle objects created. When the first object of this class is created,
numberOfObjects is 1. When the second object is created, numberOfObjects becomes 2.
*/
public class E09L06 {

    public static void main(String[] args) {
        Circle circle1 = new Circle();
        Circle circle2 = new Circle(2);
        System.out.println("Circle 1's area is " + circle1.getArea());
        System.out.println("Circle 2's area is " + circle2.getArea());
        System.out.println("Total number of circles created: " + Circle.getNumberOfCircles());
    }

    
}

class Circle {
    // Data fields
    double radius;
    static int numberOfCircles;

    //Constructor
    Circle() {
        radius = 1;
        numberOfCircles++;
    }

    Circle(double newRadius) {
        radius = newRadius;
        numberOfCircles++;
    }

    // Other methods
    static int getNumberOfCircles() {
        return numberOfCircles;
    }

    double getArea() {
        return radius * radius * Math.PI;
    }

}
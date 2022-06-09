package c13_AbstractClassesInterfaces;
//Abstract class with implementation of interfaces

public class E13L01 {
    public static void main(String[] args) {
        GeometricObject a = new Circle(5);
        GeometricObject b = new Rectangle(3, 5);
        System.out.println(a.compareTo(b));
    }
}


package C11_InheritancePolymorphism;

public class E11L01 {
    public static void main(String[] args) {
        Circle circle1 = new Circle(5);
        System.out.println("A circle " + circle1);
        System.out.println("Color: " + circle1.getColor());
        System.out.println("Filled: " + circle1.isFilled());
        System.out.println("Radius: " + circle1.getRadius());
        System.out.println("Area: " + circle1.getArea());
        System.out.println("Perimeter: " + circle1.getPerimeter());
        System.out.println(circle1);
    }
}

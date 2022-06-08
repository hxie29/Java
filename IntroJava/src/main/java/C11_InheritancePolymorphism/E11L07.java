package C11_InheritancePolymorphism;
//Casting demo
public class E11L07 {
    public static void main(String[] args){
        Object o1 = new Circle(1);
        Object r1 = new Rectangle(1, 2);
        displayObject(o1);
        displayObject(r1);

    }

    public static void displayObject(Object object){
        if (object instanceof Circle) {
            System.out.println("Radius is:" + ((Circle)object).getRadius());
            System.out.println("Area is:" + ((Circle)object).getArea());
        }
        else if (object instanceof Rectangle) {
            System.out.println("Perimeter is:" + ((Rectangle)object).getPerimeter());
            System.out.println("Area is:" + ((Rectangle)object).getArea());
        }
        System.out.println("Created on " + ((GeometricObject)object).getDate() + " Color is " + ((GeometricObject)object).getColor());
    }
}
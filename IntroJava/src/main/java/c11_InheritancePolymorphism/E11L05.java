package c11_InheritancePolymorphism;

public class E11L05 {
    public static void main(String[]args){
        displayObject(new Circle(5));
        displayObject(new Rectangle(1, 5));
    }

    public static void displayObject(GeometricObject object){
        System.out.println("Created on " + object.getDate() + " Color is " + object.getColor());
    }
}


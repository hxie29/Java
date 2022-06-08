package c09_ObjectsClasses;

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
        for (Circle circle : array) {
            System.out.printf("%-30.2f%-15f\n", circle.getRadius(), circle.getArea());
        }
        System.out.printf("The total area of circles is %-10.2f\n", sum(array));
    }

    public static double sum(Circle[] array){
        double sum = 0;
        for (Circle circle : array) {
            sum += circle.getArea();
        }
        return sum;
    }
}
package c12_ExceptionTextIO;
// Circle class with exception
public class E12L07{
    public static void main(String[] args) {
        try{
            Circle c1 = new Circle(5);
            Circle c2 = new Circle(-1);
            Circle c3 = new Circle(10);
        }
        catch(InvalidRadiusException ex) {
            ex.printStackTrace();// This is equivalent to print ex.toString()
        }

        System.out.println("Number of circles: " + Circle.getNumberOfObjects());
    }
}


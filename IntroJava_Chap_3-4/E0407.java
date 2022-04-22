import java.util.Scanner;

public class E0407 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the radius of the bouding circle: ");
        double r = input.nextDouble();

        // calculate first point
        double x1 = r * Math.cos(Math.PI / 10);
        double y1 = r * Math.sin(Math.PI / 10);
        System.out.println("The coordinate of P1 is (" + x1 + ", " + y1 + ")");
        
        double x2 = 0;
        double y2 = r;
        System.out.println("The coordinate of P2 is (" + x2 + ", " + y2 + ")");
        
        double x3 = -1 * x1;
        double y3 = y1;
        System.out.println("The coordinate of P3 is (" + x3 + ", " + y3 + ")");
        
        double x4 = r * Math.cos(Math.PI *4/5 + Math.PI * 0.5);
        double y4 = r * Math.sin(Math.PI *4/5 + Math.PI * 0.5);
        System.out.println("The coordinate of P4 is (" + x4 + ", " + y4 + ")");
        
        double x5 = -1 * x4;
        double y5 = y4;
        System.out.println("The coordinate of P5 is (" + x5 + ", " + y5 + ")");

        input.close();

    }    
}

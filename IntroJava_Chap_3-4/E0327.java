import java.util.Scanner;

public class E0327 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the coordinate of point x, y:");
        double x = input.nextDouble();
        double y = input.nextDouble();

        if ( (x>0) && (y>0) && (x + 2*y <200)) {
            System.out.println("The point is in the triangle.");
        }
        else 
            System.out.println("The point is in the triangle.");
        
        input.close();
    }    
}

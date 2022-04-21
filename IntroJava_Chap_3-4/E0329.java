import java.util.Scanner;

public class E0329 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        // input circles information
        System.out.println("Please enter the first circle coordinate and radius, x1, y1, r1: ");
        double x1 = input.nextDouble();
        double y1 = input.nextDouble();
        double r1 = input.nextDouble();
        System.out.println("Please enter the second circle coordinate and radius, x2, y2, r2: ");
        double x2 = input.nextDouble();
        double y2 = input.nextDouble();
        double r2 = input.nextDouble();

        // calculate the distance between centers of circles
        double dist = Math.sqrt( (x1-x2)*(x1-x2) + (y1-y2)*(y1-y2) );

        if (dist + Math.min(r2, r1) < Math.max(r1, r2) ) {
            System.out.println("A circle is inside another circle");
        }
        else if (dist > r1 + r2){
            System.out.println("Circles do not overlap");
        }
        else {
            System.out.println("Circles overlap.");
        }
        input.close();
    }
    
}

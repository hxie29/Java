package c03_Selections;

import java.util.Scanner;

public class E0328 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the first rectangular: x1, y1, w1, h1");
        double x1 = input.nextDouble();
        double y1 = input.nextDouble();
        double w1 = input.nextDouble();
        double h1 = input.nextDouble();
        System.out.println("Enter the second rectangular: x2, y2, w2, h2");
        double x2 = input.nextDouble();
        double y2 = input.nextDouble();
        double w2 = input.nextDouble();
        double h2 = input.nextDouble();
        
        if ( (x2 - 0.5 * w2 > x1 - 0.5 * w1) && ( x2 + 0.5*w2 < x1 + 0.5*w1) && (y2 - 0.5* h2 > y1 - 0.5*h1) && ( y2 + 0.5 * h2 < y1 + 0.5* h1) ) {
            System.out.println("Rectangle 1 is inside rectangal 2.");
        }
        else if ( (x2-0.5*w2 > x1+0.5*w1) || (x2+0.5*w2 < x1-0.5*w1) || (y2-0.5*h2 > y1+0.5*h1) || (y2+0.5*h2 < y1-0.5*h1) ) {
            System.out.println("Rectangle 1 does not overlap rectangal 2.");
        }
        else {
            System.out.println("Rectangle 1 overlaps with rectangal 2.");
        }

        input.close();
    }
}

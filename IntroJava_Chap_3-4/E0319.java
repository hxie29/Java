import java.util.Scanner;

public class E0319 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the lengths of three sides of a triangle: ");
        double l1 = input.nextDouble();
        double l2 = input.nextDouble();
        double l3 = input.nextDouble();

        if ((l1 + l2 > l3) && (l2 + l3 > l1)  && (l1 + l3 > l2)) {
            double peri = l1 + l2 + l3;
            System.out.println("The perimeter of the triangle is " + peri);
        }
        else {
            System.out.println("Invalid input.");
        }
        input.close();
    }
}

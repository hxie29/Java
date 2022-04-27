import java.util.Scanner;
public class E0619
 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Plase enter the length of the first side ");
        double s1 = input.nextDouble();
        System.out.println("Plase enter the length of the second side: ");
        double s2 = input.nextDouble();
        System.out.println("Plase enter the length of the third side: ");
        double s3 = input.nextDouble();

        if (checkTriangle(s1, s2, s3)) {
            System.out.println( "Valid input.");
            System.out.println("The area of the triangle is " + areaTriangle(s1, s2, s3));
        }
        else {
            System.out.println("Invalid input.");
        }

        input.close();

    }

    public static double areaTriangle(double s1, double s2, double s3) {
        double s = (s1 + s2 + s3) / 2;
        double area = Math.pow((s * (s-s1) * (s -s2) * (s-s3)), 0.5);
        return area;
    }

    
    public static boolean checkTriangle(double s1, double s2, double s3) {
        return (s1 + s2 > s3) && (s2 + s3 > s1) && (s1 + s3 >s2);
    }
}

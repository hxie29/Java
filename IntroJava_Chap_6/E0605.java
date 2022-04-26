import java.util.Scanner;

public class E0605 {
    public static void main(String[] args) {

        // enter a striing, calculate its length
        Scanner input = new Scanner(System.in);
        System.out.println("Enter three numbers:");
        double n1 = input.nextDouble();
        double n2 = input.nextDouble();
        double n3 = input.nextDouble();
        sortNumbers(n1, n2, n3);
    
        input.close();
    }

    public static void sortNumbers(double n1, double n2, double n3) {
        if (n1 < n2) {
            double temp = n1;
            n1 = n2;
            n2 = temp;
        }

        if ((n3 > n2) && (n3 < n1)) {
            double temp = n3;
            n3 = n2;
            n2 = temp;
        }

        if (n3 > n1) {
            double temp = n3;
            n3 = n1;
            n1 = temp;

            temp = n3;
            n3 = n2;
            n2 = temp;
        }   

        System.out.println(n1 + ", " + n2 + ", " + n3);
    }

}

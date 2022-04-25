import java.util.Scanner;

public class E0524 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the value of n:");
        int n = input.nextInt();
        double sum1 = 0.0;
        double sum2 = 0.0;

        //calculate from small value to big
        for (int k = n; k>0; k-=2) {
            sum1 = sum1 + 1.0 * k/(k+2);
        }
        System.out.println("The sum when calculating from right side is " + sum1);

        //calculate from big value to small
        for (int k = 1; k<=n; k+=2) {
            sum2 = sum2+ 1.0 * k / (k+2);
        }
        System.out.println("The sum when calculating from left side is " + sum2);

        input.close();
    }    
}

import java.util.Scanner;

public class E0530 {
    public static void main(String [] args) {
        Scanner input = new Scanner(System.in);

        // input
        System.out.println("Enter the monthly amount:");
        double monthly = input.nextDouble();
        System.out.println("Enter the number of months:");
        int numberOfMonth = input.nextInt();
        double principle = 0;
        final double MONTH_INTEREST = 0.0375 / 12;

        for (int n = 1; n <= numberOfMonth; n++) {
            principle += monthly;
            principle *= (1 + MONTH_INTEREST);
        }
        System.out.println("After " + numberOfMonth + "the amount in the savinfs account is $" + (int)(principle * 1000)/1000.0);

        input.close();
    }    
}

package c05_Loops;

import java.util.Scanner;

public class E0514 {
    public static void main(String [] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the first integer:");
        int n1 = input.nextInt();
        System.out.println("Enter the second integer:");
        int n2 = input.nextInt();
        int gcd = Math.min(n1, n2);

        while ((n1 % gcd != 0) || (n2 % gcd != 0)) {
            gcd--;
        }

        System.out.println("The greatest common divisor of " + n1 + " and " + n2 + " is " + gcd);
        input.close();
    }    
}

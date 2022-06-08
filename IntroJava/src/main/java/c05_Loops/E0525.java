package c05_Loops;

import java.util.Scanner;

public class E0525 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the limit of i:");
        int i = input.nextInt();
        double sum1 = 1;
        double power = 1.0;

        //calculate from small value to big
        for (int k = 1; k <= i; k++) {
            power /= k * 1.0 ;
            sum1 += power;
        }
        System.out.println("The approximate value of e is " + sum1);

        input.close();
    }    
}

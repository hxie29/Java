package c06_Methods;

import java.util.Scanner;

public class E0614 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the limit of i:");
        int i = input.nextInt();
        System.out.printf("%-5s%10s\n", "i", "m(i)");
        System.out.println("----------------------");

        // print
        for (int k = 1; k <= i; k+=100){
            System.out.printf("%-5d%10.4f\n",k, estimatePi(k));
        }          
        input.close();
    }

        //calculate pi
    public static double estimatePi(int i) {
        double sum1 = 0;
        for (int k = i; k>0; k--) {
            sum1 += 4 * Math.pow((-1), (k+1)) * 1.0 / (2 * k - 1);
        }
        return sum1;
    }
       
}

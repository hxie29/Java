package c05_Loops;

import java.util.Scanner;

public class E05L14 {
    public static void main(String [] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the first integer:");
        int n1 = input.nextInt();
        int k = 2;

        while ( k<n1 && (n1 % k) != 0) {
            k++;
            }
        System.out.println("The smallest factor is " + k);
        input.close();
    }   
}

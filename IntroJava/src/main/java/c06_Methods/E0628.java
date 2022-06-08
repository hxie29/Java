package c06_Methods;

import java.util.Scanner;

public class E0628 {
    public static void main(String[] args) {

        // enter a striing, calculate its length
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number:");
        int number = input.nextInt();
        displayMerse(number);
        input.close();

    }

    public static void displayMerse(int n) {
        System.out.printf("%-20s%-20s\n", "p", "2^p - 1");
        System.out.println("---------------------------");
        for (int i = 2; i<= n; i++) {
            int p = (int)Math.pow(2, i) - 1;
            if (isPrime(p)) {
                System.out.printf("%-20d%-20d\n", i, p);
            }
        }
    }

    public static boolean isPrime(int n) {
        for (int k = 2; k<= n/2; k++) {
            if (n % k == 0) 
                return false;
            }
        return true;
    }

}

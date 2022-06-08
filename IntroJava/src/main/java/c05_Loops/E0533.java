package c05_Loops;

import java.util.Scanner;

public class E0533 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //get guesses 
        System.out.println("Enter upper limit:");
        int limit = input.nextInt();
        
        for (int n = 2; n <= limit; n++) {
            boolean perfect;
            int factor = 1;
            int sum = 0;
            while (factor < n) {
                if (n % factor == 0) {
                    sum += factor;
                }
                factor++;
            }
            perfect = (sum == n);
            if (perfect) {
                System.out.println(n);
            }
        }

        input.close();
    }
    
}

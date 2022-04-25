import java.util.Scanner;

public class E05L11 {
    public static void main(String [] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the first integer:");
        int n1 = input.nextInt();
        System.out.println("Enter the second integer:");
        int n2 = input.nextInt();
        int gcd = 1;

        for (int k =2; k <= n1 && k <= n2 ; k++) {
            if ( (n1 % k == 0) && (n2 % k == 0) ) {
                gcd = k;
            }
        }

        System.out.println("The greatest common divisor of " + n1 + " and " + n2 + " is " + gcd);
        input.close();
    }    
}

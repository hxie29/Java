import java.util.Scanner;

public class E0629 {
    public static void main(String[] args) {

        // enter a striing, calculate its length
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number:");
        int number = input.nextInt();
        displayTwinPrime(number);
        input.close();

    }

    public static void displayTwinPrime(int n) {
        for (int i = 2; i<= n; i++) {
            if (isPrime(i) && isPrime(i+2)) {
                System.out.printf("(%-4d,%4d)\n", i, (i+2));
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

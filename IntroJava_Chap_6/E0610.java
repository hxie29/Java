import java.util.Scanner;

public class E0610 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the upper limit");
        int number = input.nextInt();

        findPrimeUnder(number);
        input.close();
    }

    public static void findPrimeUnder(int number) {
        int count = 0;
        for (int i = 1; i <= number; i++) {
            boolean prime = isPrime(i);
            if (prime) {
                System.out.printf("%-5d", i);
                count++;
            }
            if (count % 10 == 0) {
                System.out.println();
            }
        }
    }
    
    public static boolean isPrime(int number) {
        for (int k = 2; k<= number/2; k++) {
            if (number % k == 0) 
                return false;
            }
        return true;
    }
}

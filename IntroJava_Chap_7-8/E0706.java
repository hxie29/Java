// Find prime numbers up until n, using a boolean array 
import java.util.Scanner;

public class E0706 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the upper limit of n:");
        boolean[] prime = new boolean[input.nextInt() + 1];
        java.util.Arrays.fill(prime, true);
        for (int i = 1; i < prime.length; i++) {
            prime[i] = isPrime(i);
        }
        displayPrime(prime);
        input.close();
    }

    public static boolean isPrime(int n) {
        for (int k = 2; k<= n/2; k++) {
            if (n % k == 0) 
                return false;
            }
        return true;
    }

    public static void displayPrime(boolean[] list) {
        int count =0;
        for (int i = 1; i < list.length; i++) {
            count++;
            if (list[i]) System.out.print((count % 10 == 0) ? i + "\n" : i + " ");
        }
    }
}

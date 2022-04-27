import java.util.Scanner;

public class E0626 {
    public static void main(String[] args) {

        // enter a striing, calculate its length
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number:");
        int number = input.nextInt();
        displayPrimePalindrom(number);
        input.close();

    }

    public static void displayPrimePalindrom(int n) {
        int count = 0;
        for (int i = 2; i<= n; i++) {
            if ((isPalindrome(i)) && isPrime(i)) {
                count++;
                System.out.print((count % 10 == 0)? i + "\n" : i + " ");
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

    public static int getReverse(int number) {
        int reverse = 0;
        int length = ("" + number).length();
        for (int i = length; i >= 1; i--) {
            reverse += number % 10 * Math.pow(10, (i-1));
            number /= 10;
        }
        return reverse;
    }
    
    public static boolean isPalindrome (int number) {
        return number == getReverse(number);
    }
}

package c06_Methods;

import java.util.Scanner;

public class E0603 {
    public static void main(String[] args) {

        // enter a string, calculate its length
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number:");
        int number = input.nextInt();
        System.out.println("The reverse number is " + getReverse(number));
        System.out.println("The number is palindrome? " + isPalindrome(number)); 
        input.close();

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

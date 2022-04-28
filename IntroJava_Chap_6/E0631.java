// credit card number verification algorhithm design by Hans Luhn IBM

import java.util.Scanner;

public class E0631 {
    public static void main(String [] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your credit card number:");
        Long creditNumber = input.nextLong();
        if (validCard(creditNumber)) {
            System.out.println("Entered correctly.");
        }
        else System.out.println("Incorrect number.");

        input.close();
    }

    public static boolean validCard(Long creditNumber){
        return checkLength(creditNumber) && checkStart(creditNumber) && checkSum(creditNumber);
    }

    public static boolean checkLength(long creditNumber){
        System.out.println("The length of the number is " + (creditNumber + "").length());
        return (creditNumber + "").length() >= 13 && (creditNumber + "").length() <= 16;
    }
    
    public static boolean checkStart(long creditNumber) {
        int start = (creditNumber + "").charAt(0) - '0';
        int start2 = (creditNumber + "").charAt(2) - '0';
        if ((start >= 4 && start <= 6) || (start ==3 && start2 == 7)) {
            System.out.println("Prefix matches.");
            return true;
        }
        else {
            System.out.println("Prefix does not match.");
            return false;
        }
    }

    public static boolean checkSum(long creditNumber) {
        int sumStep2 = sumOfDoubleEvenPlace(creditNumber);
        int sumStep3 = sumOfOddPlace(creditNumber);
        if ((sumStep2 + sumStep3) % 10 == 0) {
            System.out.println("The result of step 4 satisfies."); 
            return true;
        }
        else {
            System.out.println("The result of step 4 does not satisfy.");
            return false;
        }
    }

    public static int sumOfDoubleEvenPlace(long creditNumber){
        int sum = 0;
        int length = (creditNumber + "").length();
        for (int i = 2; i <= length; i+=2) {
            int digit = getDigit(creditNumber, i);
            if (digit < 5) {
                sum += digit * 2;
            }
            else {
                digit *=2;
                sum = sum + getDigit(digit, 1) + getDigit(digit, 2);
            }
        }
        System.out.println("Result of step 2 is " + sum);
        return sum;
    }

    public static int sumOfOddPlace(long creditNumber){
        int sum = 0;
        int length = (creditNumber + "").length();
        for (int i = 1; i <= length; i+=2) {
            int digit = getDigit(creditNumber, i);
            sum += digit;
        }      
        System.out.println("Result of step 3 is " + sum);
        return sum;
    }
    
    public static int getDigit(long creditNumber, int n) {
        int length = (creditNumber + "").length();
        int digit = ("" + creditNumber).charAt(length - n) - '0';
        return digit;
    }
}

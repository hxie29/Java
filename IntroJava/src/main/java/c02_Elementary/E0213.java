package c02_Elementary;

import java.util.Scanner;
public class E0213 {
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        System.out.println("Please enter an monthly saving amount ");
        double interestRate = 3.75 / 100 / 12;
        double monthlyAmount = input.nextDouble();
        double first = monthlyAmount * Math.pow((1 + interestRate), 1);
        double total = first + monthlyAmount;
        double second = total * Math.pow((1 + interestRate), 1);
        total = second + monthlyAmount;
        double third = total * Math.pow((1 + interestRate), 1);
        total = third + monthlyAmount;
        double fourth = total * Math.pow((1 + interestRate), 1);
        total = fourth + monthlyAmount;
        double fifth = total * Math.pow((1 + interestRate), 1);
        total = fifth + monthlyAmount;
        double sixth = total * Math.pow((1 + interestRate), 1);
        System.out.println("After the first month, the account value is " + (int)(first * 100000) / 100000.0);
        System.out.println("After the second month, the account value is " + (int)(second * 100000) / 100000.0);
        System.out.println("After the third month, the account value is " + (int)(third * 100000) / 100000.0);
        System.out.println("After the sixth month, the account value is " + (int)(sixth * 100000) / 100000.0);
        input.close();

    }

}

package c05_Loops;

import java.util.Scanner;

public class E0536 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int sum = 0;
        StringBuilder isbn = new StringBuilder();

        for (int n = 1; n <= 9; n++) {
            System.out.println("Please enter a single digit: ");
            int d = input.nextInt();
            sum += (d * n);
            isbn.append(d);
        }
        int finalNumber = sum % 11;

        if (finalNumber == 10) {
            System.out.println("The ISBN-10 number is " + isbn + "X");
        }
        else
            System.out.println("The ISBN-10 number is " + isbn + finalNumber);

        input.close();
    }
}

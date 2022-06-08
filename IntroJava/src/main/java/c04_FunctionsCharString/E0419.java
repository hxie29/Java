package c04_FunctionsCharString;

import java.util.Scanner;

public class E0419 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter 9 digits of ISBN: ");
        String isbn = input.nextLine();
        int d1 = isbn.charAt(0) - '0';
        int d2 = isbn.charAt(1) - '0';
        int d3 = isbn.charAt(2) - '0';
        int d4 = isbn.charAt(3) - '0';
        int d5 = isbn.charAt(4) - '0';
        int d6 = isbn.charAt(5) - '0';
        int d7 = isbn.charAt(6) - '0';
        int d8 = isbn.charAt(7) - '0';
        int d9 = isbn.charAt(8) - '0';

        int d10 = (d1 + d2 * 2 + d3 *3 + d4 *4 + d5 * 5 + d6 * 6 + d7 * 7 + d8 *8 + d9 * 9) % 11;


    if (d10 == 10) {
        System.out.println("The ISBN-10 number is " + d1 + d2 + d3 + d4 + d5 + d6 + d7 + d8 + d9 + "X");
    }  
    else
        System.out.println("The ISBN-10 number is " + d1 + d2 + d3 + d4 + d5 + d6 + d7 + d8 + d9 + d10);

    input.close();
    }
}

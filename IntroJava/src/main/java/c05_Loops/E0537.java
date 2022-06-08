package c05_Loops;

import java.util.Scanner;

public class E0537 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a decimal number:");
        int decimal = input.nextInt();
        int remainder;
        StringBuilder binary = new StringBuilder();

        do {
            remainder = decimal % 2;
            char binaryDigit = (remainder == 0) ? '0' : '1';
            binary.insert(0, binaryDigit);
            decimal /= 2;
        } while ( decimal != 0);

        if (binary.length() < 8) {
            for (int x = binary.length(); x < 8; x++) {
                binary.insert(0, "0");
            }
        }
        System.out.println(binary);
        input.close();
    }    
}

/* to solve the input 0 problem (not using do-while);
     System.out.println("The hex number is " + (hex.length() == 0 ? "0" : hex)) */


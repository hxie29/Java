package c04_FunctionsCharString;

import java.util.Scanner;

public class E0411 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a binary number (0000 to 1111):");
        String binary = input.nextLine();
        int decimal = 0;

        if ( binary.charAt(0) == '1') {
            decimal += 8;
        }
        // System.out.println(decimal);

        if ( (int) binary.charAt(1) == '1') {
            decimal += 4;
        }

        if ( (int) binary.charAt(2) == '1') {
            decimal += 2;
        }

        if ( (int) binary.charAt(3) == '1') {
            decimal += 1;
        }

        System.out.println("The decimal number for the binary number is " + decimal );
        
        input.close();
    }
}

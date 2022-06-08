package c05_Loops;

import java.util.Scanner;

public class E05L13 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a decimal number:");
        int decimal = input.nextInt();
        int remainder;
        StringBuilder hexadecimal = new StringBuilder();

        do {
            remainder = decimal % 16;
            char hexdigit = (remainder <=9) ? (char)(remainder + '0') : (char) ((remainder - 10) + 'A');
            hexadecimal.insert(0, hexdigit);
            decimal /= 16;
        } while ( decimal != 0);
        
        System.out.println(hexadecimal);
        input.close();
    }    
}

/* to solve the input 0 problem (not using do-while);
     System.out.println("The hex number is " + (hex.length() == 0 ? "0" : hex)) */


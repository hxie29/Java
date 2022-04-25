import java.util.Scanner;

public class E0538 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a decimal number:");
        int decimal = input.nextInt();
        int remainder = 0;
        String octal = "";
        int binaryDigit = 0;

        do {
            remainder = decimal % 8;
            switch (remainder) {
                case 0: binaryDigit = 0; break; 
                case 1: binaryDigit = 1; break; 
                case 2: binaryDigit = 2; break; 
                case 3: binaryDigit = 3; break; 
                case 4: binaryDigit = 4; break; 
                case 5: binaryDigit = 5; break; 
                case 6: binaryDigit = 6; break; 
                case 7: binaryDigit = 7; break; 
            }
            octal = binaryDigit + octal;
            decimal /= 8;
        } while ( decimal != 0);

        if (octal.length() < 8) {
            for (int x = octal.length(); x < 8; x++) {
                octal = "0" + octal;
            }
        }
        System.out.println(octal);
        input.close();
    }    
}

/* to solve the input 0 problem (not using do-while);
     System.out.println("The hex number is " + (hex.length() == 0 ? "0" : hex)) */


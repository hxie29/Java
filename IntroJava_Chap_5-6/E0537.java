import java.util.Scanner;

public class E0537 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a decimal number:");
        int decimal = input.nextInt();
        int remainder = 0;
        String binary = "";

        do {
            remainder = decimal % 2;
            char binaryDigit = (remainder == 0) ? '0' : '1';
            binary = binaryDigit + binary;
            decimal /= 2;
        } while ( decimal != 0);

        if (binary.length() < 8) {
            for (int x = binary.length(); x < 8; x++) {
                binary = "0" + binary;
            }
        }
        System.out.println(binary);
        input.close();
    }    
}

/* to solve the input 0 problem (not using do-while);
     System.out.println("The hex number is " + (hex.length() == 0 ? "0" : hex)) */


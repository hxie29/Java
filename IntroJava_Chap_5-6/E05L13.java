import java.util.Scanner;

public class E05L13 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a decimal number:");
        int decimal = input.nextInt();
        int remainder = 0;
        String hexadecimal = "";

        do {
            remainder = decimal % 16;
            char hexdigit = (remainder <=9) ? (char)(remainder + '0') : (char) ((remainder - 10) + 'A');
            hexadecimal = hexdigit + hexadecimal;
            decimal /= 16;
        } while ( decimal != 0);
        
        System.out.println(hexadecimal);
        input.close();
    }    
}

/* to solve the input 0 problem (not using do-while);
     System.out.println("The hex number is " + (hex.length() == 0 ? "0" : hex)) */


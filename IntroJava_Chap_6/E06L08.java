import java.util.Scanner;

public class E06L08 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // prompt to get a hex number
        System.out.println("Enter a hex number:");
        String hex =  input.nextLine();

        // turn to uppercase
        System.out.println("The decimal number for " + hex + " is " + hexToDecimal(hex.toUpperCase()));
        input.close();
    }

    public static int hexToDecimal(String hexNumber) {
        int decimal = 0;
        for (int i = 0; i < hexNumber.length(); i++) {
            char hexDigit = hexNumber.charAt(i);
            decimal = decimal * 16 + hexDigitValue(hexDigit);
        }
        return decimal;
    }

    public static int hexDigitValue (char hexDigit) {
        
        if (hexDigit >= 'A' && hexDigit <= 'F') {
            return hexDigit - 'A' + 10; 
        }
        else {
            return hexDigit -'0';
        }

    }
    
}

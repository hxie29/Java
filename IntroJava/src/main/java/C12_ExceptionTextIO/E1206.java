/*
(NumberFormatException) Listing 6.8 implements the hex2Dec(String
hexString) method, which converts a hex string into a decimal number.
Implement the hex2Dec method to throw a NumberFormatException if the
string is not a hex string.
*/
import java.util.Scanner;
public class E1206 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // prompt to get a hex number
        System.out.println("Enter a hex number:");
        String hex =  input.nextLine();

        // turn to uppercase
        try{
            System.out.println("The decimal number for " + hex + " is " + hexToDecimal(hex.toUpperCase()));
        }
        catch (NumberFormatException ex) {
            System.out.println(ex.getMessage());
        }
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

    public static int hexDigitValue (char hexDigit) throws NumberFormatException {
        
        if (hexDigit >= 'A' && hexDigit <= 'F') {
            return hexDigit - 'A' + 10; 
        }
        else if (hexDigit >= '0' && hexDigit <= '9') {
            return hexDigit -'0';
        }

        else 
            throw new NumberFormatException("Input is not a hex number.");

    }
    
}

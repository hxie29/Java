package c12_ExceptionTextIO;/*
(HexFormatException) Programming Exercise 12.6 implements the hex2Dec
method to throw a NumberFormatException if the string is not a hex string.
Define a custom exception called HexFormatException. Implement the hex2Dec
method to throw a HexFormatException if the string is not a hex string.
*/
import java.util.Scanner;
public class E1208 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // prompt to get a hex number
        System.out.println("Enter a hex number:");
        String hex =  input.nextLine();

        // turn to uppercase
        try{
            System.out.println("The decimal number for " + hex + " is " + hexToDecimal(hex.toUpperCase()));
        }
        catch (HexFormatException ex) {
            System.out.println("Error:" + ex.getMessage());
        }
        input.close();
    }

    public static int hexToDecimal(String hexNumber) throws HexFormatException{
        int decimal = 0;
        for (int i = 0; i < hexNumber.length(); i++) {
            char hexDigit = hexNumber.charAt(i);
            decimal = decimal * 16 + hexDigitValue(hexDigit);
        }
        return decimal;
    }

    public static int hexDigitValue (char hexDigit) throws HexFormatException {
        
        if (hexDigit >= 'A' && hexDigit <= 'F') {
            return hexDigit - 'A' + 10; 
        }
        else if (hexDigit >= '0' && hexDigit <= '9') {
            return hexDigit -'0';
        }

        else 
            throw new HexFormatException();

    }
    
}


/*(Decimal to hex) Write a recursive method that converts a decimal number into
a hex number as a string. The method header is
public static String dec2Hex(int value)
Write a test program that prompts the user to enter a decimal number and displays
its hex equivalent.*/
package c18_Recursion;

public class E1822 {
    public static void main(String[] args) {
        int x = 356;
        System.out.println(dec2Hex(x));
        System.out.println(Integer.toHexString(x));
    }

    public static String dec2Hex(int x) {
        if (x > 0) {
            int digit = x % 16;
            return dec2Hex(x / 16) + digit;
        }
        else {
            return "";
        }
    }
}

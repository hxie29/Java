/* (View hex) Write a program that prompts the user to enter a file name, reads bytes
from the file, and displays each byte’s hex representation. (Hint: You can first
convert the byte value into an 8-bit string, then convert the bit string into a twodigit
hex string.)
*/

import java.io.*;

public class E1719 {
    public static void main(String[] agrs) throws FileNotFoundException, IOException{

        try (BufferedInputStream input = new BufferedInputStream (new FileInputStream(new File("test.txt")))) {
            int r;
            while ((r = input.read()) != -1) {
                System.out.print(Integer.toHexString(r));
            }
        } 
    }
/* 
    public static String getHex(int value) {
        return (value / 16) + "" + (value % 16);
    }
 */
}

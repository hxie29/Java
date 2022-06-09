package c17_BinaryIO;/* (View hex) Write a program that prompts the user to enter a file name, reads bytes
from the file, and displays each byte’s hex representation. (Hint: You can first
convert the byte value into an 8-bit string, then convert the bit string into a two digit
hex string.)
*/

import java.io.*;

public class E1719 {
    public static void main(String[] agrs) throws IOException{

        try (BufferedInputStream input = new BufferedInputStream (new FileInputStream("test.txt"))) {
            int r;
            while ((r = input.read()) != -1) {
                System.out.print(Integer.toHexString(r));
            }
        } 
    }
}

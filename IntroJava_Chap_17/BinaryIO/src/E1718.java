/* (View bits) Write the following method that displays the bit representation for the
last byte in an integer:
public static String getBits(int value)
For a hint, see Programming Exercise 5.44. Write a program that prompts the user
to enter a file name, reads bytes from the file, and displays each byte’s binary
representation.
*/

import java.io.*;

public class E1718 {
    public static void main(String[] agrs) throws FileNotFoundException, IOException{

        try (BufferedInputStream input = new BufferedInputStream (new FileInputStream(new File("test.txt")))) {
            int r;
            while ((r = input.read()) != -1) {
                System.out.println(getBits(r));
            }
        } 

    }

    public static String getBits(int value) {
        String byteString = "";

        for (int i = 7; i >= 0; i--)
            byteString += ((value >> i) & 1);

        return byteString;
    }

}

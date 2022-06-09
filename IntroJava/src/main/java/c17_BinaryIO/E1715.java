package c17_BinaryIO;/* (Decrypt files) Suppose a file is encrypted using the scheme in Programming
Exercise 17.14. Write a program to decode an encrypted file. Your program
should prompt the user to enter an input file name for the encrypted file and an
output file name for the unencrypted version of the input file.
*/

import java.io.*;

public class E1715 {
    public static void main(String[] args) throws IOException {

        File source = new File("array_encrypted.dat");
        File target = new File("array_decrypted.dat");

        try (BufferedInputStream input = new BufferedInputStream(new FileInputStream(source)); 
            BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(target))) {
            
            int r;
            while ((r = input.read()) != -1) {
                r -= 10;
                output.write(r);
            }

        }
    }  
}

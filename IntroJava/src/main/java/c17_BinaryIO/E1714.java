package c17_BinaryIO;/* (Encrypt files) Encode the file by adding 10 to every byte in the file. Write a gram
that prompts the user to enter an input file name and an output file name and saves
the encrypted version of the input file to the output file.
*/

import java.io.*;

public class E1714 {
    public static void main(String[] args) throws IOException {

        File source = new File("array.dat");
        File target = new File("array_encrypted.dat");

        try (BufferedInputStream input = new BufferedInputStream(new FileInputStream(source)); 
            BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(target))) {
            
            int r;
            while ((r = input.read()) != -1) {
                r += 10;
                output.write(r);
            }

        }
    }  
}

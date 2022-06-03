/* 
(Create a binary data file) Write a program to create a file named
Exercise17_02.dat if it does not exist. Append new data to it if it already exists.
Write 150 integers created randomly into the file using binary I/O.
 */
import java.io.*;

public class E1702 {
    public static void main(String[] args) throws IOException {

        File file = new File("E17_02.dat");

        try (DataOutputStream output = new DataOutputStream(new FileOutputStream(file, file.exists()))) {
            for (int i = 0; i < 150; i++) {
                output.writeInt((int)(Math.random() * 150));
            }
        }

    }
    
}

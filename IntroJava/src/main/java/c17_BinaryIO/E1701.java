package c17_BinaryIO;/*
(Create a text file) Write a program to create a file named Exercise17_01.txt if it
does not exist. Append new data to it if it already exists. Write 150 integers created
randomly into the file using text I/O. Integers are separated by a space.

 */
import java.io.*;

public class E1701 {
    public static void main(String[] args) throws IOException {

        File file = new File("E17_01.txt");

        try (PrintWriter output = new PrintWriter(new FileOutputStream(file, file.exists()))) {
            output.println();
            for (int i = 0; i < 150; i++) {
                output.write((int)(Math.random() * 150) + " ");
            }
        }

    }
    
}

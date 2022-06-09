package c17_BinaryIO;/*
 FileInputStream/FileOutputStream are for reading/writing bytes from/to files.
All the methods in these classes are inherited from InputStream and OutputStream.
FileInputStream/FileOutputStream do not introduce new methods. To construct a
FileInputStream, use the constructors shown in Figure 17.6.
A java.io.FileNotFoundException will occur if you attempt to create a
FileInputStream with a nonexistent file.

 */
import java.io.*;

public class E17L01 {
    public static void main(String[] args) throws IOException {
        try (FileOutputStream output = new FileOutputStream("temp.dat")) {
            for (int i = 1; i <= 10; i++) 
                output.write(i);
        }

        try (FileInputStream input = new FileInputStream("temp.dat")) {
            int value;
            while ((value = input.read()) != -1) {
                System.out.println(value + "");
            }
        }
    }
    
}

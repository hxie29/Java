package c17_BinaryIO;/*
(Sum all the floating points in a binary data file) Suppose a binary data file
named Exercise17_03.dat has been created and its data are created using
writeDouble(double) in DataOutputStream. The file contains an unspecified
number of floating points. Write a program to find the sum of the floating
points.
 */
import java.io.*;

public class E1703 {
    public static void main(String[] args) throws IOException {

        File file = new File("E17_03.dat");

        try (DataOutputStream output = new DataOutputStream(new FileOutputStream(file, file.exists()))) {
            for (int i = 0; i < 150; i++) {
                output.writeDouble(Math.random() * 100);
            }
        }

        try {
            try (DataInputStream input = new DataInputStream(new FileInputStream(file))) {
                double sum = 0;
                int count = input.available() / 8;
                for (int i = count; i > 0; i--) {
                    sum += input.readDouble();
                }
                System.out.println("Sum is " + sum);
            }
        }

        catch (EOFException ex) {
            System.out.println("Done");
        }

    }
    
}

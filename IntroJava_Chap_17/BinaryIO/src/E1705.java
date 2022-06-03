/* (Store objects and arrays in a file) Write a program that stores an array of the six
int values 1, 2, 3, 4,5, and 6, a Date object for the current time, and the double
value 10.5 into the file named Exercise17_05.dat.
*/

import java.io.*;
import java.util.Date;

public class E1705 {
    public static void main(String[] args) throws ClassNotFoundException, IOException {
        int[] numbers = {1, 2, 3, 4, 5, 6};

        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("E17_05.dat", true))) {
            output.writeObject(numbers);
            output.writeObject(new Date());
            output.writeDouble(10.5);
        }

        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("E17_05.dat"))) {
            //need to cast object into specific class
            int[] newNumbers = (int[]) (input.readObject());
            for (int number: newNumbers) System.out.print(number + " ");
            System.out.println();
            System.out.println((Date)(input.readObject()) + " " + (double)input.readDouble()); 
        }
    }  
}

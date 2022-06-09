package c17_BinaryIO;/* A random-access file consists of a sequence of bytes. A special marker called a file pointer is
positioned at one of these bytes. A read or write operation takes place at the location of the file
pointer. When a file is opened, the file pointer is set at the beginning of the file. When you read
from or write data to the file, the file pointer moves forward to the next data item

For a RandomAccessFile raf, you can use the raf.seek(position) method to move
the file pointer to a specified position. raf.seek(0) moves it to the beginning of the file
and raf.seek(raf.length()) moves it to the end of the file
*/

import java.io.*;

public class E17L08 {
    public static void main(String[] args) throws IOException {
        // create random access file
        try (RandomAccessFile inout = new RandomAccessFile("inout.dat", "rw")) {
            //clear the file to destroy the old contents if exists
            inout.setLength(0);

            for (int i = 0; i < 200; i++) 
                inout.writeInt(i);
            
            System.out.println("Current file length is " + inout.length());

            inout.seek(0); // move the pointer to the beginning
            System.out.println("The first number is " + inout.readInt());
            
            inout.seek(4); // move the pointer to the second int
            System.out.println("The second number is " + inout.readInt());

            inout.seek(9 * 4); // move the pointer to the front of the 10 int
            System.out.println("The tenth number is " + inout.readInt());

            inout.writeInt(555); // write int 555 at the current position, the previous eleventh number is deleted
            System.out.println("The new length is " + inout.length());
            
            inout.seek(inout.length()); // move the pointer to the end of the file
            inout.writeInt(999);
            System.out.println("The new length is " + inout.length());

            inout.seek(10 * 4); // move the pointer to the front of the eleventh int
            System.out.println("The eleventh number is " + inout.readInt());
        }
    }  
}

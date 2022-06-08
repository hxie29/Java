/* (Update count) Suppose that you wish to track how many times a program has
been executed. You can store an int to count the file. Increase the count by 1
each time this program is executed. Let the program be Exercise17_08.txt and
store the count in Exercise17_08.dat.
*/

import java.io.*;

public class E1708 {
    public static void main(String[] args) throws IOException {
        
        try (RandomAccessFile raf = new RandomAccessFile("E17_08.dat", "rw")) {
            int count = (raf.length() == 0) ? 1 : raf.readInt() + 1;
            raf.seek(0);
            raf.writeInt(count);
            System.out.println("Current count is " + count);
        }

    }  
}

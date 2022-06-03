/* If you keep reading data at the end of an InputStream, an EOFException will occur. This
exception can be used to detect the end of a file,
*/

/* BufferedInputStream/BufferedOutputStream can be used to speed up input and output by
reducing the number of disk reads and writes. Using BufferedInputStream, the whole block
of data on the disk is read into the buffer in the memory once. The individual data are then loaded
to your program from the buffer, as shown in Figure 17.12a. Using BufferedOutputStream,
the individual data are first written to the buffer in the memory. When the buffer is full, all data
in the buffer are written to the disk once, as shown in Figure 17.12b.

BufferedInputStream/BufferedOutputStream does not contain new methods. All
the methods in BufferedInputStream/BufferedOutputStream are inherited from the
InputStream/OutputStream classes. BufferedInputStream/BufferedOutputStream
manages a buffer behind the scene and automatically reads/writes data from/to disk on demand.
You can wrap a BufferedInputStream/BufferedOutputStream on any InputStream/
OutputStream
*/

import java.io.*;

public class E17L03 {
    public static void main(String[] args) throws IOException {
        try {
            try (DataOutputStream output = new DataOutputStream(new BufferedOutputStream (new FileOutputStream("test.dat")));) {
                output.writeDouble(85.5);
                output.writeDouble(185.5);
                output.writeDouble(105.25);
            }
    
            try (DataInputStream input = new DataInputStream(new BufferedInputStream (new FileInputStream("test.dat")));) {
               while (true) {
                   System.out.println(input.readDouble());
               }
            }
        }

        catch (EOFException ex) {
            System.out.println("Done.");
        }
    }
    
}

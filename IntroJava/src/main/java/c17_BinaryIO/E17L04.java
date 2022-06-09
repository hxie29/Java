package c17_BinaryIO;/* java Copy source target
The program copies the source file to the target file and displays the number of bytes in the file.
The program should alert the user if the source file does not exist or if the target file already
exists.

To copy the contents from a source file to a target file, it is appropriate to use an input
stream to read bytes from the source file, and an output stream to send bytes to the target file,
regardless of the file’s contents. The source file and the target file are specified from the command
line. Create an InputFileStream for the source file, and an OutputFileStream
for the target file. Use the read() method to read a byte from the input stream and then use
write(b) method to write the byte to the output stream. Use BufferedInputStream
and BufferedOutputStream to improve the performance. Listing 17.4 gives the solution
to the problem.
*/

import java.io.*;

public class E17L04 {
    public static void main(String[] args) throws IOException {
       /*  if (args.length != 2) {
            System.out.println("Usage: java E17L04 sourceFile targetFile");
            System.exit(1);
        }

        File source = new File(args[0]);
        if (!source.exists()) {
            System.out.println("Source file: " + args[0] + " does not exist.");
            System.exit(2);
        }

        File target = new File(args[1]);
        if (target.exists()) {
            System.out.println("Target file " + args[1] + " already exists.");
            System.exit(3);
        } */

        File source = new File("temp.dat");
        if (!source.exists()) {
            System.out.println("Source file: " + args[0] + " does not exist.");
            System.exit(2);
        }

        File target = new File("copy.dat");
        if (target.exists()) {
            System.out.println("Target file " + args[1] + " already exists.");
            System.exit(3);
        } 
       
        try (BufferedInputStream input = new BufferedInputStream(new FileInputStream(source));
                BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(target))) {
            int r, numberOfBytesCopied = 0;
            while ((r = input.read()) != -1) {
                output.write((byte) r);
                numberOfBytesCopied++;
            }
            System.out.println(numberOfBytesCopied + " bytes copied");
        }

    }
    
}

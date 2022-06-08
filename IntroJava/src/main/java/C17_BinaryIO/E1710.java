/* (Split files) Suppose you want to back up a huge file (e.g., a 10-GB AVI file) to a
CD-R. You can achieve it by splitting the file into smaller pieces and backing up
these pieces separately. Write a utility program that splits a large file into smaller
ones using the following command:
java Exercise17_10 SourceFile numberOfPieces
The command creates the files SourceFile.1, SourceFile.2, . . . , SourceFile.n,
where n is numberOfPieces and the output files are about the same size.
*/

import java.io.*;

public class E1710 {
    public static void main(String[] args) throws IOException {

        String filename = "E17_10.dat";
        int numberOfPieces = 3;
        
        try (RandomAccessFile raf = new RandomAccessFile(filename, "rw")) {
            long individualSize = raf.length() / numberOfPieces + 1;

            for (int i = 0; i < numberOfPieces; i++) {
                File newFile = new File(filename + "_" + (i+1) + ".dat");
                try (DataOutputStream output = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(newFile)))) {
                    for (int j = 0; j < individualSize; j++)
                        output.writeByte((byte)raf.read());
                }
                catch(EOFException ex) {
                    System.out.println("Done!");
                }
            }
        }
    }  
}

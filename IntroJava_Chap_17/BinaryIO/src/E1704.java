/* (Convert a text file into UTF) Write a program that reads lines of characters from
a text file and writes each line as a UTF string into a binary file. Display the
sizes of the text file and the binary file. Use the following command to run the
program: java Exercise17_04 Welcome.java Welcome.utf
*/

import java.io.*;

public class E1704 {
    public static void main(String[] args) throws IOException {

        /* if (args.length != 2) {
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
       
        try (BufferedReader input = new BufferedReader(new FileReader("README.md"));
             DataOutputStream output = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("E17_04out.bin")));) {
            String line = "";
            int filesize = 0;
            while ((line = input.readLine()) != null) {
                filesize += line.length();
                output.writeUTF(line);
            }
            System.out.println("File size " + filesize);
            System.out.println(output.size() + " bytes copied");
        }
    }
    
}

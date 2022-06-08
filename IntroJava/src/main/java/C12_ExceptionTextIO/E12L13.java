//File and PrintWriter class
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class E12L13 {
    public static void main(String[] args) throws IOException{
        //Create a file object to handle a file
        File file = new File("scores.txt");
        //Check if file exists
        if (file.exists()) {
            System.out.println("File already exists.");
            //You can delete the file
            System.out.println(file.delete() ? "file deleted." : "file not deleted");
            System.exit(1);
        }
        
        // Create a file, using try block automatically closes the file after writing
        // If file exists, writing will erase the content of existing file
        try (PrintWriter output = new PrintWriter(file)) {
            //Write into the file
            output.println("John T Smith");
            output.println(90);
        }
    }
}

package c12_ExceptionTextIO;
/*
For an application program to read data from a URL, you first need to create a URL object using
the java.net.URL class with this constructor:
public URL(String spec) throws MalformedURLException
*/
import java.util.Scanner;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.MalformedInputException;
public class E12L17 {
    public static void main(String[]args) {
        // url (uniform resource locator) is input as a string
        String urlStr = "http://www.google.com/index.html";

        // use try-catch for potential I/O Exceptions
        try{
            // create a URL object to access the web
            URL url = new URL(urlStr);
            int count = 0;
            // create a scanner to read from url (open input stream)
            Scanner input = new Scanner(url.openStream());
            while (input.hasNext()){
                String line = input.nextLine();
                count += line.length();
            }

            System.out.println("The file size is " + count + " characters");
        }
        // syntax erroe in the url string
        catch (MalformedInputException ex) {
            System.out.println("Invalid URL");
        }
        //
        catch (IOException ex){
            System.out.println("I/O errors: no such file");
        }
    }
}


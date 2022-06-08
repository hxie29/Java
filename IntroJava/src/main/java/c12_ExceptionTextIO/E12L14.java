package c12_ExceptionTextIO;// Scanner from a file
import java.io.File;
import java.util.Scanner;
public class E12L14 {
    public static void main(String[] args) throws Exception{
        File file = new File("scores.txt");

        Scanner input = new Scanner(file); 
        while (input.hasNext()) {
            String firstName = input.next();
            String miName = input.next();
            String lastName = input.next();
            int score = input.nextInt();
            System.out.println(firstName + miName + lastName + " has score of " + score);
        }
        input.close();
       
    }
}

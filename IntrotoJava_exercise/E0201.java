import java.util.Scanner;
public class E0201 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter miles number:");
        double miles = input.nextDouble();
        double kilometer = miles * 1.6;
        System.out.println( miles + " miles is equal to " + (int)(kilometer * 100) / 100.0 + " kilometers.");
    input.close();
    }
}

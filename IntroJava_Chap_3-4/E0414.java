import java.util.Scanner;

public class E0414 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a letter: ");
        char letter = input.nextLine().charAt(0);

        String grade = "abcdfABCDF";

        if (grade.contains(letter + "")) {
            System.out.print( "The numeric value for grade " + letter + " is ");
            switch (Character.toUpperCase(letter)) {
                case 'A': System.out.println(4); break;
                case 'B': System.out.println(3); break;
                case 'C': System.out.println(2); break;
                case 'D': System.out.println(1); break;
                case 'F': System.out.println(0); break;
            }
        }
        else {
            System.out.println(letter + " is an invalid input.");
        }

        input.close();
    }
}

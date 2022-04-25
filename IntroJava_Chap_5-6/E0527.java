import java.util.Scanner;

public class E0527 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the beginning year");
        int beginning = input.nextInt();
        System.out.println("Enter the ending year");
        int ending = input.nextInt();
        int count = 0;

        System.out.println("The leap years are:");

        //varify leap year
        for (int k = beginning; k <= ending; k++) {
            if (k % 4 == 0) {
                count++;
                System.out.print((count % 10 != 0) ? k + " " : k + "\n");
            }
        }
        System.out.println("\nThe number of leap years is " + count);
        input.close();
    }    
}

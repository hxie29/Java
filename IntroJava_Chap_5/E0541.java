import java.util.Scanner;

public class E0541 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int max = 0;
        int count = 0;

        // input and find max value
        while (true) {
            System.out.println("Enter a number:");
            int number = input.nextInt();

            // break loop if input is 0
            if (number == 0) break;

            if (number > max) {
                max = number;
                count = 1;
            }
            else if (number == max) {
                count++;
            }
        }

        // print result
        System.out.println("The max number is " + max);
        System.out.println("It appears " + count + " times.");
        input.close();
    }
}

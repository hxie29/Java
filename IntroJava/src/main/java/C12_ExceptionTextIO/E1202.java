/*
(ArrayIndexOutOfBoundsException) Using the two arrays shown below,
write a program that prompts the user to enter an integer between 1 and 12 and
then displays the months and its number of days corresponding to the integer
entered. Your program should display “wrong number” if the user enters a
wrong number by catching ArrayIndexOutOfBoundsException.

String[] months = {"January", "February", "March", "April",
"May", "June","July", "August", "September", "October",
"November", "December"};
int[] dom = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
*/
import java.util.Scanner;
public class E1202 {
    public static void main(String[] args) {
        String[] months = {"January", "February", "March", "April", "May", "June","July", "August", "September", "October", "November", "December"};
        int[] dom = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        Scanner input = new Scanner(System.in);
        System.out.println("Enter an inter between 1 and 12:");

        try {
            int n = input.nextInt();
            System.out.println("Month: " + months[n - 1] + " days: " + dom[n-1]);
        }

        catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Wrong number.");
        }

        input.close();

    }
}

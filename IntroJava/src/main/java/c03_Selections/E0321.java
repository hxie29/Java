package c03_Selections;// Zeller’s congruence is an algorithm developed by Christian Zeller to calculate the day of the week
import java.util.Scanner;

public class E0321 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // input value
        System.out.println("Please enter the year: ");
        int year = input.nextInt();
        System.out.println("Please enter the month: ");
        int month = input.nextInt();
        System.out.println("Please enter the day of the month: ");
        int day = input.nextInt();
        
        // adjusting day of the month
        if (month <= 2) {
            month += 12;
            year -= 1;
            System.out.println(month + " " + year);
        }

        // calculate the day of the week
        int h = (day + 26*(month + 1)/10 + 5* (year % 100) /4 + 21* (year /100) / 4) % 7;
        System.out.println(h);

        // print out result
        System.out.print("Day of the week is ");
        switch (h) {
            case 2 -> System.out.print("Monday");
            case 3 -> System.out.print("Tuesday");
            case 4 -> System.out.print("Wednesday");
            case 5 -> System.out.print("Thursday");
            case 6 -> System.out.print("Friday");
            case 0 -> System.out.print("Saturday");
            case 1 -> System.out.print("Sunday");
        }

        //close input
        input.close();
    }     
}

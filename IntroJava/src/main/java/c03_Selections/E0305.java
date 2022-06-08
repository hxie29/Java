package c03_Selections;

import java.util.Scanner;

public class E0305 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the day for today: ");
        int today = input.nextInt();
        System.out.println("Please enter days after today: ");
        int days = input.nextInt();
        int futureDay = (today + days) % 7;

        System.out.print("Today is ");
        switch (today) {
            case 1 -> System.out.print("Monday");
            case 2 -> System.out.print("Tuesday");
            case 3 -> System.out.print("Wednesday");
            case 4 -> System.out.print("Thursday");
            case 5 -> System.out.print("Friday");
            case 6 -> System.out.print("Saturday");
            case 0 -> System.out.print("Sunday");
        }
        System.out.print(" and the future day is ");
        switch (futureDay) {
            case 1 -> System.out.print("Monday");
            case 2 -> System.out.print("Tuesday");
            case 3 -> System.out.print("Wednesday");
            case 4 -> System.out.print("Thursday");
            case 5 -> System.out.print("Friday");
            case 6 -> System.out.print("Saturday");
            case 0 -> System.out.print("Sunday");
        }
    input.close();
    }
}


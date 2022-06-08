/*
(Display calendars) Rewrite the PrintCalendar class in Listing 6.12 to display
a calendar for a specified month using the Calendar and GregorianCalendar
classes. Your program receives the month and year from the command line. For
example:
java Exercise13_04 5 2016
You can also run the program without the year. In this case, the year is the current
year. If you run the program without specifying a month and a year, the month is
the current month.
*/
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class E1304 {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: E1304.java monthNumber yearNumber");
            System.exit(1);
        }

        int year = Integer.parseInt(args[1]);
        int month = Integer.parseInt(args[0]);
        Calendar calendar = new GregorianCalendar(year, month - 1, 1);

        // print calendar
        printCalendar(calendar);
    }
    
    
    public static void printCalendar(Calendar calendar) {
        printMonthTitle(calendar);
        printMonthBody(calendar);
    }
    
    
    public static void printMonthTitle(Calendar calendar) {
        String[] monthName = {"January", "Feburary", "March", "April", "May", "June", "July", 
        "August", "September", "October", "November", "December"};

        System.out.printf("%25s %-4d\n", monthName[calendar.get(Calendar.MONTH)], calendar.get(Calendar.YEAR));
        System.out.println("-------------------------------------------------------");
        System.out.printf("%7s%7s%7s%7s%7s%7s%7s\n", "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat");
    }

    public static int getStartDay(Calendar calendar) {
        return calendar.get(Calendar.DAY_OF_WEEK) - 1;
    }
    
    public static void printMonthBody(Calendar calendar) {
        for (int i = getStartDay(calendar); i > 0; i--) {
            System.out.print("       ");
        }
        for (int i = 1; i <= getTotalNumbersOfDaysThisMonth(calendar); i++) {
            System.out.printf("%7d", i);
            // switch a line if item of the line is 7
            if ((i + getStartDay(calendar)) % 7 == 0) {
                System.out.println();
            }
        }
    }  

    public static int getTotalNumbersOfDaysThisMonth(Calendar calendar) {
        return calendar.getActualMaximum(Calendar.DATE);
    }

}
